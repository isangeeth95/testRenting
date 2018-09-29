package register;

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

		User user = new User();

		user.setFname(request.getParameter("fname"));
		user.setLname(request.getParameter("lname"));
		user.setEmail(request.getParameter("email"));
		user.setGender(request.getParameter("gender"));
		user.setCountry(request.getParameter("country"));
		user.setCity(request.getParameter("city"));
		user.setTelNo(request.getParameter("telNo"));
		user.setUname(request.getParameter("uname"));
		user.setPassword(request.getParameter("password"));
		user.setConfPassword(request.getParameter("confirmPassword"));

		response.setContentType("text/html");

		PrintWriter write = response.getWriter();

		DBManager db = new DBManager();
		Connection conn = db.getConnection();

		if (conn == null) {
			write.write("Connection Not Established");
		} else {
			try {
				Statement st = conn.createStatement();
				String sql = "select * from users where uname = '"
						+ user.getUname() + "' or email = '" + user.getEmail()
						+ "'";
				ResultSet rs = st.executeQuery(sql);

				if (rs.next()) {
					Object message = "Username or Email exist";
					request.setAttribute("unameExist", message);
					request.getRequestDispatcher("/register.jsp").forward(
							request, response);
					request.getRequestDispatcher("/header.jsp").forward(
							request, response);
				}

				else if (!user.getPassword().equals(user.getConfPassword())) {
					Object message = "Password not maching";
					request.setAttribute("passwordMatchingErr", message);
					request.getRequestDispatcher("/register.jsp").forward(
							request, response);
					request.getRequestDispatcher("/header.jsp").forward(
							request, response);
				}

				else if (!user.getEmail().matches(
						"^[A-Z0-9a-z._%+-]+@[A-Z0-9a-z]+\\.[A-Za-z]{2,6}$")) {
					Object message = "Use Standered email";
					request.setAttribute("emailErr", message);
					request.getRequestDispatcher("/register.jsp").forward(
							request, response);
					request.getRequestDispatcher("/header.jsp").forward(
							request, response);
				}

				else {
					String sql2 = "insert into users (fname,lname,email,gender,country,city,telNo,uname,password)"
							+ "values(?,?,?,?,?,?,?,?,?)";

					PreparedStatement pre = conn.prepareStatement(sql2);

					pre.setString(1, user.getFname());
					pre.setString(2, user.getLname());
					pre.setString(3, user.getEmail());
					pre.setString(4, user.getGender());
					pre.setString(5, user.getCountry());
					pre.setString(6, user.getCity());
					pre.setString(7, user.getTelNo());
					pre.setString(8, user.getUname());
					pre.setString(9, user.getPassword());

					pre.execute();

					Object message = user.getUname() + " Registered";
					request.setAttribute("message", message);
					request.getRequestDispatcher("/home.jsp").forward(request,
							response);
					request.getRequestDispatcher("/header.jsp").forward(
							request, response);

				}
			} catch (Exception e) {
				System.out.println("Got an exception");
				System.out.println(e.getMessage());
			}

		}
	}

}
