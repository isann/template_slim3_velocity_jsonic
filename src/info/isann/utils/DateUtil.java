package info.isann.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;

/**
 * 現在日付を取得するユーティリティクラスです。
 * @author isann
 *
 */
public class DateUtil {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(DateUtil.class.getName());
	public static final String DATE_PATTERN = "yyyy/MM/dd HH:mm:ss.SSS"; 
	
	/**
	 * 現在日付を文字列で「yyyy/MM/dd HH:mm:ss.SSS」のフォーマットで取得します。
	 * @return 取得した日付文字列を返却します。
	 */
	public static String getCurrentDateString(){
		TimeZone.setDefault(TimeZone.getTimeZone("JST"));//インスタンスがいつ落ちるかわからないので毎回念の為に設定しておく
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		return sdf.format(date);
	}
	
}
