package Vehicle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import addDriver.Driver;

/**
 * Servlet implementation class viewVehicle
 */
@WebServlet("/viewVehicle")
public class viewVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Vehicle vehicle = new Vehicle();
		
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("/afterLoginHeader.jsp");
		rd.include(request, response);
		out.print("<body>");
		out.print("<div class=\"container\" align='center' style='background-image: linear-gradient(to top, #d5dee7 0%, #ffafbd 0%, #c9ffbf 100%);margin-bottom: -200px;'>");
		out.print("<h1>Display the records of Drivers</h1>");
		out.print("<table border='1' style='color:blue;background-color: powderblue;width:60%;'><tr style='color:red;font-size: 30px;'><th style='padding:15px;'>User Name</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Mobile</th><th>NIC</th></tr>");
		try{
			Class.forName("com.mysql.jdbc.vehicle");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test1", "root", "root");
			
			HttpSession session = request.getSession();
			
			if(session != null){
				if(session.getAttribute("username")!= null){
					String name = (String) session.getAttribute("username");
					String password = (String)session.getAttribute("password");
					out.print("Hello " + name + " Welcome <br><br>");
				}
				else{
					response.sendRedirect("driverLogin.jsp");
				}
			}
			String model = (String) session.getAttribute("model");
			Statement stmt = con.createStatement();
			String sql = "select vehicle,type,model,vIamge,path,hire,AC,bar,reason,place from vehicle where model = '"+model+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){

				vehicle.setVehicle(rs.getString(1));

				vehicle.setType(rs.getString(2));

				vehicle.setModel(rs.getString(3));

				vehicle.setVImage(rs.getString(4));
				
				vehicle.setPath(rs.getString(5));

				vehicle.setHire(rs.getString(6));

				vehicle.setAC(rs.getString(7));
			
				vehicle.setBar(rs.getString(8));

				vehicle.setReason(rs.getString(9));

				vehicle.setPlace(rs.getString(10));

			}
				out.print("<tr style='font-size: 30px;text-align: center;'><td style=' padding:7px;'>");
				out.print(vehicle.getVehicle());
				out.print("</td>");
				out.print("<td>");
				out.print(vehicle.getType());
				out.print("</td>");
				out.print("<td>");
				out.print(vehicle.getModel());
				out.print("</td>");
				out.print("<td>");
				out.print(vehicle.getVImage());
				out.print("</td>");
				out.print("<td>");
				out.print(vehicle.getPath());
				out.print("</td>");
				out.print("<td>");
				out.print(vehicle.getHire());
				out.print("</td>");
				out.print("<td>");
				out.print(vehicle.getAC());
				out.print("</td>");
				out.print("<td>");
				out.print(vehicle.getBar());
				out.print("</td>");
				out.print("<td>");
				out.print("<td>");
				out.print(vehicle.getReason());
				out.print("</td>");
				out.print("<td>");
				out.print("<td>");
				out.print(vehicle.getPlace());
				out.print("</td>");
				out.print("</tr>");
				
			
		}
		catch(Exception p){
			System.out.println(p);
		}
		out.print("</table>");
		out.print("<tr><th>");
		out.print("<form action='updateVehicle.jsp' method='POST' style='margin-top:40px;'><input type='submit' value='Update profile' style='padding:10px;background:#4CAF50;"
				+ "transition-duration: 0.4s;display: inline-block;cursor: pointer;-webkit-transition-duration: 0.4s;color:white;font-size:20px;font-weight:bold;border: none;'></form>");
		out.print("</th></tr>");
		out.print("</div>");
		out.print("</body>");
		RequestDispatcher rd2 = request.getRequestDispatcher("/footer.jsp");
		rd2.include(request, response);
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
