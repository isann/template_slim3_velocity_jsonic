package info.isann.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * チェックに関するユーティリティクラスです。
 * @author isann
 *
 */
public class CheckUtils {

	private static Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");

	/**
	 * 引数で指定された文字が半角英数字のみかチェックする
	 * @param checkText
	 * @return true 半角英数字のみ false 半角英数字以外を含む
	 */
	public static boolean isAlphabetOrNumeric(String checkText){
		Matcher matcher = pattern.matcher(checkText);
		boolean blnMatch= matcher.matches();
		return blnMatch;
	}

	/**
	 * 引数で指定された文字が半角英数字のみかチェックする
	 * @param checkText
	 * @return true 半角英数字以外を含む false 半角英数字のみ
	 */
	public static boolean isNotAlphabetOrNumeric(String checkText){
		checkText = checkText.toLowerCase();
		Matcher matcher = pattern.matcher(checkText);
		boolean blnMatch= matcher.matches();
		return !blnMatch;
	}

}
