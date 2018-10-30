package Vehicle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import addDriver.Driver;
import Vehicle.Vehicle;
import Login.DBManager;

/**
 * Servlet implementation class updateVehicle
 */
@WebServlet("/updateVehicle")
public class updateVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Vehicle vehicle1 = new Vehicle();
		
		RequestDispatcher rd = request.getRequestDispatcher("/afterLoginHeader.jsp");
		rd.include(request, response);
		
		String vehicle = request.getParameter("vehicle"); 
		String type = request.getParameter("type"); 
		String model = request.getParameter("model");
		//String vIamge  = request.getParameter("vImage"); 
		//String path= request.getParameter("path");
		String hire = request.getParameter("hire"); 
		String AC = request.getParameter("ac"); 
		String bar = request.getParameter("bar");
		String reason  = request.getParameter("reason"); 
		String place= request.getParameter("place");
		
		
		response.setContentType("text/html");
		
		PrintWriter write =response.getWriter();
		
			DBManager db=new DBManager();
			Connection conn = db.getConnection();
			
			if(conn==null){
				write.write("Connection Not Established");
			}
			else{
				HttpSession session = request.getSession();
				if(session != null){
					if(session.getAttribute("username")!= null){
						String sname = (String) session.getAttribute("username");
						String spassword = (String)session.getAttribute("password");
					
					}
					else{
						response.sendRedirect("login.jsp");
					}
				}
				
				try{
					vehicle1.setVehicle((String) session.getAttribute("vehicle"));
					vehicle1.setType((String) session.getAttribute("type"));
					vehicle1.setModel((String) session.getAttribute("model"));
					vehicle1.setHire((String) session.getAttribute("hire"));
					vehicle1.setAC((String) session.getAttribute("ac"));
					vehicle1.setBar((String) session.getAttribute("bar"));
					vehicle1.setReason((String) session.getAttribute("reason"));
					vehicle1.setPlace((String) session.getAttribute("place"));
					
					String sql2 = "update driver set vehicle = ? ,type = ? ,model = ? ,hire = ? ,ac = ? ,bar = ? ,reason = ?,place=?"
							+ "where model = '"+vehicle1.getModel()+"'";
					
					
					PreparedStatement pre = conn.prepareStatement(sql2);
					
					pre.setString(1, uName);
					pre.setString(2, fName);
					pre.setString(3, lName);
					pre.setString(4, email);
					pre.setString(5, NIC);
					pre.setString(6, mobile);
					pre.setString(7, pass);
					
					pre.execute();
					
					Object message = "Successfully updated";
					request.setAttribute("message", message);
					request.getRequestDispatcher("/viewDriver.jsp").forward(request, response);
					request.getRequestDispatcher("/header.jsp").forward(request, response);
				
				}
				catch(Exception e){
					System.out.println("Got an exception");
					System.out.println(e.getMessage());
				}
			}
	}

}
