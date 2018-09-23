package addDriver;

public class Driver {
	private String fname; //first name
	private String lname; //last name
	private String email; //email
	private String NIC; //NIC
	private String mobile; //mobile number
	private String uName; //user name
	private String pass; //password
	private String conpass; //confirm password

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public String getConpass() {
		return conpass;
	}

	public void setConpass(String conpass) {
		this.conpass = conpass;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String toString(){
		return "User name = " + uName + "\n" + "First name = " + fname + "\n" + "Last name = " + "\n" + lname+"\n" + "e-mail = " + email +
				"\n" + "NIC = " + NIC + "\n" + "Mobile = " + mobile + "\n" + "Password = " + pass;
	}

}

