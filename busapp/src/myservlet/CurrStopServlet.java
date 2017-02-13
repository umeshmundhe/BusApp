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
 * Servlet implementation class Currloc
 */
@WebServlet("/CurrStopServlet")
public class CurrStopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CurrStopServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String act = request.getParameter("ok");

		HttpSession session = request.getSession();
		DbManager db2 = new DbManager();

		if (act == null) {
			// no button has been selected
		} else if (act.equals("Submit")) {

			db2.updateCurrentLocation(String.valueOf(request
					.getParameter("curr")), Integer.parseInt(String
					.valueOf(session.getAttribute("busNo"))));
			RequestDispatcher rd = request.getRequestDispatcher("/CurrStopForm.jsp");
			rd.include(request, response);

		} else if (act.equals("LastStop")) {

			db2.deleteTrace(Integer.parseInt(String.valueOf(session
					.getAttribute("busNo"))));
			RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
			rd.include(request, response);
		}
		else if(act.equals("Logout"))
		{
			
			request.getSession().removeAttribute("session");
			request.getSession().removeAttribute("sess");
				RequestDispatcher rd1=request.getRequestDispatcher("/login.jsp");
				rd1.include(request, response);
			
		}

	}

}
