package Vehicle;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import Login.DBManager;

/**
 * Servlet implementation class addVehicle
 */
@WebServlet("/addVehicle")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class addVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addVehicle() {
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

		Vehicle vehicle = new Vehicle();

		HttpSession session = request.getSession();

		PrintWriter out = response.getWriter();
		
		vehicle.setType(request.getParameter("type"));
		vehicle.setCostPerDay(request.getParameter("costPerDay"));
		vehicle.setCostPerKM(request.getParameter("costPerKM"));
		vehicle.setRentCategory(request.getParameter("rentCategory"));

		response.setContentType("text/html");

		PrintWriter write = response.getWriter();

		DBManager db = new DBManager();
		Connection conn = db.getConnection();

		if (conn == null) {
			write.write("Connection Not Established");
		} else {

			try {
				String sql2 = "insert into rentVehicles (type,costPerDay,costPerKM,imageName,path,rentCategory)"
						+ "values (?,?,?,?,?,?)";

				PreparedStatement pre = conn.prepareStatement(sql2);

				pre.setString(1, vehicle.getType());
				pre.setString(2, vehicle.getCostPerDay());
				pre.setString(3, vehicle.getCostPerKM());

				if (ServletFileUpload.isMultipartContent(request)) {
					Part part = request.getPart("imageName");
					vehicle.setImageName(vehicle.extractImageName(part));
					vehicle.setPath("C:\\Users\\sangeeth\\workspaceNew\\yamudarawmak\\WebContent\\rentVehiclesImages"
							+ File.separator + vehicle.getImageName());
					File fileSaveDir = new File(vehicle.getPath());
					part.write(vehicle.getPath() + File.separator);
				}
				pre.setString(4, vehicle.getImageName());
				pre.setString(5, vehicle.getPath());
				pre.setString(6, vehicle.getRentCategory());

				pre.execute();

				request.getRequestDispatcher("/home.jsp").forward(request,
						response);
			}

			catch (Exception e) {
				System.out.println("Got an exception");
				System.out.println(e.getMessage());
			}
		}
	}

}
