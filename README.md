# yamudarawmak databse table queries

create database test1;



create table users(
uid int(11) primary key auto_increment,
fname varchar(50),
lname varchar(50),
email varchar(100),
gender varchar(10),
country varchar(50),
city varchar(50),
telNo varchar(20),
uname varchar(30) unique,
password varchar(30),
imageName varchar(255),
path varchar(255)
);

ALTER TABLE users AUTO_INCREMENT=1;

create table driver(
username varchar(50) primary key,
fname varchar(50) not null,
lname varchar(50),
email varchar(50) not null,
NIC char(10) unique,
mobile int(11),
password varchar(50) not null
);














String sql2= "update users set "
							+ "fname='"+user.getFname()+"',"
								+ "lname='"+user.getLname()+"',"
									+ "email='"+user.getEmail()+"',"
										+ "gender='"+user.getGender()+"',"
											+ "country='"+user.getCountry()+"',"
												+ "city='"+user.getCity()+"',"
													+ "telNo='"+user.getTelNo()+"'"
														+ "uname='"+user.getUname()+"',"
															+ "password='"+user.getPassword()+"',"
																+ "imageName='"+user.getImageName()+"',"
																	+ "path='"+user.getPath()+"'"+" where uid='"+user.getUid()+"'";
					
					
					
					st1.executeUpdate(sql2);
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					HttpSession session = request.getSession();
					
					session.setAttribute("loggedAs", "user");
					session.setAttribute("username", user.getUname());
					session.setAttribute("password", user.getPassword());
					
					if(user.getImageName()!=null)
					session.setAttribute("imageName", user.getImageName());
					
					else{
						String imageName="defaultUser";
						session.setAttribute("imageName", imageName);
					}
					
					String message=(String)session.getAttribute("username");
					request.setAttribute("message", message);
					request.setAttribute("imageName", user.getImageName());
					
					request.getRequestDispatcher("/home.jsp").forward(request,response);
					request.getRequestDispatcher("/afterLoginHeader.jsp").forward(request,response);
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					-----------------------------------------
					
					do post{
					User user = new User();

		user.setUid((String)request.getAttribute("uid"));
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

		PrintWriter out = response.getWriter();

		if (request.getParameter("image") != null) {
			Part part = request.getPart("image");
			user.setImageName(user.extractImageName(part));
			user.setPath("C:\\Users\\sangeeth\\workspaceNew\\yamudarawmak\\WebContent\\usersImages\\"
					+ File.separator + user.getImageName());
			File fileSaveDir = new File(user.getPath());
			part.write(user.getPath() + File.separator);
		}

		else
			user.setImageName("defaultUser.png");
			user.setPath("C:\\Users\\sangeeth\\workspaceNew\\yamudarawmak\\WebContent\\usersImages\\"
				+ File.separator + user.getImageName());

		DBManager db = new DBManager();
		Connection conn = db.getConnection();

		if (conn == null) {
			out.write("Connection Not Established");
		} else {
			try {
				Statement st = conn.createStatement();
				String sql = "select * from users where (uname = '"
						+ user.getUname() + "' or email = '" + user.getEmail()
						+ "') and uid<>'"+user.getUid()+"'";
				ResultSet rs = st.executeQuery(sql);

				if (rs.next()) {
					Object message = "Username or Email exist";
					request.setAttribute("unameExist", message);
					request.getRequestDispatcher("/getUserForUpdate.jsp").forward(
							request, response);
				}

				else if (!user.getPassword().equals(user.getConfPassword())) {
					Object message = "Password not maching";
					request.setAttribute("passwordMatchingErr", message);
					request.getRequestDispatcher("/getUserForUpdate.jsp").forward(
							request, response);
				}

				else if (!user.getEmail().matches(
						"^[A-Z0-9a-z._%+-]+@[A-Z0-9a-z]+\\.[A-Za-z]{2,6}$")) {
					Object message = "Use Standered email";
					request.setAttribute("emailErr", message);
					request.getRequestDispatcher("/getUserForUpdate.jsp").forward(
							request, response);
				}

				else {
					
					out.print("<tr><td>");
					out.println(user.getUid());
					out.print("</td>");
					out.print("<tr><td>");
					out.println(user.getFname());
					out.print("</td>");
					out.print("<tr><td>");
					out.println(user.getLname());
					out.print("</td>");
					out.print("<tr><td>");
					out.println(user.getEmail());
					out.print("</td>");
					out.print("<tr><td>");
					out.println(user.getGender());
					out.print("</td>");

				}
			} catch (Exception e) {
				System.out.println("Got an exception");
				System.out.println(e.getMessage());
			}
					}
