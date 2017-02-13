package myservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login1
 */
@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomePageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		int busno = Integer.parseInt(request.getParameter("bno"));
		String trip = String.valueOf(request.getParameter("trip"));
		
		HttpSession sess = request.getSession();
		
		
		sess.setAttribute("busNo", busno);
		sess.setAttribute("trip", trip);

		DbManager dm = new DbManager();
		dm.assingBus(busno,trip,Integer.parseInt(String.valueOf(sess.getAttribute("cid"))));
		RequestDispatcher rd = request.getRequestDispatcher("/CurrStopForm.jsp");
		rd.include(request, response);
		
	}

}
