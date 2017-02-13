package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Myservlet
 */
@WebServlet("/Myservlet")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String curr;
	private String location;
	private ServletRequest request;

	public Myservlet() {
		super();

	}

	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); // informing the client that which

		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String passenger = id;
		if (id == passenger) {
			String loc = request.getParameter("curr");
			String bno = request.getParameter("bno");
			String trip = request.getParameter("trip");// current lcation from
			// System.out.println("current loctaion is  " + loc);
			DbManager b1 = new DbManager();
			// b1.bus();
			//b1.currloc(loc, bno, trip);
		} else {
			System.out.println("id not matched");
		}

	}

}
