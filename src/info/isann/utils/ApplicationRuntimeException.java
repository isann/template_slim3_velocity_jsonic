package info.isann.utils;


/**
 * アプリケーション内で発生したエラーの際に生成する例外クラスです。
 * 非チェック例外クラスを継承しているため、非チェック例外が発生します。
 * @author isann
 *
 */
public class ApplicationRuntimeException extends RuntimeException {

	public ApplicationRuntimeException(){
		super();
	}

	public ApplicationRuntimeException(String paramString)
	{
		super(paramString);
	}

	public ApplicationRuntimeException(String paramString, Throwable paramThrowable)
	{
		super(paramString, paramThrowable);
	}

	public ApplicationRuntimeException(Throwable paramThrowable)
	{
		super(paramThrowable);
	}
	/**
	 * 
	 */
	 private static final long serialVersionUID = -8952382282853289674L;

}
