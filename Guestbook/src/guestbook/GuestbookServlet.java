package guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class GuestbookServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
		req.setAttribute("msg", "Hello, world");;
		//req.getRequestDispatcher("test.jsp").forward(req, resp);
		req.getRequestDispatcher("test2.jsp").forward(req, resp);
	
	}
	

}

