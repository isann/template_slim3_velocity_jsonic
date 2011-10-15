package info.isann.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * ログ出力する際の文字列を保持するクラスです。
 * @author isann
 *
 */
public class LogMessages {

	/**
	 * ログ出力するパラメータ文字列を生成します。
	 * @param objects
	 * @return
	 */
	public static String logParams(Object... objects){
		StringBuilder sb = null;
		if(objects == null){
			return "";
		}
		try{
			sb = new StringBuilder("");
			for(Object obj : objects){
				sb.append(obj);
			}
		} catch(Exception e){
			return "log generate failer...";
		}
		return sb.toString();
	}

	/**
	 * ログ出力するパラメータ文字列を生成します。
	 * @param objects
	 * @return
	 */
	public static String logParams2(Object[] objects){
		StringBuilder sb = null;
		if(objects == null){
			return "";
		}
		try{
			sb = new StringBuilder(" [");
			for(int i = 0; i < objects.length; i++){
				if(i == objects.length - 1){
					sb.append(objects[i]);
					sb.append("]");
				} else {
					sb.append(objects[i]);
					sb.append("] [");
				}
			}
		} catch(Exception e){
			return "log generate failer...";
		}
		return sb.toString();
	}

	/**
	 * スタックトレース文字列を取得します。
	 * @param e
	 * @return スタックトレース文字列を返却します。<br>
	 * 引数がNULLの場合はから文字を返却します。<br>
	 * 例外時はExceptionのtoString文字列を返却します。
	 */
	public static String getStackTrace(Exception e){
		String trace = null;
		if(e == null) return "";
		try { 
			StringWriter sw = null;
			PrintWriter  pw = null;

			sw = new StringWriter();
			pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			trace = sw.toString();

			if ( sw != null ) {
				sw.flush();
				sw.close();
			} 
			if ( pw != null ) {
				pw.flush();
				pw.close();
			}
		} catch (IOException ignore){
			StringBuilder sb = new StringBuilder();
			sb.append("エラーログのスタックトレース出力中にIOExceptionが発生しました。\n")
			.append("START---------------------------元のエラー---------------------------\n")
			.append(e.toString())
			.append("\nEND  ---------------------------元のエラー---------------------------\n")
			.append("\nSTART---------------------------エラーログのスタックトレース出力中エラー---------------------------\n")
			.append(ignore.toString())
			.append("\nEND  ---------------------------エラーログのスタックトレース出力中エラー---------------------------\n");
			trace = sb.toString();
		} catch (Exception ignore){
			StringBuilder sb = new StringBuilder();
			sb.append("エラーログのスタックトレース出力中にIOExceptionが発生しました。\n")
			.append("START---------------------------元のエラー---------------------------\n")
			.append(e.toString())
			.append("\nEND  ---------------------------元のエラー---------------------------\n")
			.append("\nSTART---------------------------エラーログのスタックトレース出力中エラー---------------------------\n")
			.append(ignore.toString())
			.append("\nEND  ---------------------------エラーログのスタックトレース出力中エラー---------------------------\n");
			trace = sb.toString();
		}
		return trace;
	}

	public static final String THREAD_NAME = Thread.currentThread().getName();

	/****************************************************************
	 * DEBUG
	 ****************************************************************/
	public static final String DEBUG_0005_MESSAGE = "[DEBUG_0005] - コミットに成功しました。";

	public static final String DEBUG_0007_MESSAGE = "[DEBUG_0007] - 処理が正常に終了しました。";

	/****************************************************************
	 * INFO
	 ****************************************************************/
	public static final String INFO_0001_MESSAGE = "";

	/****************************************************************
	 * WARNING
	 ****************************************************************/
	public static final String WARNING_0001_MESSAGE = "[WARNING_0001] - バリデーションエラーです。";

	public static final String WARNING_0008_MESSAGE = "[WARNING_0008] - データストアの更新に失敗しました。リトライします。";

	public static final String WARNING_0009_MESSAGE = "[WARNING_0009] - 二重リクエストです。";

	public static final String WARNING_0010_MESSAGE = "[WARNING_0010] - Memcacheの処理に失敗しました。";

	public static final String WARNING_0011_MESSAGE = "[WARNING_0011] - データストアの更新に失敗しました。シャード数をインクリメントしてリトライします。";

	public static final String WARNING_0012_MESSAGE = "[WARNING_0012] - データストアの更新に失敗しました。楽観ロックエラーです。リトライ回数までリトライします。";

	/****************************************************************
	 * ERROR
	 ****************************************************************/
	public static final String ERROR_0001_MESSAGE = "[ERROR_0001] - 予期せぬ例外が発生しました。";

	public static final String ERROR_0004_MESSAGE = "[ERROR_0004] - データストアの更新に失敗しました。";

	public static final String ERROR_0007_MESSAGE = "[ERROR_0007] - エンティティの操作で例外が発生しました。";

	public static final String ERROR_0008_MESSAGE = "[ERROR_0008] - Twitterとの処理で何らかの例外が発生しました。";

	public static final String ERROR_0009_MESSAGE = "[ERROR_0009] - Facebookとの処理で何らかの例外が発生しました。";

	public static final String ERROR_0010_MESSAGE = "[ERROR_0010] - Memcacheの処理で何らかの例外が発生しました。";

}
