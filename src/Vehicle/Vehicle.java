package Vehicle;

import javax.servlet.http.Part;

public class Vehicle {		
			private String vehicleId;
			private String type;
			private String costPerDay;
			private String costPerKM;
			private String imageName;
			private String path;
			private String rentCategory;
			



		public String getVehicleId() {
				return vehicleId;
			}




			public void setVehicleId(String vehicleId) {
				this.vehicleId = vehicleId;
			}




			public String getType() {
				return type;
			}




			public void setType(String type) {
				this.type = type;
			}




			public String getCostPerDay() {
				return costPerDay;
			}




			public void setCostPerDay(String string) {
				this.costPerDay = string;
			}




			public String getCostPerKM() {
				return costPerKM;
			}




			public void setCostPerKM(String string) {
				this.costPerKM = string;
			}




			public String getImageName() {
				return imageName;
			}




			public void setImageName(String imageName) {
				this.imageName = imageName;
			}




			public String getPath() {
				return path;
			}




			public void setPath(String path) {
				this.path = path;
			}




			public String getRentCategory() {
				return rentCategory;
			}




			public void setRentCategory(String rentCategory) {
				this.rentCategory = rentCategory;
			}




		public String extractImageName(Part part){
			String contentDisp=part.getHeader("content-disposition");
			String[] items=contentDisp.split(";");
			for(String s:items){
				if(s.trim().startsWith("filename")){
					return s.substring(s.indexOf("=") + 2,s.length() -1);
				}
			}
			return "";
		}


}
