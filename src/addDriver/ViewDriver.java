package addDriver;

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

import Login.DBManager;

/**
 * Servlet implementation class ViewDriver
 */
@WebServlet("/ViewDriver")
public class ViewDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDriver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>View driver</title>");
		RequestDispatcher rd = request.getRequestDispatcher("/afterLoginHeader.jsp");
		rd.include(request, response);
		out.print("<head>");
		out.print("<body>");
		out.print("<div class=\"container\">");
		out.print("<h1>Display the records of Drivers</h1>");
		out.print("<table border='1'><tr><th>User Name</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Mobile</th><th>NIC</th></tr>");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test1", "root", "root");
			
			HttpSession session = request.getSession();
			
			if(session != null){
				if(session.getAttribute("username")!= null){
					String name = (String) session.getAttribute("username");
					String password = (String)session.getAttribute("password");
					out.print("Hello " + name + " Welcome ");
				}
				else{
					response.sendRedirect("driverLogin.jsp");
				}
			}
			String username = (String) session.getAttribute("username");
			Statement stmt = con.createStatement();
			String sql = "select username,fname,lname,email,mobile,NIC from driver where username = '"+username+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(((ResultSet) rs).next()){
				  
				out.print("<tr><td>");
				out.println(((ResultSet) rs).getString(1));
				out.print("</td>");
				out.print("<td>");
				out.print(((ResultSet) rs).getString(2));
				out.print("</td>");
				out.print("<td>");
				out.print(((ResultSet) rs).getString(3));
				out.print("</td>");
				out.print("<td>");
				out.print(((ResultSet) rs).getString(4));
				out.print("</td>");
				out.print("<td>");
				out.print(((ResultSet) rs).getString(5));
				out.print("</td>");
				out.print("<td>");
				out.print(((ResultSet) rs).getString(6));
				out.print("</td>");
				out.print("</tr>");
			}
		}
		catch(Exception p){
			System.out.println(p);
		}
		out.print("</table>");
		out.print("<tr><th>");
		out.print("<form action><input type='submit' value='Update profile'></form>");
		out.print("</th></tr>");
		out.print("</div>");
		out.print("</body>");
		RequestDispatcher rd1 = request.getRequestDispatcher("/footer.jsp");
		rd1.include(request, response);
		out.print("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
