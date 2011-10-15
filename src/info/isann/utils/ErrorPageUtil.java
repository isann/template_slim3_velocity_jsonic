package info.isann.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;

/**
 * エラーページに関するユーティリティクラスです。
 * @author isann
 *
 */
public class ErrorPageUtil {

	public static void render(HttpServletResponse resp, String message) throws IOException{
		String template = "WEB-INF/template/error.vm";
		Context context = new VelocityContext();
		context.put("trace", "");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		Renderer.render(template, context, resp.getWriter());
	}

	public static void render(HttpServletResponse resp, Exception e) throws IOException{
		String template = "WEB-INF/template/error.vm";
		Context context = new VelocityContext();
		context.put("trace", "");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		Renderer.render(template, context, resp.getWriter());
	}

	public static void renderForEn(HttpServletResponse resp, String message) throws IOException{
		String template = "WEB-INF/template/error.vm";
		Context context = new VelocityContext();
		context.put("trace", "");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		Renderer.render(template, context, resp.getWriter());
	}

	public static void renderForEn(HttpServletResponse resp, Exception e) throws IOException{
		String template = "WEB-INF/template/error.vm";
		Context context = new VelocityContext();
		context.put("trace", "");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		Renderer.render(template, context, resp.getWriter());
	}

}
