package info.isann.utils;

/**
 * アプリケーション内で共有する文字列定数クラスです。
 * @author isann
 *
 */
public class Const {
	
	//*********************************************************************
	//JSONで利用するアプリケーションのステータスコード
	//*********************************************************************
	/** ステータスコード：成功 */
	public static final int STATUS_CODE_SUCCESS = 0;
	/** ステータスコード：失敗 */
	public static final int STATUS_CODE_FAILER = -1;

	//*********************************************************************
	//カインド 共通プロパティ名 リフレクションで利用
	//*********************************************************************
	/** 登録日エンティティプロパティ名 */
	public static final String REGISTER_DATE_METHOD_NAME = "registerDate";
	/** 登録者エンティティプロパティ名 */
	public static final String REGISTER_ID_METHOD_NAME = "registerId";
	/** 更新日エンティティプロパティ名 */
	public static final String UPDATE_DATE_METHOD_NAME = "updateDate";
	/** 更新者エンティティプロパティ名 */
	public static final String UPDATE_ID_METHOD_NAME = "udpateId";
	/** 削除日エンティティプロパティ名 */
	public static final String DELETE_DATE_METHOD_NAME = "deleteDate";
	/** 削除者 エンティティプロパティ名*/
	public static final String DELETE_ID_METHOD_NAME = "deleteId";
	/** 削除フラグエンティティプロパティ名 */
	public static final String DELETE_FLG_METHOD_NAME = "deleteFlg";
	/** アプリケーションID WEB */
	public static final String APP_ID_WEB = "WEB";
	/** アプリケーションID CRON */
	public static final String APP_ID_CRON = "CRON";
	/** アプリケーションID QUE */
	public static final String APP_ID_QUE = "QUE";
	/** アプリケーションID MAIL */
	public static final String APP_ID_MAIL = "MAIL";

}
