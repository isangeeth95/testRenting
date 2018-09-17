package Register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Login.DBManager;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public register() {
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
		// TODO Auto-generated method stub

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String telNo = request.getParameter("telNo");
		String uname = request.getParameter("uname");

		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		String message1 = null;
		String message2 = null;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		DBManager db = new DBManager();
		Connection conn = db.getConnection();

		if (conn == null) {
			out.write("Connection Not Established");
		}

		else {
			out.write("Connection Established");

			String sql1 = "select uname from users where uname='" + uname + "'";
			Statement st = null;
			try {
				st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql1);

				int count = 0;
				while (rs.next()) {
					count++;
				}

				if (count > 0) {
					message1 = uname + " is already exist";
					request.setAttribute("unameExist", message1);
					request.getRequestDispatcher("/register.jsp").forward(
							request, response);
				}

				if (password != null && confirmPassword != null) {

					if (!password.equals(confirmPassword)) {
						message2 = "*Passwords do not matching ";
					}
					request.setAttribute("passwordMatchingErr", message2);
					request.getRequestDispatcher("/register.jsp").forward(
							request, response);

				}

				// Insert user registration details to the users table
				String sql2 = "insert into users values( default,'" + fname
						+ "','" + lname + "','" + email + "','" + gender
						+ "','" + country + "','" + city + "','" + telNo
						+ "','" + uname + "','" + password + "')";

				st = conn.createStatement();
				int i = st.executeUpdate(sql2);				

				if (i==1) {
					out.println("User inserted successfully");
					String message3 = uname + " registerd successfully";

					request.setAttribute("registered", message3);
					request.getRequestDispatcher("/member.jsp").forward(
							request, response);
					request.getRequestDispatcher("/header.jsp").forward(
							request, response);
				}

				else {
					out.write("User insert unsuccessful");
					String message4 = uname + " registerd unsuccessful. Retry";

					request.setAttribute("insertUnsuccess", message4);
					request.getRequestDispatcher("/register.jsp").forward(
							request, response);

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
