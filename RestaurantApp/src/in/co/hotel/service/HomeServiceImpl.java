package in.co.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.hotel.dao.HomeDao;
import in.co.hotel.model.Customer;
import in.co.hotel.model.Dish;
import in.co.hotel.model.OrderReceived;
import in.co.hotel.model.totalorder;
import in.co.hotel.model.waiter;

@Service
public class HomeServiceImpl implements HomeService {
  
	@Autowired
	HomeDao homedao;

	@Override
	public void getUserDetails(String name, String username, String k, String emailid, String contact, String age,
			String designation, String password) {
		homedao.getUserDetails(name,username,k,emailid,contact,age,designation,password);
		
	}

	@Override
	public int getUserLogin(String username, String password, String k) {
		int b=homedao.getUserLogin(username,password,k);
		return b;
	}

	@Override
	public int getAdminLogin(String username, String password, String k) {
		int b=homedao.getAdminLogin(username,password,k);
		return b;
		
	}

	@Override
	public void getAddDish(String dname, String dtype, String fprice, String hprice) {
		homedao.getAddDish(dname,dtype,fprice,hprice);
		
	}

	@Override
	public List<Dish> getAdminDetail() {
		List<Dish> l=homedao.getAdminDetail();
		return l;
	}

	@Override
	public void getUpdateDish(String dname, String dtype, String fprice, String hprice, String dishid) {
		homedao.getUpdateDish(dname,dtype,fprice,hprice,dishid);
		
	}

	@Override
	public void getDeleteDish(String dishid) {
		homedao.getDeleteDish(dishid);
		
	}

	@Override
	public void getStock(String status, String dishid) {
		homedao.getStock(status,dishid);
		
	}

	@Override
	public void getCustomerDetails(String name, String k, String emailid, String contact, String people,String table) {
       homedao.getCustomerDetails(name,k,emailid,contact,people,table);		
	}

	@Override
	public List<Customer> getCustDetail(String emailid) {
		  List<Customer> c=homedao.getCustDetail(emailid);
		return c;
	}

	@Override
	public void addOrder(String dishid, String full_quantity, String half_quantity, String id) {
		homedao.addOrder(dishid,full_quantity,half_quantity,id);
		
	}

	@Override
	public List<Dish> getMenuDetail() {
		List<Dish> l=homedao.getMenuDetail();
		return l;
	}

	@Override
	public List<totalorder> getOrderDetail(String id) {
		List<totalorder> l=homedao.getOrderDetail(id);
		return l;
	}

	@Override
	public void removeFromCart(String dishid,String id) {
		homedao.removeFromCart(dishid,id);
		
	}

	@Override
	public void orderReceived(String emailid, String id, String table) {
        homedao.orderReceived(emailid,id,table);		
	}

	@Override
	public List<OrderReceived>  getOrderReceived() {
		List<OrderReceived> l=homedao.getOrderReceived();
		return l;
	}

	@Override
	public List<waiter> getWaiterDetail() {
		
		return homedao.getWaiterDetail();
	}

	@Override
	public void getAssignWaiter(String w_id, String id, String table, String emailid) {
		homedao.getAssignWaiter(w_id,id,table,emailid);
		
	}

	@Override
	public void getBusyWaiter(String w_id, String key) {
		homedao.getBusyWaiter(w_id,key);
		
	}

	@Override
	public List<waiter> getWaiter(String username) {
		return homedao.getWaiter(username);
		
	}

	@Override
	public List<OrderReceived> getWaiterOrder(String w_id) {
		return homedao.getWaiterOrder(w_id);
		
	}

	@Override
	public void getFreeWaiter(String w_id, String key) {
		homedao.getFreeWaiter(w_id,key);
		
	}

	@Override
	public void getSubmitOrder(String w_id) {
       homedao.getSubmitOrder(w_id);		
	}

	@Override
	public void completeOrder(String id) {
		homedao.completeOrder(id);
		
	}

	@Override
	public void addPayment(String id, int payment, String emailid) {
		homedao.addPayment(id,payment,emailid);
		
	}

	@Override
	public List<Customer> getCustBill() {
		return homedao.getCustBill();
	}

	@Override
	public List<Customer> getSearchBill(String emailid, String id) {
	
		return homedao.getSearchBill(emailid,id);
	}

	@Override
	public void getUnavailable(String emailid, String id, String paymentMethod) {
		homedao.getUnavailable(emailid,id,paymentMethod);
		
	}

	@Override
	public void setBilldetail(String id, String method, String payment) {
		homedao.setBillDetail(id,method,payment);
		
	}

	@Override
	public int getUniqueEmail(String emailid,String k,String username) {
		
		return homedao.getUniqueEmail(emailid,k,username);
	}

	@Override
	public List<Customer> getAdminBillDetail() {
		return homedao.getAdminBillDetail();
	}

	@Override
	public List<Customer> getAdminSearchBill(String emailid, String id) {
		
		return homedao.getAdminSearchBill(emailid,id);
	}

	@Override
	public List<totalorder> getAdminBill(String emailid, String id) {
		
		return homedao.getAdminBill(emailid,id);
	}

	@Override
	public int getSubmitEmail(String emailid,String k) {
		
		return homedao.getSubmitEmail(emailid,k);
	}

	@Override
	public void setOTP(String emailid, String k, int x) {
		homedao.setOTP(emailid,k,x);
		
	}

	@Override
	public int getCheckOtp(String emailid, String key, String otp) {
		return homedao.getCheckOtp(emailid,key,otp);
	}

	@Override
	public void getChangePassword(String emailid, String key, String password) {
		homedao.getChangePassword(emailid,key,password);
		
	}

	@Override
	public void getVerify(String emailid, String key) {
		homedao.getVerify(emailid,key);
		
	}
	
	
	
	
	

}
