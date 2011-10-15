package info.isann.utils.common.servlet;

import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.isann.utils.Renderer;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

@SuppressWarnings({ "serial" })
public class VelocityCommonServlet extends VelocityViewServlet{

    static final Logger logger = Logger.getLogger(VelocityCommonServlet.class.getName());

    @SuppressWarnings("unchecked")
    protected Template handleRequest(HttpServletRequest req,
            HttpServletResponse res, Context ctx) {

        String uri = req.getRequestURI();
        logger.fine("request url is " + uri);
        /* 繝?プレートレスポンス */
        String template = "WEB-INF/template" + uri;
        logger.fine("templatefile is " + template);
        //        Context context = new VelocityContext();
        Enumeration<String> e = req.getAttributeNames();
        logger.fine("▼▼▼▼▼");
        while(e.hasMoreElements()) {
            String key = e.nextElement();
            ctx.put(key, req.getAttribute(key));
            //            logger.fine(key + "?? + req.getAttribute(key));
            logger.fine(key);
        }
        logger.fine("△△△△△");
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        //        Renderer.render(template, context, res.getWriter());
        return Renderer.getRenderTemplate(template, ctx);

        //        String templateName = "index.vm";
        //        ctx.put("message", req.getAttribute("message"));
        //        return getTemplate(templateName);
    }

//        public void doPost(HttpServletRequest req, HttpServletResponse resp)
//        throws ServletException, IOException {
//            logger.fine("笘??笘?m post笘??笘?);
//            createView(req, resp);
//        }
//    
//        public void doGet(HttpServletRequest req, HttpServletResponse resp)
//        throws ServletException, IOException {
//            logger.fine("笘??笘?m get笘??笘?);
//            createView(req, resp);
//        }
//        
//        @SuppressWarnings("unchecked")
//        private void createView(HttpServletRequest req, HttpServletResponse resp) throws IOException{
//            String uri = req.getRequestURI();
//            logger.fine("リクエス繝?RI?? + uri);
//            /* 繝?プレートレスポンス */
//            String template = "WEB-INF/template" + uri;
//            logger.fine("繝?プレートファイル?? + template);
//            Context context = new VelocityContext();
//            Enumeration<String> e = req.getAttributeNames();
//            logger.fine("▼▼▼▼▼");
//            while(e.hasMoreElements()) {
//                String key = e.nextElement();
//                context.put(key, req.getAttribute(key));
//                //            logger.fine(key + "?? + req.getAttribute(key));
//                logger.fine(key);
//            }
//            logger.fine("△△△△△");
//            resp.setContentType("text/html");
//            resp.setCharacterEncoding("UTF-8");
//            Renderer.render(template, context, resp.getWriter());
//        }

}
