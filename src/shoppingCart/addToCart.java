package shoppingCart;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import Login.DBManager;
import Vehicle.Vehicle;

/**
 * Servlet implementation class addToCart
 */
@WebServlet("/addToCart")
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Order order = new Order();

		HttpSession session = request.getSession();

		order.setUserId((String) session.getAttribute("uid"));
		order.setVehicleId(request.getParameter("vehicleIdForCart"));
		double d=Double.parseDouble(request.getParameter("duration"));
		order.setDuration(d);

		PrintWriter out = response.getWriter();

		DBManager db = new DBManager();
		Connection conn = db.getConnection();

		if (conn == null) {
			out.write("Connection Not Established");
		} else {

			try {
				Statement stmt = conn.createStatement();

				String sql = "select rentCategory,costPerDay,imageName from rentVehicles where vehicleId='"
						+ order.getVehicleId() + "'";
				ResultSet rs = stmt.executeQuery(sql);

				while (((ResultSet) rs).next()) {
					order.setRentCategory(rs.getString(1));
					order.setCostPerDay(rs.getDouble(2));
					order.setImageName(rs.getString(3));
				}
				
				
				order.setCost(order.calcTotal(order.getCostPerDay(),order.getDuration()));
				
				
				String sql2 = "insert into shoppingCart (userId,vehicleId,rentCategory,duration,cost)"
						+ "values (?,?,?,?,?)";

				PreparedStatement pre = conn.prepareStatement(sql2);

				pre.setString(1, order.getUserId());
				pre.setString(2, order.getVehicleId());
				pre.setString(3, order.getRentCategory());
				pre.setLong(4, (long) order.getDuration());
				pre.setLong(5, (long) order.getCost());

				pre.execute();

				
			
				request.setAttribute("order", order);
				request.getRequestDispatcher("/shoppingCart.jsp").forward(request,response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
