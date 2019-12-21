package in.co.hotel.service;

import java.util.List;

import in.co.hotel.model.Customer;
import in.co.hotel.model.Dish;
import in.co.hotel.model.OrderReceived;
import in.co.hotel.model.totalorder;
import in.co.hotel.model.waiter;

public interface HomeService {


	void getUserDetails(String name, String username, String k, String emailid, String contact, String age,
			String designation, String password);

	int getUserLogin(String username, String password, String k);

	int getAdminLogin(String username, String password, String k);

	void getAddDish(String dname, String dtype, String fprice, String hprice);

	List<Dish> getAdminDetail();

	void getUpdateDish(String dname, String dtype, String fprice, String hprice, String dishid);

	void getDeleteDish(String dishid);

	void getStock(String status, String dishid);

	void getCustomerDetails(String name, String k, String emailid, String contact, String people,String table);

	List<Customer> getCustDetail(String emailid);

	void addOrder(String dishid, String full_quantity, String half_quantity, String id);

	List<Dish> getMenuDetail();

	List<totalorder> getOrderDetail(String id);

	void removeFromCart(String dishid,String id);

	void orderReceived(String emailid, String id, String table);

	List<OrderReceived>  getOrderReceived();

	List<waiter> getWaiterDetail();

	void getAssignWaiter(String w_id, String id, String table,String emailid);

	void getBusyWaiter(String w_id, String key);

	List<waiter> getWaiter(String username);

	List<OrderReceived> getWaiterOrder(String w_id);

	void getFreeWaiter(String w_id, String key);

	void getSubmitOrder(String w_id);

	void completeOrder(String id);

	void addPayment(String id, int payment, String emailid);

	List<Customer> getCustBill();

	List<Customer> getSearchBill(String emailid, String id);

	void getUnavailable(String emailid, String id,String paymentMethod);

	void setBilldetail(String id, String method, String payment);

	int getUniqueEmail(String emailid,String k,String username);

	List<Customer> getAdminBillDetail();

	List<Customer> getAdminSearchBill(String emailid, String id);

	List<totalorder> getAdminBill(String emailid, String id);

	int getSubmitEmail(String emailid,String k);

	void setOTP(String emailid, String k, int x);

	int getCheckOtp(String emailid, String key, String otp);

	void getChangePassword(String emailid, String key, String password);

	void getVerify(String emailid, String key);

	

	

}
