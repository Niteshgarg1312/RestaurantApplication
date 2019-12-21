package in.co.hotel.model;

public class Dish {
	private String dname;
	private String dtype;
	private String full_price;
	private String half_price;
	private int dishId;
	private String status;

	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	

}
