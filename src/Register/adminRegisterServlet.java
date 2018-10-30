package Register;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import Admin.Admin;
import Login.DBManager;

/**
 * Servlet implementation class adminRegisterServlet
 */
@WebServlet("/adminRegisterServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class adminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminRegisterServlet() {
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
		Admin admin = new Admin();

		admin.setFname(request.getParameter("fname"));

		PrintWriter write = response.getWriter();
		write.write("Connection Not Established " + admin.getFname());
		
		admin.setLname(request.getParameter("lname"));
		admin.setEmail(request.getParameter("email"));
		admin.setGender(request.getParameter("gender"));
		admin.setCountry(request.getParameter("country"));
		admin.setCity(request.getParameter("city"));
		admin.setTelNo(request.getParameter("telNo"));
		admin.setUname(request.getParameter("uname"));
		admin.setPassword(request.getParameter("password"));
		admin.setConfPassword(request.getParameter("confirmPassword"));

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		DBManager db = new DBManager();
		Connection conn = db.getConnection();

		if (conn == null) {
			out.write("Connection Not Established");
		} else {
			try {

				Statement st = conn.createStatement();
				String sql = "select * from users where uname = '"
						+ admin.getUname() + "' or email = '"
						+ admin.getEmail() + "'";
				ResultSet rs = st.executeQuery(sql);

				Statement st2 = conn.createStatement();
				String sql2 = "select * from admins where uname = '"
						+ admin.getUname() + "' or email = '"
						+ admin.getEmail() + "'";
				ResultSet rs2 = st2.executeQuery(sql2);

				if (rs.next()) {
					Object message = "Username or Email exist";
					request.setAttribute("unameExist", message);
					request.getRequestDispatcher("/adminRegisterForm.jsp")
							.forward(request, response);
				}

				else if (rs2.next()) {
					Object message = "Username or Email exist";
					request.setAttribute("unameExist", message);
					request.getRequestDispatcher("/adminRegisterForm.jsp")
							.forward(request, response);
				}

				else if (!admin.getPassword().equals(admin.getConfPassword())) {
					Object message = "Password not matching";
					request.setAttribute("passwordMatchingErr", message);
					request.getRequestDispatcher("/adminRegisterForm.jsp")
							.forward(request, response);
				}

				else if (!admin.getEmail().matches(
						"^[A-Z0-9a-z._%+-]+@[A-Z0-9a-z]+\\.[A-Za-z]{2,6}$")) {
					Object message = "Use Standered email";
					request.setAttribute("emailErr", message);
					request.getRequestDispatcher("/adminRegisterForm.jsp")
							.forward(request, response);
				}

				else {

					String sql3 = "insert into admins (fname,lname,email,gender,country,city,telNo,uname,password,imageName,path)"
							+ "values(?,?,?,?,?,?,?,?,?,?,?)";

					PreparedStatement pre = conn.prepareStatement(sql3);

					pre.setString(1, admin.getFname());
					pre.setString(2, admin.getLname());
					pre.setString(3, admin.getEmail());
					pre.setString(4, admin.getGender());
					pre.setString(5, admin.getCountry());
					pre.setString(6, admin.getCity());
					pre.setString(7, admin.getTelNo());
					pre.setString(8, admin.getUname());
					pre.setString(9, admin.getPassword());

					if (ServletFileUpload.isMultipartContent(request)) {
						Part part = request.getPart("image");
						admin.setImageName(admin.extractImageName(part));
						admin.setPath("C:\\Users\\sangeeth\\workspaceNew\\yamudarawmak\\WebContent\\adminImages\\"
								+ File.separator + admin.getImageName());
						File fileSaveDir = new File(admin.getPath());
						part.write(admin.getPath() + File.separator);

						pre.setString(10, admin.getImageName());
						pre.setString(11, admin.getPath());
					}

					pre.execute();

					request.getRequestDispatcher("/home.jsp").forward(request,
							response);
				}
			} catch (Exception e) {
				System.out.println("Got an exception");
				System.out.println(e.getMessage());
			}
		}
	}

}
