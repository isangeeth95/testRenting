package Vehicle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
 * Servlet implementation class tourVehicles
 */
@WebServlet("/tourVehicles")
public class tourVehicles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public tourVehicles() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		out.print("<title>Tour rent vehicles");
		out.print("</title>");
		if (session.getAttribute("username") == null) {

			RequestDispatcher rd = request.getRequestDispatcher("/header.jsp");
			rd.include(request, response);
		}

		else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/afterLoginHeader.jsp");
			rd.include(request, response);
		}
		out.print("<body>");
		out.print("<div class=\"container\" align='center' style='background-image: linear-gradient(-90deg,Darkblue,aqua)'>");
		out.print("<h1>Display the records of Vehicles for TOURS</h1>");
		out.print("<table border='1'style='color:blue;background-color: powderblue;width:60%;font-size: 30px;'><tr style='color:red;font-size: 30px;'>"
				+ "<th>Vehicle ID</th>"
				+ "<th>Type</th>"
				+ "<th>Cost Per Day</th>"
				+ "<th>Cost Per KM</th>"
				+ "<th>Image Name</th>"
				+ "<th>Rent Category</th>"
				+ "<th>Image</th>" + "</tr>");
		try {
			DBManager db = new DBManager();
			Connection conn = db.getConnection();

			Statement stmt = conn.createStatement();

			String sql = "select * from rentVehicles where rentCategory='tour'";
			ResultSet rs = stmt.executeQuery(sql);

			while (((ResultSet) rs).next()) {
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
				out.print(((ResultSet) rs).getString(7));
				out.print("</td>");
				out.print("<td>");
				out.print("<img src=\"rentVehiclesImages/"
						+ ((ResultSet) rs).getString(5)
						+ "\" width=\"300\" height=\"200\">");
				out.print("</td>");
				out.print("</tr>");
				out.print("<th><button onclick=\"window.location.href='selectVehicle'\">Select Vehicle</button></th>");
			}
		} catch (Exception p) {
			System.out.println(p);
		}
		out.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
