package in.co.hotel.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.co.hotel.model.Customer;
import in.co.hotel.model.Dish;
import in.co.hotel.model.OrderReceived;
import in.co.hotel.model.SendMail;
import in.co.hotel.model.SessionBean;
import in.co.hotel.model.totalorder;
import in.co.hotel.model.waiter;
import in.co.hotel.service.HomeService;

@Controller
public class HomeController {
	
	@Autowired
	HomeService homeservice;
	//String username=null;
	@RequestMapping(value="/")
	public String home1()
	{
		return "index";
	}
	
	@RequestMapping(value="chooseuser")
	public String chooseuser(HttpServletRequest req)
	{   
		String k=req.getParameter("key");
		req.setAttribute("k", k);
		return "other_login";
	}
	
	@RequestMapping(value="inbox")
	public String other_login(HttpServletRequest req,HttpSession session )
	{   
		String k=req.getParameter("key");
		req.setAttribute("k", k);
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		//this.username=username;
		int b=homeservice.getUserLogin(username,password,k);
		SessionBean sessionbean = new SessionBean();
		  
		if(b==1)
		{   if(k.equals("3"))
			{
			  sessionbean.setRoleId(3);
			  sessionbean.setUserName(username);
			  
			  session.setAttribute("sessionBean", sessionbean);
		      System.out.print("Cook Login");
			return "redirect:getDishCook";
			}
		    else
		    {
		    	if(k.equals("4")){
		    		  sessionbean.setRoleId(4);
					  sessionbean.setUserName(username);
					  
					  session.setAttribute("sessionBean", sessionbean);
				
					     return "redirect:getWaiter";
						    
		    	}
			    	else
			    	{
			    		  sessionbean.setRoleId(5);
						  sessionbean.setUserName(username);
						  
						  session.setAttribute("sessionBean", sessionbean);
					
		    		return "redirect:getReceptionist";
			    	}
		    }
		}
		else
		{   if(b==2)
		{
		      req.setAttribute("msg","invalid username");
		      return "other_login";
		}
		else
		{
			if(b==3)
			{
			      req.setAttribute("msg2","You Are Not Verified yet!!!");
			      return "other_login";
			}
			else
			{
				req.setAttribute("msg1","invalid password");
				return "other_login";
			}
		}
		}
	}
	
	@RequestMapping(value="Admin_inbox")
	public String admin_login(HttpServletRequest req,HttpSession session)
	{   
		String k=req.getParameter("key");
		req.setAttribute("k", k);
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		int b=homeservice.getAdminLogin(username,password,k);
		SessionBean sessionbean = new SessionBean();
		if(b==1)
		{   
			sessionbean.setRoleId(1);
			  sessionbean.setUserName(username);
			  
			  session.setAttribute("sessionBean", sessionbean);
		
		    return "redirect:getDish";
		}
		else
		{   if(b==2)
		{
		      req.setAttribute("msg","invalid username");
		      return "login";
		}
		else
		{
			if(b==3)
			{
			      req.setAttribute("msg2","You Are Not Verified yet!!!");
			      return "login";
			}
			else
			{
				req.setAttribute("msg1","invalid password");
				return "login";
			}

		}
		}
	}
	
	@RequestMapping(value="outofstockDish")
	public String getOutStock(HttpServletRequest req)
	{
		String status=req.getParameter("status");
		String dishid=req.getParameter("dishId");
		homeservice.getStock(status,dishid);
		return "redirect:getDishCook";
	}
	
	@RequestMapping(value="InStockDish")
	public String getInStock(HttpServletRequest req)
	{
		String status=req.getParameter("status");
		String dishid=req.getParameter("dishId");
		homeservice.getStock(status,dishid);
		return "redirect:getDishCook";
	}
	
	@RequestMapping(value="getDishCook")
	public String getDishDetailCook(HttpServletRequest req)
	{   
		String username;
		try
		{
		SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
		 username=sbean.getUserName();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			
			return "index";
		}
        System.out.println("Hello");
		List<Dish> l=homeservice.getAdminDetail();
		req.setAttribute("list", l);
		return "cook";
	}
	
	@RequestMapping(value="getDish")
	public String getDishDetail(HttpServletRequest req)
	{
		String username;
		try
		{
		SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
		 username=sbean.getUserName();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			return "index";
		}

		List<Dish> l=homeservice.getAdminDetail();
		req.setAttribute("list", l);
		return "admin";
	}
	@RequestMapping(value="adminBack")
	public String adminBack(HttpServletRequest req)
	{
		String username;
		try
		{
		SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
		 username=sbean.getUserName();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			return "index";
		}

		return "redirect:getDish";
	}
	
	@RequestMapping(value="addDish")
	public String addDish(HttpServletRequest req)
	{   
		String dname=req.getParameter("dname");
		String dtype=req.getParameter("dtype");
		String fprice=req.getParameter("full_price");
		String hprice=req.getParameter("half_price");
		homeservice.getAddDish(dname,dtype,fprice,hprice);
		
		return "redirect:getDish";
		
	}
	
	@RequestMapping(value="updateDish")
	public String updateDish(HttpServletRequest req)
	{   
		String dname=req.getParameter("dname");
		String dtype=req.getParameter("dtype");
		String fprice=req.getParameter("full_price");
		String hprice=req.getParameter("half_price");
		String dishid=req.getParameter("dishId");
		//System.out.print(dishid);
		homeservice.getUpdateDish(dname,dtype,fprice,hprice,dishid);
		
		return "redirect:getDish";
		
	}
	
	@RequestMapping(value="deleteDish")
	public String deleteDish(HttpServletRequest req)
	{   
		String dishid=req.getParameter("dishId");
		homeservice.getDeleteDish(dishid);
		
		return "redirect:getDish";	
	}


	@RequestMapping(value="login")
	public String loginAdmin(HttpServletRequest req)
	{   
		String k=req.getParameter("key");
		//System.out.print(k);
		req.setAttribute("k", k);
		return "login";
	}
	
	@RequestMapping(value="signup")
	public String signup(HttpServletRequest req)
	{   
		String k=req.getParameter("key");
		req.setAttribute("k", k);
		return "signup";
	}
	
	@RequestMapping(value="customer")
	public String getCustomer(HttpServletRequest req)
	{
		String k=req.getParameter("key");
		req.setAttribute("k", k);
		return "custsignup";
	}
	
	@RequestMapping(value="signOut")
public String signOut(HttpServletRequest req)
	{
		String k=req.getParameter("key");
		req.setAttribute("k", k);
		return "custsignup";
	}
	
	@RequestMapping(value="addToCart")
	public String addToCart(HttpServletRequest req)
	{
		String dishid=req.getParameter("dishId");
		String full_quantity=req.getParameter("full_quantity");
		String half_quantity=req.getParameter("half_quantity");
		String id=req.getParameter("id");
		String emailid=req.getParameter("emailid");
		//System.out.print(id);
        homeservice.addOrder(dishid,full_quantity,half_quantity,id);
        List<Customer> c=homeservice.getCustDetail(emailid);
		req.setAttribute("list1", c.get(0).getName());
		req.setAttribute("list2", c.get(0).getEmailid());
		req.setAttribute("list3", c.get(0).getId());
		req.setAttribute("list4", c.get(0).getTable());
		req.setAttribute("list5", c.get(0).getAvailable());
		
        List<Dish> l=homeservice.getMenuDetail();
		req.setAttribute("list", l);
		return "CustMenu";
		
		
	}
	
	@RequestMapping(value="custregister")
	public String customerRegister(HttpServletRequest req)
	{   
		String k=req.getParameter("key");
		String name=req.getParameter("name");
		String emailid=req.getParameter("emailid");
		String contact=req.getParameter("contact");
		String people=req.getParameter("people");
		String table=req.getParameter("table");
		homeservice.getCustomerDetails(name,k,emailid,contact,people,table);
		List<Customer> c=homeservice.getCustDetail(emailid);
		req.setAttribute("list1", c.get(0).getName());
		req.setAttribute("list2", c.get(0).getEmailid());
		req.setAttribute("list3", c.get(0).getId());
		req.setAttribute("list4", c.get(0).getTable());
		req.setAttribute("list5", c.get(0).getAvailable());
		List<Dish> l=homeservice.getMenuDetail();
		req.setAttribute("list", l);
		return "CustMenu";
	}
	
	@RequestMapping(value="registersuccessfully")
	public String registersuccessfully(HttpServletRequest req)
	{   
		SendMail sm=new SendMail();
		String k=req.getParameter("key");
		String name=req.getParameter("name");
		String username=req.getParameter("username");
		String emailid=req.getParameter("emailid");
		String contact=req.getParameter("contact");
		//System.out.print(contact);
		String age=req.getParameter("age");
		String designation=req.getParameter("designation");
		String password=req.getParameter("password");
		int b=homeservice.getUniqueEmail(emailid,k,username);
		if(b==0)
		{
			homeservice.getUserDetails(name,username,k,emailid,contact,age,designation,password);
			String body="Hello,"+username+".<br>Your eMail was provided for registration on restro and you were successfully registered.<br> To Confirm your eMail Please click to this link:<br><a href=http://localhost:1000/RestaurantApp/idVerify?key="+k+"&email="+emailid+">Verify</a>";      
	        sm.sendMail(body,emailid,"Email Confirmation");
			return "registersuccessfully";
		}
		else
		{   if(b==2)
			{
			req.setAttribute("k",k);
			req.setAttribute("name",name);
			req.setAttribute("username",username);
			req.setAttribute("emailid",emailid);
			req.setAttribute("contact",contact);
			req.setAttribute("age",age);
			req.setAttribute("designation",designation);
			req.setAttribute("msg", "Emailid Already Exist");
			return "signup";
			}
		else
		{
			req.setAttribute("k",k);
			req.setAttribute("name",name);
			req.setAttribute("username",username);
			req.setAttribute("emailid",emailid);
			req.setAttribute("contact",contact);
			req.setAttribute("age",age);
			req.setAttribute("designation",designation);
			req.setAttribute("msg1", "Username Already Exist");
			return "signup";
		}
		}
	}
	@RequestMapping(value="idVerify")
	public String idVerify(HttpServletRequest req)
	{
		String emailid=req.getParameter("email");
		String key=req.getParameter("key");
		System.out.println(emailid);
		System.out.println(key);
		homeservice.getVerify(emailid,key);
		return "Verified";
	}

	@RequestMapping(value="forgetpassword")
	public String forgetpassword(HttpServletRequest req)
	{
		String k=req.getParameter("key");
		req.setAttribute("k", k);
		System.out.print(k);
		return "forgetpassword";
	}
	@RequestMapping(value="submitEmail")
	public String submitEmail(HttpServletRequest req)
	{   Random rand=new Random();
	    SendMail sm=new SendMail();
		String k=req.getParameter("key");
		req.setAttribute("k", k);
		String emailid=req.getParameter("emailid");
		req.setAttribute("emailid",emailid);
		int b=homeservice.getSubmitEmail(emailid,k);
		if(b==1)
		{   int x=10000+rand.nextInt(90000);
		    System.out.print(x);
		    homeservice.setOTP(emailid,k,x);
		    req.setAttribute("otp",x);
	    	String body="The Secret OTP  is"+ " "+x+" "+"for changing password for restaurantApp.Valid for only 10min.Do not share OTP for Security Reason...";
	    	sm.sendMail(body,emailid,"");
	    	return "otp";
		}
		else
		{
			req.setAttribute("msg","invalid Emailid");
			return "forgetpassword";
		}
	}
	@RequestMapping(value="otpVerify")
	public String otpVerify(HttpServletRequest req)
	{   String emailid=req.getParameter("emailid");
		String key=req.getParameter("key");
		String otp=req.getParameter("otp");
		req.setAttribute("k", key);
		req.setAttribute("emailid",emailid);
	    int b=homeservice.getCheckOtp(emailid,key,otp);
	    //System.out.println(b);
	    if(b==1)
	    {
	      return "changePassword";
	    }
	    else
	    	{
	    	req.setAttribute("msg","invalid OTP");
	    	return "otp";
	    	}
	}
	@RequestMapping(value="changePassword")
	public String changePassword(HttpServletRequest req)
	{   SendMail sm=new SendMail();
		String emailid=req.getParameter("emailid");
		String key=req.getParameter("key");
		String password=req.getParameter("password");
		req.setAttribute("k", key);
		req.setAttribute("email",emailid);
		homeservice.getChangePassword(emailid,key,password);
		String body="Your password of RestaurantApp has been changed";
	    sm.sendMail(body, emailid, " ");
		return "passwordSuccessfully";
	}


	@RequestMapping(value="seeCart")
	public String seeCart(HttpServletRequest req)
	{
		String emailid=req.getParameter("emailid");
		String id=req.getParameter("id");
		List<Customer> c=homeservice.getCustDetail(emailid);
		req.setAttribute("list1", c.get(0).getName());
		req.setAttribute("list2", c.get(0).getEmailid());
		req.setAttribute("list3", c.get(0).getId());
		req.setAttribute("list4", c.get(0).getTable());
		req.setAttribute("list5", c.get(0).getAvailable());
		//System.out.print(id);
		List<totalorder> l=homeservice.getOrderDetail(id);
		//System.out.print(l);
		int payment=l.get(l.size()-1).getPayment();
		l.remove(l.size()-1); 
		req.setAttribute("list", l);
		req.setAttribute("payment", payment);
		return "seecart";
	}
	
	@RequestMapping(value="backtomenu")
	public String backToMenu(HttpServletRequest req)
	{
		String emailid=req.getParameter("emailid");
		String id=req.getParameter("id");
		List<Customer> c=homeservice.getCustDetail(emailid);
		req.setAttribute("list1", c.get(0).getName());
		req.setAttribute("list2", c.get(0).getEmailid());
		req.setAttribute("list3", c.get(0).getId());
		req.setAttribute("list4", c.get(0).getTable());
		req.setAttribute("list5", c.get(0).getAvailable());
		List<Dish> l=homeservice.getMenuDetail();
		req.setAttribute("list", l);
        return "CustMenu";
	}
	
	@RequestMapping(value="RemoveFromCart")
	public String removeFromCart(HttpServletRequest req)
	{
		String dishid=req.getParameter("dishId");
		//System.out.print(dishid);
		String id=req.getParameter("id");
		homeservice.removeFromCart(dishid,id);
		String emailid=req.getParameter("emailid");
		
		List<Customer> c=homeservice.getCustDetail(emailid);
		req.setAttribute("list1", c.get(0).getName());
		req.setAttribute("list2", c.get(0).getEmailid());
		req.setAttribute("list3", c.get(0).getId());
		req.setAttribute("list4", c.get(0).getTable());
		req.setAttribute("list5", c.get(0).getAvailable());
        List<totalorder> l=homeservice.getOrderDetail(id);
		
		int payment=l.get(l.size()-1).getPayment();
		l.remove(l.size()-1);
		req.setAttribute("list", l);
		req.setAttribute("payment", payment);
		return "seecart";
        
	}
	
	@RequestMapping(value="confirmOrder")
	public String confirmOrder(HttpServletRequest req)
	{   
		String emailid=req.getParameter("emailid");
		String id=req.getParameter("id");
		String table=req.getParameter("table");
		List<Customer> c=homeservice.getCustDetail(emailid);
		req.setAttribute("list1", c.get(0).getName());
		req.setAttribute("list2", c.get(0).getEmailid());
		req.setAttribute("list3", c.get(0).getId());
		req.setAttribute("list4", c.get(0).getTable());
		req.setAttribute("list5", c.get(0).getAvailable());
		List<totalorder> l=homeservice.getOrderDetail(id);
		
		int payment=l.get(l.size()-1).getPayment();
		l.remove(l.size()-1);
		req.setAttribute("list", l);
		req.setAttribute("payment", payment);
		
		homeservice.orderReceived(emailid,id,table);
		return "confirmorder";
        
	}
	
	@RequestMapping(value="topayBill")
	public String topayBill(HttpServletRequest req)
	{   
		String emailid=req.getParameter("emailid");
		String id=req.getParameter("id");
		List<Customer> c=homeservice.getCustDetail(emailid);
		req.setAttribute("list1", c.get(0).getName());
		req.setAttribute("list2", c.get(0).getEmailid());
		req.setAttribute("list3", c.get(0).getId());
		req.setAttribute("list4", c.get(0).getTable());
		req.setAttribute("list5", c.get(0).getAvailable());
		List<totalorder> l=homeservice.getOrderDetail(id);
		
		int payment=l.get(l.size()-1).getPayment();
		l.remove(l.size()-1);
		req.setAttribute("list", l);
		req.setAttribute("payment", payment);
		homeservice.addPayment(id,payment,emailid);
		return "topaybill";
        
	}
	
	@RequestMapping(value="orderreceived")
	public String OrderReceived(HttpServletRequest request)
	{   
		String username;
		try
		{
		SessionBean sbean=(SessionBean)request.getSession().getAttribute("sessionBean");
		 username=sbean.getUserName();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			return "index";
		}

		List<OrderReceived> l=homeservice.getOrderReceived();
		request.setAttribute("list", l);
		return "orderReceived";
        
	}
	
	@RequestMapping(value="checkOrderDetails")
	public String checkOrderDetails(HttpServletRequest req)
	{   
		String emailid=req.getParameter("emailid");
		String id=req.getParameter("id");
		String table=req.getParameter("table");
		List<Customer> c=homeservice.getCustDetail(emailid);
		req.setAttribute("list1", c.get(0).getName());
		req.setAttribute("list2", c.get(0).getEmailid());
		req.setAttribute("list3", c.get(0).getId());
		req.setAttribute("list4", c.get(0).getTable());
		req.setAttribute("list5", c.get(0).getAvailable());
		List<totalorder> l=homeservice.getOrderDetail(id);
		
		int payment=l.get(l.size()-1).getPayment();
		l.remove(l.size()-1);
		req.setAttribute("list", l);
		req.setAttribute("payment", payment);
		
		return "custorder";
        
	}
	
	@RequestMapping(value="backtoorder")
	public String backToOrder(HttpServletRequest req)
	{   
		String username;
		try
		{
		SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
		 username=sbean.getUserName();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			return "index";
		}
		List<OrderReceived> l=homeservice.getOrderReceived();
		req.setAttribute("list", l);
		return "orderReceived";
                
	}
	
	@RequestMapping(value="backtocookmenu")
	public String backTocookMenu(HttpServletRequest req)
	{   
		String username;
		try
		{
		SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
		 username=sbean.getUserName();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			return "index";
		}
		return "redirect:getDishCook";
                
	}
	
	@RequestMapping(value="orderprepared")
	public String orderPrepared(HttpServletRequest req)
	{   String emailid=req.getParameter("emailid");
	    String id=req.getParameter("id");
	    String table=req.getParameter("table");
	    List<Customer> c=homeservice.getCustDetail(emailid);
	    req.setAttribute("list1", c.get(0).getName());
	   req.setAttribute("list2", c.get(0).getEmailid());
	   req.setAttribute("list3", c.get(0).getId());
	   req.setAttribute("list4", c.get(0).getTable());
	   req.setAttribute("list5", c.get(0).getAvailable());
	
		List<waiter> l=homeservice.getWaiterDetail();
                req.setAttribute("list", l);
                return "selectWaiter";
	}
	
	@RequestMapping(value="assignWaiter")
	public String assignWaiter(HttpServletRequest req)
	{   
		String w_id=req.getParameter("w_id");
		String emailid=req.getParameter("emailid");
	    String id=req.getParameter("id");
	    String table=req.getParameter("table");
	    String key=req.getParameter("key");
	    homeservice.getAssignWaiter(w_id,id,table,emailid);
	    homeservice.getBusyWaiter(w_id,key);
	    List<OrderReceived> l=homeservice.getOrderReceived();
		req.setAttribute("list", l);
		return "orderReceived";
	}
	@RequestMapping(value="goBackWaiter")	
	public String goBackWaiter(HttpServletRequest req)
	{
		String username;
		try
		{
		 SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
		 username=sbean.getUserName();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			return "index";
		}
		
		return "redirect:getWaiter";
	}
	@RequestMapping(value="getWaiter")
	public String getWaiter(HttpServletRequest req)
	{   
	   SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
	   //System.out.println(sbean.getUserName());
	   List<waiter> c=homeservice.getWaiter(sbean.getUserName());
	   //System.out.println(c);
	   req.setAttribute("list1", c.get(0).getW_name());
	   req.setAttribute("list2", c.get(0).getW_emailid());
	   req.setAttribute("list3", c.get(0).getW_id());
	   req.setAttribute("list5", c.get(0).getW_status());
	   req.setAttribute("list6", c.get(0).getW_key());
	
		return "waiterLogin";
	}
	
	@RequestMapping(value="searchOrder")
	public String searchOrder(HttpServletRequest req)
	{   
	
		String w_id=req.getParameter("w_id");
		String w_emailid=req.getParameter("w_emailid");
	    String key=req.getParameter("w_key");
	    String w_name=req.getParameter("w_name");
	       req.setAttribute("w1", w_id);
		   req.setAttribute("w2", w_emailid);
		   req.setAttribute("w3", key);
		   req.setAttribute("w4", w_name);
	    List<OrderReceived> l=homeservice.getWaiterOrder(w_id);
	    req.setAttribute("list",l);
	    if(!l.isEmpty())
	    { 
	    	req.setAttribute("orderid", l.get(0).getOrderid());
	    	return "waiterOrder";
	    }
	    else
	    {
	    	req.setAttribute("orderid", null);
	    	return "noOrder";
	    }
	}
	
	@RequestMapping(value="checkOrderDetails1")
	public String checkOrderDetails1(HttpServletRequest req)
	{  
		String w_id=req.getParameter("w_id");
		String w_emailid=req.getParameter("w_emailid");
	    String key=req.getParameter("w_key");
	    String w_name=req.getParameter("w_name");
	       req.setAttribute("w1", w_id);
		   req.setAttribute("w2", w_emailid);
		   req.setAttribute("w3", key);
		   req.setAttribute("w4", w_name);
		
		String emailid=req.getParameter("emailid");
		String id=req.getParameter("id");
		String table=req.getParameter("table");
		List<Customer> c=homeservice.getCustDetail(emailid);
		req.setAttribute("list1", c.get(0).getName());
		req.setAttribute("list2", c.get(0).getEmailid());
		req.setAttribute("list3", c.get(0).getId());
		req.setAttribute("list4", c.get(0).getTable());
		req.setAttribute("list5", c.get(0).getAvailable());
		List<totalorder> l=homeservice.getOrderDetail(id);
		
		int payment=l.get(l.size()-1).getPayment();
		l.remove(l.size()-1);
		req.setAttribute("list", l);
		req.setAttribute("payment", payment);
		
		return "waiterCustOrder";
        
	}
	
	@RequestMapping(value="backtowaiterorder")
	public String backtowaiterorder(HttpServletRequest req)
	{   
		String w_id=req.getParameter("w_id");
		String w_emailid=req.getParameter("w_emailid");
	    String key=req.getParameter("w_key");
	    String w_name=req.getParameter("w_name");
	       req.setAttribute("w1", w_id);
		   req.setAttribute("w2", w_emailid);
		   req.setAttribute("w3", key);
		   req.setAttribute("w4", w_name);
		  
	    List<OrderReceived> l=homeservice.getWaiterOrder(w_id);
	    req.setAttribute("list",l);
	    if(!l.isEmpty())
	    { 
	    	req.setAttribute("orderid", l.get(0).getOrderid());
	    }
	    else
	    	req.setAttribute("orderid", null);
	    return "waiterOrder";
	}
	
	@RequestMapping(value="submittedOrder")
	public String submittedOrder(HttpServletRequest req)
	{   
		String w_id=req.getParameter("w_id");
		String w_emailid=req.getParameter("w_emailid");
	    String key=req.getParameter("w_key");
	    String w_name=req.getParameter("w_name");
	    String orderid=req.getParameter("orderid");
	       req.setAttribute("list3", w_id);
		   req.setAttribute("list2", w_emailid);
		   req.setAttribute("list6", key);
		   req.setAttribute("list1", w_name);
		homeservice.getFreeWaiter(w_id,key); 
		homeservice.getSubmitOrder(w_id);
		
			return "waiterLogin";
		
        
	}
	
	@RequestMapping(value="getReceptionist")
	public String getReceptionist(HttpServletRequest req)
	{
		String username;
		try
		{
		SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
		 username=sbean.getUserName();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			return "index";
		}
		List<Customer> l=homeservice.getCustBill();
		req.setAttribute("list", l);
		return "receptionistLogin";
	}
	
	@RequestMapping(value="searchBill")
	public String searchBill(HttpServletRequest req)
	{
		String emailid=req.getParameter("emailid");
		String id=req.getParameter("id");
		List<Customer> l=homeservice.getSearchBill(emailid,id);
		req.setAttribute("list", l);
		return "receptionistLogin";
	}
	
	@RequestMapping(value="generatebill")
	public String generateBill(HttpServletRequest req)
	{
		String emailid=req.getParameter("emailid");
		String id=req.getParameter("id");
		List<Customer> c=homeservice.getCustDetail(emailid);
		req.setAttribute("list1", c.get(0).getName());
		req.setAttribute("list2", c.get(0).getEmailid());
		req.setAttribute("list3", c.get(0).getId());
		req.setAttribute("list4", c.get(0).getTable());
		req.setAttribute("list5", c.get(0).getAvailable());
		List<totalorder> l=homeservice.getOrderDetail(id);
		//System.out.println(l);
		int payment=l.get(l.size()-1).getPayment();
		l.remove(l.size()-1);
		req.setAttribute("list", l);
		req.setAttribute("payment", payment);
		return "generatebill";
	}
	
	@RequestMapping(value="paybill")
	public String payBill(HttpServletRequest req)
	{
		
		String emailid=req.getParameter("emailid");
		String id=req.getParameter("id");
		String payment=req.getParameter("payment");
		String method=req.getParameter("paymentMethod");
		List<Customer> c=homeservice.getCustDetail(emailid);
		req.setAttribute("list1", c.get(0).getName());
		req.setAttribute("list2", c.get(0).getEmailid());
		req.setAttribute("list3", c.get(0).getId());
		req.setAttribute("list4", c.get(0).getTable());
		req.setAttribute("list5", c.get(0).getAvailable());
		
		homeservice.completeOrder(id);
		homeservice.getUnavailable(emailid,id,method);
		homeservice.setBilldetail(id,method,payment);
		List<totalorder> l=homeservice.getAdminBill(emailid,id);
		l.remove(l.size()-1);
		req.setAttribute("list", l);
		req.setAttribute("payment", payment);
		return "print";
	}
	
	@RequestMapping(value="printbill")
	public String printBill(HttpServletRequest req)
	{
		return "redirect:getReceptionist";
	}
	
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logoutit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException{
		session.removeAttribute("sessionBean");
		request.getSession().invalidate();
		return "index";
		
	}
	@RequestMapping(value="adminBillDetail")
	public String adminBillDetail(HttpServletRequest req)
	{   
		String username;
	try
	{
	SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
	 username=sbean.getUserName();
	
	if(username==null)
	{
		return "index";
	}
	}catch(Exception e){
		return "index";
	}
		List<Customer> l=homeservice.getAdminBillDetail();
		req.setAttribute("list", l);
		return "adminBillDetail";
	}
	@RequestMapping(value="adminSearchBill")
	public String adminSearchBill(HttpServletRequest req)
	{
		 String username;
			try
			{
			SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
			 username=sbean.getUserName();
			
			if(username==null)
			{
				return "index";
			}
			}catch(Exception e){
				return "index";
			}
		String emailid=req.getParameter("emailid");
		String id=req.getParameter("id");
		List<Customer> l=homeservice.getAdminSearchBill(emailid,id);
		req.setAttribute("list", l);
		return "adminBillDetail";
	}
	@RequestMapping(value="adminBill")
	public String adminBill(HttpServletRequest req)
	{
		 String username;
			try
			{
			SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
			 username=sbean.getUserName();
			
			if(username==null)
			{
				return "index";
			}
			}catch(Exception e){
				return "index";
			}
		String emailid=req.getParameter("emailid");
		String id=req.getParameter("id");
		List<totalorder> l=homeservice.getAdminBill(emailid,id);
		int payment=l.get(l.size()-1).getPayment();
		l.remove(l.size()-1);
		req.setAttribute("list", l);
		req.setAttribute("payment", payment);
		return "orderDetail";
	}
	

}
