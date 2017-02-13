package myservlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final PrintStream PrintStream = null;

	public UserServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		
		int src = Integer.parseInt(request.getParameter("src"));
		int dst = Integer.parseInt(request.getParameter("dst"));
		//System.out.println(" " + src + " " + dst);
		DbManager db = new DbManager();
		
		String stops = db.PassangerStops(src, dst);
		
		int Distance = db.distance(src, dst);
		int ticket=db.ticket(src,dst);
		int time=db.time(src, dst);
		String currrntlocation=db.currentLoc(src,dst);
		//System.out.print("Distance of travle is about:- "+Distance+"km\n" +"Your Bus current loaction is:- "+currrntlocation+" \n ");
		//System.out.print("stops between your journey" + stops+" \n you have to pay"+ " " +ticket+" rupess");
		// String[] parts = result.split("--");
		PrintWriter out = response.getWriter(); 
		out.println("\n \n Distance of travle is about:- "+Distance+"km\n" +"Your Bus current loaction is:- "+currrntlocation+" \n"+"stops between your journey:-" + stops+" \n you have to pay :-"+ " " +ticket+" rupess"+" \n you will reach your destination in just -: "+time+" minute");

		
	
	}

}
