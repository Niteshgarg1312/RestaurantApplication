package in.co.hotel.model;

public class totalorder {
	private int dishId;
	private String dname;
	private String dtype;
	private String full_price;
	private String half_price;
	private int full_quantity;
	private int half_quantity;
	private int totalPrice;
	private int payment;
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	public String getFull_price() {
		return full_price;
	}
	public void setFull_price(String full_price) {
		this.full_price = full_price;
	}
	public String getHalf_price() {
		return half_price;
	}
	public void setHalf_price(String half_price) {
		this.half_price = half_price;
	}
	public int getFull_quantity() {
		return full_quantity;
	}
	public void setFull_quantity(int full_quantity) {
		this.full_quantity = full_quantity;
	}
	public int getHalf_quantity() {
		return half_quantity;
	}
	public void setHalf_quantity(int half_quantity) {
		this.half_quantity = half_quantity;
	}
}
