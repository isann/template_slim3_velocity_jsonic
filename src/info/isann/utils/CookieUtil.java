package info.isann.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Cookieのユーティリティクラスです。
 * @author isann
 *
 */
public class CookieUtil {

	/**
	 * 指定のCookie名でCookieの値を取得します。
	 * @param req
	 * @param cookieName
	 * @return 取得したCookieの値を返却します。第一引数がNULL、もしくは取得できなかった場合はNULLを返却します。
	 */
	public static String getCookieValue(HttpServletRequest req, String cookieName){
		String result = null;
		if(cookieName == null){
			return result;
		}
		Cookie[] cookies = req.getCookies();
		if(cookies == null){
			return result;
		}
		for(Cookie cookie : cookies){
			if(!cookieName.equals(cookie.getName())){
				continue;
			}
			result = cookie.getValue();
		}
		return result;
	}
	
}
