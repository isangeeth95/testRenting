package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginCheck
 */
@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginCheck() {
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

		String uname = request.getParameter("uname").trim();
		String password = request.getParameter("password").trim();
		String dbuname = null,dbpassword=null;

		response.setContentType("text/html");
		PrintWriter write=response.getWriter();
		
		DBManager db = new DBManager();
		Connection conn = db.getConnection();
		
		if (conn == null)
			write.write("Connection Not Established");

		else {
			write.write("Connection Established");

			String message=null;
			String sql = "select uname,password from users where uname='"+uname+"'";
			try {
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				int count = 0;
				while (rs.next()) {
					dbuname=(rs.getString(1));
					dbpassword=(rs.getString(2));
					count += 1;
				}

				if (count == 1 && dbuname.equals(uname) && dbpassword.equals(password)) {
					message="Welcome "+uname;
					request.setAttribute("message", message);
					
					request.getRequestDispatcher("/home.jsp").forward(request,response);
					request.getRequestDispatcher("/header.jsp").forward(request,response);
					
				}

				else if (count == 1 && dbuname.equals(uname) && !dbpassword.equals(password)) {
					message="Incorrect password";
					request.setAttribute("message1", message);
					request.getRequestDispatcher("/login.jsp").forward(request,response);
				}
				
				else if (count > 1) {
					message="Dupplicate user "+uname;
					request.setAttribute("message1", message);
					request.getRequestDispatcher("/login.jsp").forward(request,response);
				}

				else {
					message="Cannot find user "+uname;
					request.setAttribute("message1", message);
					request.getRequestDispatcher("/login.jsp").forward(request,response);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
