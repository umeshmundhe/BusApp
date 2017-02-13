package myservlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {

	
	public Connection con = null;
	public Statement stmt = null;
	public ResultSet rst = null;

		public DbManager() 					// constructor having connection code
		{
			try
				{
					Class.forName("com.mysql.jdbc.Driver");
					this.con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/busapp", "root", "umesh");
				} 
			catch (Exception e)
				{
					System.out.println(e);
				}

		}

		public static void main(String[] args) 
		{
				// Main Method
		}

		public ResultSet ExecuteCmd(String cmd)	// create resultSet
		{
			try
			 {
				stmt = con.createStatement();
				rst = stmt.executeQuery(cmd);
			 }
			catch (SQLException e) 
			{
				e.printStackTrace();
			}

			return rst;
		}
		/*************Start getConductor Method Which return conductor information required for journey **********/
		public String getConductorInfo(String email) 
		{
			int cid = 0;
			String cname = null;
			try 
			 {
					stmt = con.createStatement();

					String sql = "SELECT cid,cname FROM conductor where email='"+ email + "'";
					rst = stmt.executeQuery(sql);

					while (rst.next())
					 {
						cid = rst.getInt("cid");
						cname = rst.getString("cname");
					 }
						rst.close();
			 }
			catch (Exception e)
				{
					System.out.println(e);
				}

			return String.valueOf(cid + "--" + cname);
		}
		
		/*************Start assignBus Method Which return current location required for journey **********/
		
		public void assingBus(int busNo, String trip, int cid) 
		{
		System.out.println("" + busNo + " " + trip + " " + cid);
			try
			{
			stmt = con.createStatement();
			int rs = stmt.executeUpdate("insert into trace(busNo,cid,trip,curStop) values("
							+ busNo + "," + cid + ",'" + trip + "'," + 13 + ")");
			con.close();
			System.out.print(rs);
			}
			catch (Exception e) 
			{
			System.out.println(e);
			}

		}
		
		/*************Start update Location  Method Which update current location**********/
	
		public void updateCurrentLocation(String loc, int bno) 
		{
			try 
			 {
			stmt = con.createStatement();
			int rs = stmt.executeUpdate("UPDATE trace SET curStop='" + loc
					+ "'Where busNo=" + bno);

				System.out.print(rs);
				con.close();

			 } 
			catch (Exception e) 
			{
			System.out.println(e);
			}

		}
		
		/*************Start Delete Method Which delete data from database after laststop **********/
	public void deleteTrace(int bus_no) 
		{
			try 
			 {
			stmt = con.createStatement();
			int rs = stmt.executeUpdate("delete from trace where busNo="
					+ bus_no);
			con.close();
			System.out.print(rs);
			 } 
			catch (Exception e)
			 {
			System.out.println(e);
			 }
		}
	
	public void display(String bus_no, String trips, String curloc)

		{

		System.out.println("" + bus_no + " " + trips + "**" + curloc);
		// System.out.println( ""+curloc);
		}
	/*************Start Register Method Which add new conductor information **********/
	public void Register(int id, String name, String mail, String pass) 
		{
			try 
			 {
				stmt = con.createStatement();
				int rs = stmt.executeUpdate("Insert into conductor values(" + id+ ",'" + name + "','" + mail + "','" + pass + "')");
				con.close();
			    System.out.print(rs);
			 }
			catch (Exception e) 
			 {
			  System.out.println(e);
		     }
		}

	/*************Start current PassangerStops Method Which return stops in between your journey  **********/
	public String PassangerStops(int src, int dst) 
		{

			String stops = " ";
			
			if(src < dst)
			 {
				try 	
					{
						stmt = con.createStatement();
						String rs = "SELECT stopName FROM route WHERE stopNo BETWEEN "
									+ src + " AND " + dst + "";
						rst = stmt.executeQuery(rs);

					while (rst.next()) 
					 {

						stops += "  " + rst.getString("stopName");

					 }

		
					}
				catch (Exception e) 
				{
					System.out.println(e);
				}
					return stops;
			 }// end of IF
				else
					{
						try
							{
							 stmt = con.createStatement();
							 String rs = "SELECT stopName FROM route WHERE stopNo BETWEEN "
									 + dst + " AND " + src + " ORDER BY stopNo DESC";
							 rst = stmt.executeQuery(rs);

							 while (rst.next()) 
							 	{

								stops += "  " + rst.getString("stopName");

							 	}
							}
						catch (Exception e) 
						{
							System.out.println(e);
						}
							return stops;
					}// End of else
		
			}
	/*************Start Distance Method Which return Distance required for journey **********/
	
			public int distance(int src, int dst)
				{

					int src1 = 0, dst1 = 0;
						try
							{
								ResultSet rst1 = ExecuteCmd("select distance from route where stopNo="
												+ src);
								ResultSet rst2 = ExecuteCmd("select distance from route where stopNo="
												+ dst);
								while (rst1.next() && rst2.next()) 
								{
									src1 = rst1.getInt("distance");
									dst1 = rst2.getInt("distance");
								}// End of try
			// System.out.println(+src1 + "---" + dst1);
			
							}// End of try
						catch (Exception e) 
						{
							System.out.println(e);
						}
						if (src < dst)
							return dst1 - src1;
						else
							return src1 - dst1;
				}// End of Distance Method

			/*************Start current Loc Method Which return current location required for journey **********/
			public String currentLoc(int src, int dst) 
				{
					String abc =" ";
						if(src<dst)
						{
							try
							   {
								ResultSet rst1 = ExecuteCmd("select StopName from route,trace where route.stopNo = trace.curStop AND trace.trip='A-C'");
			
								while(rst1.next())
									{
									abc += rst1.getString("stopName")+",";
									}
								return String.valueOf(abc);
							    }// ENd of try
							catch (Exception e)
								{
								System.out.print(e);
								}
						}//end of IF 
						else
						{
							try
							 {
								ResultSet rst1 = ExecuteCmd("select stopName from route,trace where route.stopNo = trace.curStop AND trace.trip='C-A'");
								while(rst1.next())
								{
									abc += rst1.getString("stopName")+",";
								}
				
								return String.valueOf(abc);
							 }// End of try
							catch (Exception e)
							{
								System.out.print(e);
							}
			
						}// End if else
						return null;
				}           //End of CurrentLoc Method

	
			/*************Start Ticket Method Which return ticket required for journey **********/
	
			public int ticket(int src, int dst) {

				int src1 = 0, dst1 = 0; //count = 0;
				try 
				{

					ResultSet rst1 = ExecuteCmd("select ticket from route where stopNo="
					+ src);
					ResultSet rst2 = ExecuteCmd("select ticket from route where stopNo="
					+ dst);
					while (rst1.next() && rst2.next()) 
						{
						src1 = rst1.getInt("ticket");
						dst1 = rst2.getInt("ticket");
						}
		
				}// ENd of try 
				catch (Exception e)
				{
					System.out.println(e);
				}
					if (src < dst)
						return dst1 - src1;
					else
						return src1 - dst1;
			
			}// End of ticket Method
			
			
	/*************Start Time Method Which return time required for journey **********/
			public int time(int src, int dst) 
			{

				int src1 = 0, dst1 = 0;//count = 0;
				try
				{

					ResultSet rst1 = ExecuteCmd("select time from route where stopNo="
					+ src);
					ResultSet rst2 = ExecuteCmd("select time from route where stopNo="
					+ dst);
					while (rst1.next() && rst2.next()) 
					{
						src1 = rst1.getInt("time");
						dst1 = rst2.getInt("time");
					}
			
				} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
				if (src < dst)
					return dst1 - src1;
				else										// Return the time req
					return src1 - dst1;
				}
	
			}// End of time Method
