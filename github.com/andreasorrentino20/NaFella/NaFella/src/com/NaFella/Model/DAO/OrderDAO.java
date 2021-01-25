package com.NaFella.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.NaFella.Model.Bean.Order;
import com.NaFella.Model.DAO.OrderDAO;

public class OrderDAO {
	
private static DataSource ds;
	
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/nafella");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	

	static final String TABLE_NAME = "purchase";

	
	public synchronized void doSave(Order order) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into " + OrderDAO.TABLE_NAME 
				+ " (payment_state, total_price, customer_address, customer_id) values (?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, order.getPaymentState());
			preparedStatement.setDouble(2, order.getPrice());
			preparedStatement.setInt(3, order.getCustomerAddress());
			preparedStatement.setInt(4, order.getCustomerId());
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		//this.doSaveSelection(order);
	}
	
	public void doSaveSelection(Order order) {
		//TODO
	}
	
	public synchronized Order doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Order bean = new Order(0,null,null,null,0,0,0);

		String selectSQL = "select * from " + OrderDAO.TABLE_NAME + " where id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setTracking(rs.getString("tracking_code"));
				String date = rs.getString("purchase_date").substring(0,19);
				bean.setDate(date);
				bean.setPaymentState(rs.getString("payment_state"));
				bean.setCustomerId(rs.getInt("customer_id"));
				bean.setCustomerAddress(rs.getInt("customer_address"));
				bean.setPrice(rs.getDouble("total_price"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
	}

	public synchronized boolean doModify(Order order) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int result = 0;
		
		String insertSQL = "UPDATE " + OrderDAO.TABLE_NAME + " SET tracking_code = ? where id = ?";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, order.getTracking());
			preparedStatement.setInt(2, order.getId());
			
			result = preparedStatement.executeUpdate();

			connection.commit();
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}
	
	public synchronized boolean doDelete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "delete from " + OrderDAO.TABLE_NAME + " where id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate();
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}
	
	public synchronized Order doRetrieveLastId() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Order order = new Order(0,null,null,null,0,0,0);
		String selectSQL = "select id from "+ OrderDAO.TABLE_NAME +" order by id desc limit 1";
		
		Order bean = new Order(0,null,null,null,0,0,0);
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			ResultSet rs = preparedStatement.executeQuery();
			rs.first();
			bean.setId(rs.getInt("id"));
			System.out.println(bean.getId());
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		if(bean.getId()!=-1) {
			return bean;
		}  else {
			return new Order(0,null,null,null,0,0,0);
		}
	}
		
		
	
	public synchronized Collection<Order> doRetrieveAll(String order,int id_customer,int track) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Order> orders = new LinkedList<Order>();
		String selectSQL = null;		
		
		if(id_customer!=0)
		{ 
			selectSQL = "select * from purchase, selection, product  "
							+ "where selection.product_id=product.id AND selection.purchase_id=purchase.id AND customer_id = ?";
		}
		else
		{ 
			if(track == 1)
			{
				selectSQL = "select * from purchase, selection, product, address " +
						"where selection.product_id=product.id AND selection.purchase_id=purchase.id AND purchase.customer_address=address.id "
						+ "AND purchase.tracking_code IS NULL";
			}
			else
			{
				selectSQL = "select * from purchase, selection, product, address " +
						"where selection.product_id=product.id AND selection.purchase_id=purchase.id AND purchase.customer_address=address.id";
			}
			
		}
		
		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order + " desc";
		}

		try {
			connection = ds.getConnection();			
			preparedStatement = connection.prepareStatement(selectSQL);
			if(id_customer!=0)
				preparedStatement.setInt(1, id_customer);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Order bean = new Order(0,null,null,null,0,0,0);

				bean.setId(rs.getInt("purchase.id"));
				bean.setTracking(rs.getString("purchase.tracking_code"));
				String date = rs.getString("purchase.purchase_date").substring(0,19);
				bean.setDate(date);
				bean.setPaymentState(rs.getString("purchase.payment_state"));
				bean.setCustomerId(rs.getInt("purchase.customer_id"));
				bean.setCustomerAddress(rs.getInt("purchase.customer_address"));
				bean.setPrice(rs.getDouble("purchase.total_price"));	
				orders.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return orders;
	}

}
