package myservlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserBean 
{

	private static final String Null = null;
	public Connection con = null;
	public Statement stmt = null;
	public ResultSet rst = null;

	public UserBean()
	{

		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/busapp", "root", "umesh");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	public ResultSet ExecuteCmd(String cmd) {
		try {
			stmt = con.createStatement();
			rst = stmt.executeQuery(cmd);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rst;
	}
	public String login(String user)
	{
		String u=null;
		String p="";
		try {
			stmt = con.createStatement();

			String sql = "SELECT password FROM conductor where email='"+ user + "'";// AND password='"+pass+"'";
			rst = stmt.executeQuery(sql);

		while(rst.next())
		{
			//u=rst.getString("email");
			p=rst.getString("password");	
		}
		}
		catch(Exception e)
		{
			 System.out.println(e); 
		}
	//System.out.println(p);
		
		return String.valueOf(p);
	}
	public int adminlogin(int id, int pass) 
	{
	int	u=0;
		int p=0;
		try {
			stmt = con.createStatement();

			String sql = "SELECT * FROM admin where id="+ id +" AND password="+pass+" ";
			rst = stmt.executeQuery(sql);

		while(rst.next())
		{
			u=rst.getInt("id");
			p=rst.getInt("password");	
			
		}
		}
		catch(Exception e)
		{
			 System.out.println(e); 
		}
		if((id==u)&&(p==pass))
		{
		return 1;
		}
		else
		{
			return 0; 
			}
	}
	public void deleteconductor(int cid) 
	{
		try
		{
			stmt=con.createStatement();
			
			int i=stmt.executeUpdate("delete from conductor where cid="+cid+"");
			
		}
catch(Exception e)
		{
			System.out.println(e);
		}

		
	}


}
	


