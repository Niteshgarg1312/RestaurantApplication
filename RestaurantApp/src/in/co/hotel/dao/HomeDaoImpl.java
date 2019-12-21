package in.co.hotel.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.co.hotel.model.Customer;
import in.co.hotel.model.Dish;
import in.co.hotel.model.OrderReceived;
import in.co.hotel.model.totalorder;
import in.co.hotel.model.waiter;

@Repository
public class HomeDaoImpl implements HomeDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void getUserDetails(String name, String username, String k, String emailid, String contact, String age,
			String designation, String password) {
		final String procedureCall = "{call Proc_Laabh(?,?,?,?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "signup");
		callableSt.setString(2, name);
		callableSt.setString(3, username);
		callableSt.setInt(4,Integer.parseInt(k));
		callableSt.setString(5, emailid);
		callableSt.setString(6, contact);
		callableSt.setInt(7, Integer.parseInt(age));
		callableSt.setString(8, designation);
		callableSt.setString(9, password);
		callableSt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int getUserLogin(String username, String password, String k) {
		final String procedureCall = "{call Proc_Laabh(?,?,?,?)}";
		Connection connection = null;
	    int b=0;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "other_login");
		callableSt.setString(2, null);
		callableSt.setString(3, username);
		callableSt.setInt(4,Integer.parseInt(k));
		ResultSet rs=callableSt.executeQuery();
		if(rs.next())
		{
			if(rs.getString("isVerified").equals("1"))
			{
				if(rs.getString("password").equals(password))
				{   
					b=1;
				}
				else
					b=0;
			}
			else
				b=3;
		}
		else{
			b=2;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return b;
	}

	@Override
	public int getAdminLogin(String username, String password, String k) {
		final String procedureCall = "{call Proc_Laabh(?,?,?,?)}";
		Connection connection = null;
	    int b=0;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "other_login");
		callableSt.setString(2, null);
		callableSt.setString(3, username);
		callableSt.setInt(4, Integer.parseInt(k));
		ResultSet rs=callableSt.executeQuery();
		if(rs.next())
		{
			if(rs.getString("isVerified").equals("1"))
			{
				if(rs.getString("password").equals(password))
				{   
					b=1;
				}
				else
					b=0;
			}
			else
				b=3;
		}
		else{
			b=2;
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return b;
		
	}

	@Override
	public void getAddDish(String dname, String dtype, String fprice, String hprice) {
		
		final String procedureCall = "{call Proc_Laabh1(?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "addDish");
		callableSt.setString(2, dname);
		callableSt.setString(3, dtype);
		callableSt.setString(4, fprice);
		callableSt.setString(5, hprice);
		callableSt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Dish> getAdminDetail() {
		List<Dish> l=new ArrayList();
		final String procedureCall = "{call Proc_Laabh1(?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getDetail");
		ResultSet rs=callableSt.executeQuery();
		while(rs.next())
		{
			Dish d=new Dish();
			d.setDname(rs.getString("Dish_name"));
			d.setDtype(rs.getString("Dish_type"));
			d.setFull_price(rs.getString("Full_Dish_Price"));
			d.setHalf_price(rs.getString("Half_Dish_Price"));
			d.setDishId(Integer.parseInt(rs.getString("id")));
            d.setStatus(rs.getString("Status"));
			l.add(d);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return l;
		
	}

	@Override
	public void getUpdateDish(String dname, String dtype, String fprice, String hprice, String dishid) {
		final String procedureCall = "{call Proc_Laabh1(?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "updateDish");
		callableSt.setString(2, dname);
		callableSt.setString(3, dtype);
		callableSt.setString(4, fprice);
		callableSt.setString(5, hprice);
		callableSt.setString(6, dishid);
		callableSt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

		
	}

	@Override
	public void getDeleteDish(String dishid) {
		final String procedureCall = "{call Proc_Laabh1(?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "deleteDish");
		callableSt.setString(2, null);
		callableSt.setString(3, null);
		callableSt.setString(4, null);
		callableSt.setString(5, null);
		callableSt.setString(6, dishid);
		callableSt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

	
	}

	@Override
	public void getStock(String status, String dishid) {
		final String procedureCall = "{call Proc_Laabh1(?,?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "changestatus");
		callableSt.setString(2, null);
		callableSt.setString(3, null);
		callableSt.setString(4, null);
		callableSt.setString(5, null);
		callableSt.setString(6, dishid);
		callableSt.setString(7, status);
		callableSt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

	
	
		
	}

	@Override
	public void getCustomerDetails(String name, String k, String emailid, String contact, String people,String table) {
		
		final String procedureCall = "{call Proc_Laabh2(?,?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "custdetails");
		callableSt.setString(2, name);
		callableSt.setString(3, emailid);
		callableSt.setString(4, contact);
		callableSt.setString(5, people);
		callableSt.setString(6, k);
		callableSt.setString(7, table);
		callableSt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Customer> getCustDetail(String emailid) {
		
		List<Customer> c=new ArrayList();
		final String procedureCall = "{call Proc_Laabh2(?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getCustDetail");
		callableSt.setString(2, null);
		callableSt.setString(3, emailid);
		ResultSet rs=callableSt.executeQuery();
		while(rs.next())
		{
			Customer d=new Customer();
			d.setName(rs.getString("cust_name"));
			d.setEmailid(rs.getString("cust_emailid"));
			d.setId(Integer.parseInt(rs.getString("id")));
			d.setTable(Integer.parseInt(rs.getString("table_no.")));
			d.setAvailable(Integer.parseInt(rs.getString("available")));
			c.add(d);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return c;
	}

	@Override
	public void addOrder(String dishid, String full_quantity, String half_quantity, String id) {
		int flag=0;
		final String procedureCall = "{call Proc_Laabh3(?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getorderdetails");
		callableSt.setInt(2, Integer.parseInt(id));
		callableSt.setInt(3, Integer.parseInt(dishid));
		ResultSet rs=callableSt.executeQuery();
		if(rs.next())
		{
			flag=1;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(flag==1)
		{
			final String procedureCall1 = "{call Proc_Laabh3(?,?,?,?,?)}";
			Connection connection1 = null;
			try {	
			connection1 = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt1 = connection1.prepareCall(procedureCall1);
			callableSt1.setString(1, "updateorder");
			callableSt1.setInt(2, Integer.parseInt(id));
			callableSt1.setInt(3, Integer.parseInt(dishid));
			callableSt1.setInt(4, Integer.parseInt(full_quantity));
			callableSt1.setInt(5, Integer.parseInt(half_quantity));
			callableSt1.execute();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(connection1 != null)
					try{
						connection1.close();
					}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
			
		}
		else{
			final String procedureCall1 = "{call Proc_Laabh3(?,?,?,?,?)}";
			Connection connection1 = null;
			try {	
			connection1 = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt1 = connection1.prepareCall(procedureCall1);
			callableSt1.setString(1, "orderdetails");
			callableSt1.setInt(2, Integer.parseInt(id));
			callableSt1.setInt(3, Integer.parseInt(dishid));
			callableSt1.setInt(4, Integer.parseInt(full_quantity));
			callableSt1.setInt(5, Integer.parseInt(half_quantity));
			callableSt1.execute();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(connection1 != null)
					try{
						connection1.close();
					}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		
		}

			}

	@Override
	public List<Dish> getMenuDetail() {
		List<Dish> l=new ArrayList();
		final String procedureCall = "{call Proc_Laabh1(?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getCustDetail");
		ResultSet rs=callableSt.executeQuery();
		while(rs.next())
		{
			Dish d=new Dish();
			d.setDname(rs.getString("Dish_name"));
			d.setDtype(rs.getString("Dish_type"));
			d.setFull_price(rs.getString("Full_Dish_Price"));
			d.setHalf_price(rs.getString("Half_Dish_Price"));
			d.setDishId(Integer.parseInt(rs.getString("id")));
            d.setStatus(rs.getString("Status"));
			l.add(d);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return l;
	
		
	}

	@Override
	public List<totalorder> getOrderDetail(String id) {
		int price=0;
		int payment=0;
		List<totalorder> l=new ArrayList();
		final String procedureCall = "{call Proc_Laabh3(?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getCart");
		callableSt.setInt(2, Integer.parseInt(id));
		//System.out.print(Integer.parseInt(id));
		ResultSet rs=callableSt.executeQuery();
		while(rs.next())
		{
			int fp=Integer.parseInt(rs.getString("Full_Dish_Price"));
			int hp=Integer.parseInt(rs.getString("Half_Dish_Price"));
			int fq=Integer.parseInt(rs.getString("full_quantity"));
		    int hq=Integer.parseInt(rs.getString("half_quantity"));
			totalorder d=new totalorder();
			d.setDname(rs.getString("Dish_name"));
			d.setDtype(rs.getString("Dish_type"));
			d.setFull_price(rs.getString("Full_Dish_Price"));
			d.setHalf_price(rs.getString("Half_Dish_Price"));
			d.setFull_quantity(Integer.parseInt(rs.getString("full_quantity")));
			d.setHalf_quantity(Integer.parseInt(rs.getString("half_quantity")));
			d.setDishId(Integer.parseInt(rs.getString("dish_id")));
			price=(fp*fq)+(hp*hq);
			payment=payment+price;
			d.setTotalPrice(price);
			l.add(d);
			
		}
		totalorder d1=new totalorder();
		d1.setPayment(payment);
		l.add(d1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	return l;
	
	}

	@Override
	public void removeFromCart(String dishid,String id) {
		final String procedureCall = "{call Proc_Laabh3(?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "removefromCart");
		callableSt.setInt(2, Integer.parseInt(id));
		callableSt.setInt(3, Integer.parseInt(dishid));
		
		callableSt.execute();
					
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void orderReceived(String emailid, String id, String table) {
		
		final String procedureCall = "{call Proc_Laabh4(?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "insertorder");
		callableSt.setString(2, emailid);
		callableSt.setInt(3, Integer.parseInt(id));
		callableSt.setInt(4, Integer.parseInt(table));
		
		callableSt.execute();
					
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<OrderReceived>  getOrderReceived() {
		List<OrderReceived> l=new ArrayList();
		final String procedureCall = "{call Proc_Laabh4(?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getDetail");
		ResultSet rs=callableSt.executeQuery();
		while(rs.next())
		{
			OrderReceived d=new OrderReceived();
			d.setActive(Integer.parseInt(rs.getString("active")));
			d.setEmailid(rs.getString("emailid"));
			d.setOrderid(Integer.parseInt(rs.getString("orderid")));
			d.setTable(Integer.parseInt(rs.getString("table_no.")));
			l.add(d);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return l;

		
	}

	@Override
	public List<waiter> getWaiterDetail() {
		
		List<waiter> l=new ArrayList();
		final String procedureCall = "{call Proc_Laabh(?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getWaiterDetail");
		ResultSet rs=callableSt.executeQuery();
		while(rs.next())
		{
			waiter d=new waiter();
			d.setW_emailid(rs.getString("emailid"));
			d.setW_name(rs.getString("name"));
			d.setW_status(Integer.parseInt(rs.getString("status")));
			d.setW_id(Integer.parseInt(rs.getString("pk_id")));
			d.setW_key(Integer.parseInt(rs.getString("user_key")));
			l.add(d);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return l;

	}

	@Override
	public void getAssignWaiter(String w_id, String id, String table, String emailid) {
		
		final String procedureCall = "{call Proc_Laabh4(?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getAssignWaiter");
		callableSt.setString(2, emailid);
		callableSt.setInt(3, Integer.parseInt(id));
		callableSt.setInt(4, Integer.parseInt(table));
		callableSt.setString(5, null);
		callableSt.setInt(6, Integer.parseInt(w_id));
		callableSt.execute();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void getBusyWaiter(String w_id, String key) {
		
		final String procedureCall = "{call Proc_Laabh(?,?,?,?,?,?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getBusyWaiter");
		callableSt.setString(2, null);
		callableSt.setString(3, null);
		callableSt.setInt(4, Integer.parseInt(key));
		callableSt.setString(5, null);
		callableSt.setString(6, null);
		callableSt.setString(7, null);
		callableSt.setString(8, null);
		callableSt.setString(9, null);
		callableSt.setString(10, null);
		callableSt.setInt(11, Integer.parseInt(w_id));
		callableSt.execute();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<waiter> getWaiter(String username) {
		List<waiter> l=new ArrayList();
		final String procedureCall = "{call Proc_Laabh(?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getWaiter");
		callableSt.setString(2, null);
		callableSt.setString(3, username);
		ResultSet rs=callableSt.executeQuery();
		System.out.print(username);
		if(rs.next())
		{
			waiter d=new waiter();
			d.setW_emailid(rs.getString("emailid"));
			d.setW_name(rs.getString("name"));
			d.setW_status(Integer.parseInt(rs.getString("status")));
			d.setW_id(Integer.parseInt(rs.getString("pk_id")));
			d.setW_key(Integer.parseInt(rs.getString("user_key")));
			l.add(d);
			
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

		return l;
	}

	@Override
	public List<OrderReceived> getWaiterOrder(String w_id) {
		List<OrderReceived> l=new ArrayList();
		final String procedureCall = "{call Proc_Laabh4(?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getWaiterOrder");
		callableSt.setString(2, null);
		callableSt.setString(3, null);
		callableSt.setString(4, null);
		callableSt.setString(5, null);
		callableSt.setInt(6, Integer.parseInt(w_id));
		ResultSet rs=callableSt.executeQuery();
		if(rs.next())
		{
			OrderReceived d=new OrderReceived();
			d.setActive(Integer.parseInt(rs.getString("active")));
			d.setEmailid(rs.getString("emailid"));
			d.setOrderid(Integer.parseInt(rs.getString("orderid")));
			d.setTable(Integer.parseInt(rs.getString("table_no.")));
			l.add(d);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

		return l;
	}

	@Override
	public void getFreeWaiter(String w_id, String key) {
		
		final String procedureCall = "{call Proc_Laabh(?,?,?,?,?,?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getFreeWaiter");
		callableSt.setString(2, null);
		callableSt.setString(3, null);
		callableSt.setInt(4, Integer.parseInt(key));
		callableSt.setString(5, null);
		callableSt.setString(6, null);
		callableSt.setString(7, null);
		callableSt.setString(8, null);
		callableSt.setString(9, null);
		callableSt.setString(10, null);
		callableSt.setInt(11, Integer.parseInt(w_id));
		callableSt.execute();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

		
	}

	@Override
	public void getSubmitOrder(String w_id) {
		final String procedureCall = "{call Proc_Laabh4(?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getSubmitOrder");
		callableSt.setString(2, null);
		callableSt.setString(3, null);
		callableSt.setString(4, null);
		callableSt.setString(5, null);
		callableSt.setInt(6, Integer.parseInt(w_id));
		callableSt.execute();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}


		
	}

	@Override
	public void completeOrder(String id) {
		final String procedureCall = "{call Proc_Laabh3(?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getCompleteOrder");
		callableSt.setInt(2, Integer.parseInt(id));
		callableSt.execute();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

  		
	}

	@Override
	public void addPayment(String id, int payment, String emailid) {
		final String procedureCall = "{call Proc_Laabh2(?,?,?,?,?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "addpayment");
		callableSt.setString(2, null);
		callableSt.setString(3, emailid);
		callableSt.setString(4, null);
		callableSt.setString(5, null);
		callableSt.setString(6, null);
		callableSt.setString(7, null);
		callableSt.setInt(8, payment);
		callableSt.setString(9, null);
		callableSt.setInt(10, Integer.parseInt(id));

		callableSt.execute();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Customer> getCustBill() {
		
		List<Customer> c=new ArrayList();
		final String procedureCall = "{call Proc_Laabh2(?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getCustBill");
		ResultSet rs=callableSt.executeQuery();
		while(rs.next())
		{
			Customer d=new Customer();
			d.setName(rs.getString("cust_name"));
			d.setEmailid(rs.getString("cust_emailid"));
			d.setId(Integer.parseInt(rs.getString("id")));
			d.setTable(Integer.parseInt(rs.getString("table_no.")));
			d.setAvailable(Integer.parseInt(rs.getString("available")));
			d.setPayment(Integer.parseInt(rs.getString("payment_paid")));
			c.add(d);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return c;

	}

	@Override
	public List<Customer> getSearchBill(String emailid, String id) {
		List<Customer> c=new ArrayList();
		final String procedureCall = "{call Proc_Laabh2(?,?,?,?,?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getSearchBill");
		callableSt.setString(2, null);
		callableSt.setString(3, emailid);
		callableSt.setString(4, null);
		callableSt.setString(5, null);
		callableSt.setString(6, null);
		callableSt.setString(7, null);
		callableSt.setString(8, null);
		callableSt.setString(9, null);
		callableSt.setInt(10, Integer.parseInt(id));
		ResultSet rs=callableSt.executeQuery();
		if(rs.next())
		{
			Customer d=new Customer();
			d.setName(rs.getString("cust_name"));
			d.setEmailid(rs.getString("cust_emailid"));
			d.setId(Integer.parseInt(rs.getString("id")));
			d.setTable(Integer.parseInt(rs.getString("table_no.")));
			d.setAvailable(Integer.parseInt(rs.getString("available")));
			d.setPayment(Integer.parseInt(rs.getString("payment_paid")));
			c.add(d);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return c;

		
	}

	@Override
	public void getUnavailable(String emailid, String id,String paymentMethod) {
		final String procedureCall = "{call Proc_Laabh2(?,?,?,?,?,?,?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getUnavailable");
		callableSt.setString(2, null);
		callableSt.setString(3, emailid);
		callableSt.setString(4, null);
		callableSt.setString(5, null);
		callableSt.setString(6, null);
		callableSt.setString(7, null);
		callableSt.setString(8, null);
		callableSt.setString(9, null);
		callableSt.setInt(10, Integer.parseInt(id));
		callableSt.setString(11, null);
		callableSt.setString(12, paymentMethod);
		callableSt.execute();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

		
	}

	@Override
	public void setBillDetail(String id, String method, String payment) {
		final String procedureCall = "{call Proc_Laabh5(?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "insert");
		callableSt.setString(2, id);
		callableSt.setInt(3, Integer.parseInt(payment));
		callableSt.setString(4, method);
		callableSt.execute();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

		
	}

	@Override
	public int getUniqueEmail(String emailid,String k,String username) {
		int x=0;
		final String procedureCall = "{call Proc_Laabh(?,?,?,?,?)}";
		Connection connection=null;
		try{
			connection =jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt=connection.prepareCall(procedureCall);
			callableSt.setString(1, "checkEmail");
			callableSt.setString(2, null);
			callableSt.setString(3, username);
			callableSt.setInt(4, Integer.parseInt(k));
			callableSt.setString(5, emailid);
			ResultSet rs=callableSt.executeQuery();
			if(rs.next())
			{
				if(rs.getString("username").equals(username))
				x=1;
				else
					x=2;
			}
			else
				x=0;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return x;
			}

	@Override
	public List<Customer> getAdminBillDetail() {
		List<Customer> l=new ArrayList();
		final String procedureCall = "{call Proc_Laabh2(?)}";
		Connection connection=null;
		try{
			connection =jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt=connection.prepareCall(procedureCall);
			callableSt.setString(1, "getForAdmin");
			ResultSet rs=callableSt.executeQuery();
			while(rs.next())
			{
				Customer d=new Customer();
				d.setName(rs.getString("cust_name"));
				d.setEmailid(rs.getString("cust_emailid"));
				d.setId(Integer.parseInt(rs.getString("id")));
				d.setTable(Integer.parseInt(rs.getString("table_no.")));
				d.setPayment(Integer.parseInt(rs.getString("payment_paid")));
				d.setPaymentMethod(rs.getString("paymentMethod"));
				l.add(d);

				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return l;

		
	}

	@Override
	public List<Customer> getAdminSearchBill(String emailid, String id) {
		List<Customer> c=new ArrayList();
		final String procedureCall = "{call Proc_Laabh2(?,?,?,?,?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getAdminSearchBill");
		callableSt.setString(2, null);
		callableSt.setString(3, emailid);
		callableSt.setString(4, null);
		callableSt.setString(5, null);
		callableSt.setString(6, null);
		callableSt.setString(7, null);
		callableSt.setString(8, null);
		callableSt.setString(9, null);
		callableSt.setInt(10, Integer.parseInt(id));
		ResultSet rs=callableSt.executeQuery();
		if(rs.next())
		{
			Customer d=new Customer();
			d.setName(rs.getString("cust_name"));
			d.setEmailid(rs.getString("cust_emailid"));
			d.setId(Integer.parseInt(rs.getString("id")));
			d.setTable(Integer.parseInt(rs.getString("table_no.")));
  			d.setPayment(Integer.parseInt(rs.getString("payment_paid")));
			d.setPaymentMethod(rs.getString("paymentMethod"));
			c.add(d);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return c;

		
	}

	@Override
	public List<totalorder> getAdminBill(String emailid, String id) {
		int price=0;
		int payment=0;
		List<totalorder> l=new ArrayList();
		final String procedureCall = "{call Proc_Laabh3(?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "getAdminCart");
		callableSt.setInt(2, Integer.parseInt(id));
		//System.out.print(Integer.parseInt(id));
		ResultSet rs=callableSt.executeQuery();
		while(rs.next())
		{
			int fp=Integer.parseInt(rs.getString("Full_Dish_Price"));
			int hp=Integer.parseInt(rs.getString("Half_Dish_Price"));
			int fq=Integer.parseInt(rs.getString("full_quantity"));
		    int hq=Integer.parseInt(rs.getString("half_quantity"));
			totalorder d=new totalorder();
			d.setDname(rs.getString("Dish_name"));
			d.setDtype(rs.getString("Dish_type"));
			d.setFull_price(rs.getString("Full_Dish_Price"));
			d.setHalf_price(rs.getString("Half_Dish_Price"));
			d.setFull_quantity(Integer.parseInt(rs.getString("full_quantity")));
			d.setHalf_quantity(Integer.parseInt(rs.getString("half_quantity")));
			d.setDishId(Integer.parseInt(rs.getString("dish_id")));
			price=(fp*fq)+(hp*hq);
			payment=payment+price;
			d.setTotalPrice(price);
			l.add(d);
			
		}
		totalorder d1=new totalorder();
		d1.setPayment(payment);
		l.add(d1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	return l;
			}

	@Override
	public int getSubmitEmail(String emailid, String k) {
		int x=0;
		final String procedureCall = "{call Proc_Laabh(?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "verifyEmail");
		callableSt.setString(2, null);
		callableSt.setString(3, null);
		callableSt.setInt(4,Integer.parseInt(k));
		callableSt.setString(5, emailid);
		ResultSet rs=callableSt.executeQuery();
		if(rs.next())
		{
			x=1;
		}
		else
			x=0;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}  
		return x;
	}

	@Override
	public void setOTP(String emailid, String k, int x) {
		final String procedureCall = "{call Proc_Laabh(?,?,?,?,?,?,?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "setOtp");
		callableSt.setString(2, null);
		callableSt.setString(3, null);
		callableSt.setInt(4,Integer.parseInt(k));
		callableSt.setString(5, emailid);
		callableSt.setString(6, null);
		callableSt.setString(7, null);
		callableSt.setString(8, null);
		callableSt.setString(9, null);
		callableSt.setString(10, null);
		callableSt.setString(11, null);
		callableSt.setInt(12, x);
		callableSt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int getCheckOtp(String emailid, String key, String otp) {
		int x=0;
		final String procedureCall = "{call Proc_Laabh(?,?,?,?,?,?,?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "checkOtp");
		callableSt.setString(2, null);
		callableSt.setString(3, null);
		callableSt.setInt(4,Integer.parseInt(key));
		callableSt.setString(5, emailid);
		callableSt.setString(6, null);
		callableSt.setString(7, null);
		callableSt.setString(8, null);
		callableSt.setString(9, null);
		callableSt.setString(10, null);
		callableSt.setString(11, null);
		callableSt.setInt(12, Integer.parseInt(otp));
		ResultSet rs=callableSt.executeQuery();
		if(rs.next())
		{
			x=1;
		}
		else
			x=0;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

		return x;
	}

	@Override
	public void getChangePassword(String emailid, String key, String password) {
		final String procedureCall = "{call Proc_Laabh(?,?,?,?,?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "changepassword");
		callableSt.setString(2, null);
		callableSt.setString(3, null);
		callableSt.setInt(4,Integer.parseInt(key));
		callableSt.setString(5, emailid);
		callableSt.setString(6, null);
		callableSt.setString(7, null);
		callableSt.setString(8, null);
		callableSt.setString(9, password);
		callableSt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

		
	}

	@Override
	public void getVerify(String emailid, String key) {
		final String procedureCall = "{call Proc_Laabh(?,?,?,?,?)}";
		Connection connection = null;
		try {	
		connection = jdbcTemplate.getDataSource().getConnection();
		CallableStatement callableSt = connection.prepareCall(procedureCall);
		callableSt.setString(1, "idVerify");
		callableSt.setString(2, null);
		callableSt.setString(3, null);
		callableSt.setInt(4,Integer.parseInt(key));
		callableSt.setString(5, emailid);
		callableSt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
				try{
					connection.close();
				}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

		
	}

}
