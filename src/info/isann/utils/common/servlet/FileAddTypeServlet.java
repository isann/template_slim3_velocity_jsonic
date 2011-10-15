package info.isann.utils.common.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ファイルにカスタ�??MIMEタイプを付与するため�?サーブレ�?��クラスです�?
 * 多くの場合�?web.xmlのmime-mappingでextensionとmime-typeを�?�?��ングする�?��で
 * 代替可能です�?
 * @author isann
 *
 */
@SuppressWarnings("serial")
public class FileAddTypeServlet extends HttpServlet {

	private static final Logger logger = Logger.getLogger(FileAddTypeServlet.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {

		// target file
		String targetpath = req.getRequestURI();
		logger.fine("request uri is : " + targetpath);
		int start = targetpath.lastIndexOf("/") + 1;
		int last  = targetpath.length();
		targetpath = "/resouces/" + targetpath.substring(start, last);
		logger.fine("target path is ... : " + targetpath);

		// resource file
		InputStream is = null;

		try{
			is = this.getServletContext().getResourceAsStream(targetpath);

			// check: is file avalable?
			if (is == null) {
				// not exist				resp.setContentType("text/plain");
				resp.getWriter().println("File not found...");
			} else {
				// file exist
				int filesize = is.available();

				// set response header
				setResponseHeader(resp, targetpath, filesize);

				// output
				OutputStream out = resp.getOutputStream();
				byte[] byteBuf = new byte[8192];
				for (;;) {
					int iRead = is.read(byteBuf, 0, byteBuf.length);
					if (iRead < 0) {
						break;
					}
					out.write(byteBuf, 0, iRead);
				}
			}
		} finally{
			if(is != null){
				is.close();
			}
		}
	}

	private void setResponseHeader(final HttpServletResponse response,
			String filename, final int fileLength) {
		if (filename.endsWith(".pdf")) {
			// PDF
			response.setContentType("application/pdf");
		} else if (filename.endsWith(".xls")) {
			// Excel
			response.setContentType("application/vnd.ms-excel");
		} else if (filename.endsWith(".xml")) {
			// XML
			response.setContentType("text/xml");
		} else if (filename.endsWith(".jad")) {
			// JAD
			response.setContentType("text/vnd.sun.j2me.app-descriptor");
		} else if (filename.endsWith(".cod")) {
			// COD
			response.setContentType("application/vnd.rim.cod");
		} else if (filename.endsWith(".ogg")) {
			// OGG
			response.setContentType("video/ogg");
		} else if (filename.endsWith(".ogv")) {
			// OGV
			response.setContentType("video/ogg");
		} else if (filename.endsWith(".mp4")) {
			// MP4
			response.setContentType("video/mp4");
		} else if (filename.endsWith(".webm")) {
			// WEBM
			response.setContentType("video/webm");
		} else if (filename.endsWith(".wav")) {
			// PCM
			response.setHeader("Accept-Ranges", "bytes");
			response.setHeader("Connection", "Keep-Alive");
			response.setHeader("Cache-Control", "public");
			response.setContentType("audio/x-wav");
			response.setHeader("Date", new Date().toString());
			response.setHeader("ETag", "\"1000000038395-1d70-4a49322f74cb3\"");
			response.setHeader("Keep-Alive", "timeout=5, max=100");
		} else if (filename.endsWith(".mp3")) {
			// MP3
			response.setHeader("Accept-Ranges", "bytes");
			response.setHeader("Connection", "Keep-Alive");
			response.setHeader("Cache-Control", "public");
			response.setContentType("audio/mpeg");
			response.setHeader("Date", new Date().toString());
			response.setHeader("ETag", "\"1000000038395-1d70-4a49322f74cb3\"");
			response.setHeader("Keep-Alive", "timeout=5, max=100");
		} else {
			// other is binary
			response.setContentType("application/octet-stream");
		}
		logger.fine("ContentType : " + response.getContentType());

		if (fileLength > 0) {
			// Length
			response.setContentLength(fileLength);
		}

		// Disable cache
//		response.addHeader("Cache-Control", "no-cache");
//		response.addHeader("Pragma", "no-cache");
//		response.addHeader("Expires", "0");
	}

}
