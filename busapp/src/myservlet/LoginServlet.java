package myservlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet()
	{
		super();
		
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html"); // informing the client that which


		DbManager b2 = new DbManager();
		String result = b2.getConductorInfo(String.valueOf(request
				.getParameter("email")));
		

		String[] parts = result.split("--");
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("cid", Integer.parseInt(parts[0]));
		session.setAttribute("cname", String.valueOf(parts[1]));
		
		RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
		rd.include(request, response);
		
	}

}

