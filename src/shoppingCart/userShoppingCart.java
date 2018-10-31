package shoppingCart;

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
 * Servlet implementation class userShoppingCart
 */
@WebServlet("/userShoppingCart")
public class userShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		out.print("<title>User $ Cart");
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
		out.print("<h1>Display the Shopping cart</h1>");
		out.print("<table border='1'style='color:blue;background-color: powderblue;width:60%;font-size: 30px;'><tr style='color:red;font-size: 30px;'>"
				+ "<th>Order ID</th>"
				+ "<th>Vehicle ID</th>"
				+ "<th>Type</th>"
				+ "<th>Cost Per Day</th>"
				+ "<th>Cost Per KM</th>"
				+ "<th>Rent Category</th>"
				+ "<th>Duration</th>"
				+ "<th>Total Cost</th>"
				+ "<th>Image</th>" + "</tr>");
		
		try {
			DBManager db = new DBManager();
			Connection conn = db.getConnection();

			Statement stmt = conn.createStatement();

			String sql = "select o.orderId,v.vehicleId,v.type,v.costPerDay,v.costPerKM,o.rentCategory,"
					+ "o.duration,o.cost,v.imageName from rentVehicles v, shoppingCart o, users u"
					+ " where v.vehicleId=o.vehicleId and o.userId=u.uid and u.uid='"+session.getAttribute("uid")+"'";
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
				out.print(((ResultSet) rs).getString(6));
				out.print("</td>");
				out.print("<td>");
				out.print(((ResultSet) rs).getString(7));
				out.print("</td>");
				out.print("<td>");
				out.print(((ResultSet) rs).getString(8));
				out.print("</td>");
				out.print("<td>");
				out.print("<img src=\"rentVehiclesImages/"
						+ ((ResultSet) rs).getString(9)
						+ "\" width=\"300\" height=\"200\">");
				out.print("</td>");
				out.print("</tr>");
				out.print("<th><button onclick=\"window.location.href='#'\">Edit Order</button></th>");
			}
		} catch (Exception p) {
			System.out.println(p);
		}
		out.print("</table>");	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
