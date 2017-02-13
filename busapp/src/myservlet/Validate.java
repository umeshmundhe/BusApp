package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Validate() 
    {
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		  UserBean v = new UserBean();
		     String user=request.getParameter("email");
		     String pass=request.getParameter("pass");
		     String valid=v.login(user);
		try
		{	    

		   
	
		   int p=Integer.parseInt(pass);
		   int va=Integer.parseInt(valid);
				if(va==p)
				{
			      out.print("login success");
		         // response.sendRedirect("userLogged.jsp"); //logged-in page      		
				//----------------------------------------'
			      request.getSession().setAttribute("email", pass);            
			       //response.sendRedirect("Home.jsp");
				RequestDispatcher rd=request.getRequestDispatcher("/LoginServlet");
				rd.include(request, response);
				}
			        
		     else {
		    	 out.println("<script type=\"text/javascript\">");
			       out.println("alert('User or password incorrect');");
			       out.println("</script>");
			       response.sendRedirect("login.jsp");   
		     		} 
				}
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}


	}
	

	



