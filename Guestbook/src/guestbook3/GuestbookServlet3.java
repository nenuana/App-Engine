package guestbook3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class GuestbookServlet3 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
		req.setAttribute("msg2", "Hello, world");
		//req.getRequestDispatcher("test.jsp").forward(req, resp);
		req.getRequestDispatcher("test3.jsp").forward(req, resp);
	
	}
}
