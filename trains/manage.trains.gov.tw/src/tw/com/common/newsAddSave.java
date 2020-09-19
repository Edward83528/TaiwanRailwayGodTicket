package tw.com.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class uploadPoto
 */
@WebServlet("/newsAddSave")
@MultipartConfig
public class newsAddSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int counter;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

		Part part = req.getPart("upload");

		Collection<String> cc = part.getHeaderNames();
		for (String header : cc) {

			String v = part.getHeader(header);
			out.println(header + ":" + v + "<br />");
		}

		String filename = part.getSubmittedFileName();
		out.print(filename + "<br>");
		String name = part.getName(); // html input name
		int size = (int) part.getSize();
		out.print(name + ":" + size + "<br/>");

		// 以下開始讀取資料
		byte[] buf = new byte[size];
		BufferedInputStream bin = new BufferedInputStream(part.getInputStream());
		bin.read(buf);
		bin.close();

		ServletContext context = getServletContext();
		String Id = req.getParameter("Id");
		String Subject = req.getParameter("Subject");
		String Content = req.getParameter("Content");
		String Link = req.getParameter("Link");
		// 新增到資料庫
		TrainData t = new TrainData();
		boolean a = t.AddNews(Subject, Content, Link, filename);
		if (a == true) {
			System.out.println("新增成功");
			RequestDispatcher rd = req.getRequestDispatcher("/new.jsp");
			rd.forward(req, resp);
		} else {
			System.out.println("新增失敗");
			RequestDispatcher rd = req.getRequestDispatcher("/new.jsp");
			rd.forward(req, resp);
		}

		String uploadPath = context.getInitParameter("upload-path");

		FileOutputStream fout = new FileOutputStream(new File(uploadPath, filename));

		fout.write(buf);
		fout.flush();
		fout.close();

	}

}
