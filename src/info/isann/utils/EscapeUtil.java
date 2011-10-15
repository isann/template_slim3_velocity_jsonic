package info.isann.utils;

/**
 * 各エスケープクラスのインスタンスを静的に保持するためのクラスです。
 * @author isann
 *
 */
public class EscapeUtil {

	/** HTMLエスケープ */
	public static HtmlEscape htmlEscape = HtmlEscape.get();  

}
