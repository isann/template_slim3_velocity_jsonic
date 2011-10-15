package info.isann.utils;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.logging.Logger;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Transaction;

/**
 * Slim3ローカルトランザクションマネージャクラスです。
 * トランザクションのテンプレート処理を行います。
 * @author isann
 *
 */
public class Slim3LocalTransactionManager {
	static Logger logger = Logger.getLogger(Slim3LocalTransactionManager.class.getName());

	/**
	 * トランザクション内で実行するコードセグメントを表すインナークラスのインターフェイスです。
	 */
	public static abstract class Slim3LocalTransactionManagerBody { 
		public List<Object> ret = new ArrayList<Object>();
		/**
		 * {@link Slim3LocalTransactionManager}のstartメソッドで実行されるメソッドです。
		 * ここに、トランザクション内で実行するコードを記述します。
		 * @param params {@link Slim3LocalTransactionManager#execute(int, Body, Object[])}で第三引数に渡されたObject配列の値。
		 * @throws ApplicationRuntimeException
		 */
		protected abstract void run(Object[] params) 
		throws ApplicationRuntimeException;
	}

	/**
	 * トランザクション処理を開始する際のメソッドです。
	 * @param retryCount コミット失敗時にリトライする回数。
	 * @param runnable トランザクション内で実行するコードを記述したBodyクラスの実装インスタンス。
	 * @param params {@link Body}クラスに引き渡すパラメータです。
	 * @return データストア更新成功:true データストア更新失敗:false
	 * @throws ApplicationRuntimeException {@link Body}クラスでの例外時にApplicationExceptionがスローされます。
	 */
	public static boolean start(Slim3LocalTransactionManagerBody runnable, int retryCount) 
	throws ApplicationRuntimeException{ 
		return execute(runnable, null, retryCount);
	}

	/**
	 * トランザクション処理を開始する際のメソッドです。
	 * @param retryCount コミット失敗時にリトライする回数。
	 * @param runnable トランザクション内で実行するコードを記述したBodyクラスの実装インスタンス。
	 * @param params {@link Body}クラスに引き渡すパラメータです。
	 * @return データストア更新成功:true データストア更新失敗:false
	 * @throws ApplicationRuntimeException {@link Body}クラスでの例外時にApplicationExceptionがスローされます。
	 */
	public static boolean start(Slim3LocalTransactionManagerBody runnable, Object[] params, int retryCount) 
	throws ApplicationRuntimeException{ 
		return execute(runnable, params, retryCount);
	}

	/**
	 * トランザクション処理のテンプレート処理を行うメソッドです。
	 * @param runnable トランザクション内で実行するコードを記述したBodyクラスの実装インスタンス。
	 * @param params {@link Body}クラスに引き渡すパラメータです。
	 * @param retryCount コミット失敗時にリトライする回数。
	 * @return データストア更新成功:true データストア更新失敗:false
	 * @throws ApplicationRuntimeException {@link Body}クラスでの例外時にApplicationExceptionがスローされます。
	 */
	private static boolean execute(
			Slim3LocalTransactionManagerBody runnable,
			Object[] params,
			int retryCount) throws ApplicationRuntimeException{
		while (retryCount >= 0) {
			Transaction tx = null;
			tx = Datastore.beginTransaction();
			runnable.run(params);
			try {
				tx.commit();
			} catch (ConcurrentModificationException e) {
				retryCount--;
				logger.warning(LogMessages.WARNING_0008_MESSAGE 
						+ LogMessages.logParams(" retryCount:", retryCount));
				continue;
			}
			logger.fine(LogMessages.DEBUG_0005_MESSAGE 
					+ LogMessages.logParams(" retryCount:", retryCount));
			logger.fine(LogMessages.logParams2(params));
			return true;
		}
		logger.severe(LogMessages.ERROR_0004_MESSAGE 
				+ LogMessages.logParams(" retryCount:", retryCount));
		logger.severe(LogMessages.logParams2(params));
		return false; // failed to commit eventually.

	}
}

