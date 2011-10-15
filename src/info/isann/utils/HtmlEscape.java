package info.isann.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ページ内にコンテンツを表示する際のHTMLエスケープなどを行うヘルパクラスです。
 * @author isann
 *
 */
public class HtmlEscape {
	
    private static HtmlEscape instance = new HtmlEscape();
    
    private HtmlEscape(){}
    
    /**
     * sigletonなオブジェクトを取得します。
     * @return
     */
    public static HtmlEscape get() {
        return instance;
    }
    
    /**
     * HTMLエスケープを行います。
     * @param input
     * @return
     */
    public String escape(String input) {
        String tmp = input;
        tmp = tmp.replace("&", "&amp;");
        tmp = tmp.replace("\"", "&quot;");
        tmp = tmp.replace(">", "&gt;");
        tmp = tmp.replace("<", "&lt;");
        tmp = tmp.replace("'", "&#039;");
        return tmp;
    }

    /**
     * 改行を HTMLタグの\<br\> に変換します。
     */
    public String replaceCR(String input) {
        return input.replace("\n", "<br/>\n");
    }

    /**
     * HTMLエスケープとHTMLタグ変換を実行します。
     * @param input
     * @return
     */
    public String escapeAndTag(String input) {
        input = escape(input);
        input = autoTag(input);
        return replaceCR(input);
    }

    /**
     * URLをリンクとして表示します。
     */
    public String autoTag(String input) {
        Pattern pat = Pattern.compile("https?://[^ \t\n]*");
        Matcher m = pat.matcher(input);
        int start = 0;
        StringBuffer sb = new StringBuffer();
        while (m.find(start)) {
            sb.append(input, start, m.start());
            String tmp = input.substring(m.start(), m.end());
            sb.append("<a href=\"" + tmp + "\">" + tmp + "</a>" );
            start = m.end();
        }
        sb.append(input, start, input.length());
        return sb.toString();
    }
}
