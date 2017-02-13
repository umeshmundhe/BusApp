package myservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DbManager reg=new DbManager();
		
		int id=Integer.parseInt(request.getParameter("RegId"));
		String name=String.valueOf(request.getParameter("RegName"));
		String mail=String.valueOf(request.getParameter("RegMail"));
		String pass=String.valueOf(request.getParameter("RegPass"));
		
		
			reg.Register( id,name, mail,pass);
			 response.sendRedirect("login.jsp"); 
		
				
		
	}

}
