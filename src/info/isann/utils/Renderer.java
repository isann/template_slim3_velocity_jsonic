package info.isann.utils;

import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Logger;

import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.apache.velocity.runtime.log.JdkLogChute;

/**
 * テンプレートのVelocityをレンダリングするクラスです。
 * @author isann
 *
 */
public class Renderer {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(Renderer.class.getName());
	
	private static boolean initialized = false;
	
	/**
	 * Velocityの初期化を行います。
	 * @throws Exception
	 */
	private static void initializeVelocity() throws Exception {
		Velocity.setProperty(
				Velocity.RUNTIME_LOG_LOGSYSTEM, new JdkLogChute());
		Velocity.setProperty(
				Velocity.INPUT_ENCODING, "UTF-8");              
		Velocity.setProperty(
				Velocity.OUTPUT_ENCODING, "UTF-8");              
		Velocity.init();
		initialized = true;
	}

	private static DateFormat dateTimeFormat = 
		DateFormat.getDateTimeInstance(DateFormat.MEDIUM, 
				DateFormat.MEDIUM, Locale.JAPAN); 
	private static DateFormat dateFormat = 
		DateFormat.getDateInstance(DateFormat.LONG, Locale.JAPAN); 
	private static DateFormat timeFormat = 
		DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.JAPAN); 
	static {
		dateTimeFormat.setTimeZone(TimeZone.getTimeZone("JST"));
		dateFormat.setTimeZone(TimeZone.getTimeZone("JST"));
		timeFormat.setTimeZone(TimeZone.getTimeZone("JST"));
	}
	private static HtmlEscape htmlEscape = HtmlEscape.get();  


    /**
     * テンプレートファイルをレンダリングします。
     * @param filename
     * @param context
     * @param writer
     * @throws IOException
     */
    public static void render(String filename, Context context, Writer writer) {
        try {
            synchronized (Renderer.class) { 
                if (!initialized)  
                    initializeVelocity();
            }
            context.put("_datetimeFormat", dateTimeFormat);
            context.put("_dateFormat",     dateFormat);
            context.put("_timeFormat",     timeFormat);
            context.put("_htmlEscape",     htmlEscape);
            Template template = Velocity.getTemplate(filename); 
            template.merge(context, writer);
        } catch (Exception e) {
            throw new ApplicationRuntimeException(e);
        }
    }
    /**
     * テンプレートファイルをレンダリングします。
     * @param filename
     * @param context
     * @param writer
     * @throws IOException
     */
    public static Template getRenderTemplate(String filename, Context context) {
        try {
            synchronized (Renderer.class) { 
                if (!initialized)  
                    initializeVelocity();
            }
            context.put("_datetimeFormat", dateTimeFormat);
            context.put("_dateFormat",     dateFormat);
            context.put("_timeFormat",     timeFormat);
            context.put("_htmlEscape",     htmlEscape);
            Template template = Velocity.getTemplate(filename);
            return template;
//            template.merge(context, writer);
        } catch (Exception e) {
            throw new ApplicationRuntimeException(e);
        }
    }
}
