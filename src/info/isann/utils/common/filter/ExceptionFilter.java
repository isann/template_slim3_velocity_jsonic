package info.isann.utils.common.filter;

import info.isann.utils.HtmlEscape;
import info.isann.utils.LogMessages;
import info.isann.utils.Renderer;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;

/**
 * すべての例外をキャ�?��するためのフィルタクラスです�?
 * @author isann
 *
 */
public class ExceptionFilter implements Filter{

	private static final Logger logger = Logger.getLogger(ExceptionFilter.class.getName());

	/**
	 * フィルタクラスのオーバ�?ライドメソ�?��です�?
	 * 終�?��に利用しますが、このメソ�?��では特に何もしません�?
	 */
	public void destroy() {
	}

	/**
	 * try-catch�?��フィルタチェーンを行います�?
	 * @param req リクエストオブジェク�?
	 * @param resp レスポンスオブジェク�?
	 * @param chain フィルタチェーンオブジェク�?
	 * @throws IOException フィルタチェーンに失敗した際、もしくはにペ�?ジのレン�?��ングに失敗した際にスローされる例外です�?
	 * @throws ServletException フィルタチェーンに失敗した際にスローされる例外です�?
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		try{
			HttpServletRequest r = (HttpServletRequest)req;
			String path = r.getRequestURL().toString();
			String userAgent = (String)r.getHeader("user-agent");
			String acceptLanguage = (String)r.getHeader("Accept-Language");
			logger.fine("リクエス�?RL ??" + path);
			logger.fine("UserAgent ??" + userAgent);
			logger.fine("Accept-Language ??" + acceptLanguage);
			chain.doFilter(req, resp);
		} catch(Exception e){
			try{
				String template = "WEB-INF/template/error.vm";
				Context context = new VelocityContext();
				context.put("trace", HtmlEscape.get().escapeAndTag(LogMessages.getStackTrace(e)));
				resp.setContentType("text/html");
				resp.setCharacterEncoding("UTF-8");
				Renderer.render(template, context, resp.getWriter());
			} finally {
				logger.severe(LogMessages.ERROR_0001_MESSAGE);
				logger.severe(LogMessages.getStackTrace(e));
			}
		}

	}

	/**
	 * フィルタクラスのオーバ�?ライドメソ�?��です�?
	 * 初期化時に利用しますが、このメソ�?��では特に何もしません�?
	 */
	public void init(FilterConfig config) throws ServletException {
	}

}
