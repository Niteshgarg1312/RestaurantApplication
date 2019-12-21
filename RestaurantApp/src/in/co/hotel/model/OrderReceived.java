package in.co.hotel.model;

public class OrderReceived {
  private int orderid;
  private String emailid;
  private int table;
  private int active;

  public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public int getTable() {
	return table;
}
public void setTable(int table) {
	this.table = table;
}
public int getActive() {
	return active;
}
public void setActive(int active) {
	this.active = active;
}
  
}
