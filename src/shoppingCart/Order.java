package shoppingCart;

public class Order implements IOrder {
	private String orderId;
	private String userId;
	private String vehicleId;
	private String rentCategory;
	private double duration;
	private double costPerDay;
	private double cost;
	private String imageName;

	public double getCostPerDay() {
		return costPerDay;
	}

	public void setCostPerDay(double costPerDay) {
		this.costPerDay = costPerDay;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getRentCategory() {
		return rentCategory;
	}

	public void setRentCategory(String rentCategory) {
		this.rentCategory = rentCategory;
	}

	public double getDuration() {
		return duration;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setDuration(double d) {
		this.duration = d;
	}

	@Override
	public double calcTotal(double costPerDay, double d) {
		return costPerDay * d;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
