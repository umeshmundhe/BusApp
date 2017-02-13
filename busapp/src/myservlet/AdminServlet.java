package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("admin_id"));
		int pass=Integer.parseInt(request.getParameter("admin_pass"));
		UserBean flag= new UserBean();
		int valid=flag.adminlogin(id, pass);
		System.out.print(valid);
		if(valid==1)
		{
			RequestDispatcher rd=request.getRequestDispatcher("/Register.jsp");
			rd.include(request, response);
		}
		else
		{
			out.println("<html><body></body><head>");
			out.println("<script type=\"text/javascript\">");
		       out.println("alert('User or password incorrect');");
		       out.println("</script>");
		       out.print("</head></html>");
		       response.sendRedirect("admin.jsp"); 
			/*out.println("<html><head></head><body><script>alert(check login details);</script></body></html>");
			RequestDispatcher rd1=request.getRequestDispatcher("/admin.jsp");
			rd1.include(request,response);*/
		}
	}

}
