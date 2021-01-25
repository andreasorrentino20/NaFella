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

import com.NaFella.Model.Bean.Product;
import com.NaFella.Model.DAO.ProductDAO;

public class ProductDAO {

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
	

	static final String TABLE_NAME = "product";

	
	public synchronized void doSave(Product product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into " + ProductDAO.TABLE_NAME
				+ " (product_name, size, image, tipoPiatto, product_type, description, price, discount,availability) values (?,?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getSize());
			preparedStatement.setString(3, product.getImg());
			preparedStatement.setString(5, product.getType());
			preparedStatement.setString(6, product.getDescription());
			preparedStatement.setDouble(7, product.getPrice());
			preparedStatement.setDouble(8, product.getDiscount());
			preparedStatement.setInt(9, product.getAvailability());
			
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
	}

	
	public synchronized Product doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Product bean = new Product(0, null, null, null, null, null, 0, 0, 0);

		String selectSQL = "select * from " + ProductDAO.TABLE_NAME + " where id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("product_name"));
				bean.setSize(rs.getString("size"));
				bean.setImg(rs.getString("image"));
				bean.setType(rs.getString("product_type"));
				bean.setDescription(rs.getString("description"));
				bean.setPrice(rs.getDouble("price"));
				bean.setDiscount(rs.getDouble("discount"));
				bean.setAvailability(rs.getInt("availability"));
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

	public synchronized boolean doModify(Product product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int result = 0;
		
		String insertSQL = "UPDATE " + ProductDAO.TABLE_NAME + " SET product_name = ?, size=?, image=? ,tipoPiatto = ?,product_type=? ,"
							+ "description=? ,price=?, discount = ?, availability = ? where id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getSize());
			preparedStatement.setString(3, product.getImg());
			preparedStatement.setString(5, product.getType());
			preparedStatement.setString(6, product.getDescription());
			preparedStatement.setDouble(7, product.getPrice());
			preparedStatement.setDouble(8, product.getDiscount());
			preparedStatement.setInt(9, product.getAvailability());
			preparedStatement.setInt(10, product.getId());
			
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

		String deleteSQL = "delete from " + ProductDAO.TABLE_NAME + " where id = ?";

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

	
	public synchronized Collection<Product> doRetrieveAll(String order,String action,String sex,int id_purchase) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Product> products = new LinkedList<Product>();
		
		String selectSQL = null;
		
		if(action!=null && sex!=null)
		{
			selectSQL = "select * from " + ProductDAO.TABLE_NAME + " where product_type = ? AND tipoPiatto = ?" ;
		}
		else
		{
			selectSQL = "select * from " + ProductDAO.TABLE_NAME;
		}
		
		if(action!=null)
		{
			if(action.equalsIgnoreCase("accept_purchase"))
			{
				selectSQL = "select * from purchase, selection, product " +
						"where selection.product_id=product.id AND selection.purchase_id=purchase.id AND purchase.id = ?";
			}
		}
		
		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}
		
		System.out.println("sono prima del try");
		try {
			System.out.println("sono prima di connection");
			connection = ds.getConnection();
			System.out.println("sono DOPO di connection");
			preparedStatement = connection.prepareStatement(selectSQL);
			if(action!=null && sex!=null)
			{
				preparedStatement.setString(1, action);
				preparedStatement.setString(2,sex);
			}
			if(action!=null)
			{
				if(action.equalsIgnoreCase("accept_purchase"))
				{
					preparedStatement.setInt(1, id_purchase); 
				}
			}
			System.out.println("sono prima di rs");
			ResultSet rs = preparedStatement.executeQuery();
			
			System.out.println("sono DOPO di rs");
			System.out.println("query = "+ selectSQL + " action = " + action + "  tipoPiatto = " + sex);
			while (rs.next()) {
				
				System.out.println("sono DOPO il while"); 
				Product bean = new Product(0, null, null, null, null, null, 0, 0, 0);

				bean.setId(rs.getInt("product.id"));
				bean.setName(rs.getString("product_name"));
				bean.setSize(rs.getString("size"));
				bean.setImg(rs.getString("image"));
				bean.setType(rs.getString("product_type"));
				bean.setDescription(rs.getString("description"));
				bean.setPrice(rs.getDouble("price"));
				bean.setDiscount(rs.getDouble("discount"));
				bean.setAvailability(rs.getInt("availability"));
				products.add(bean);
				System.out.println("sono DOPO l'add"); 
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
		return products;
	}
	
	public synchronized Collection<Product> doRetrieveAll_for_Order(String order,int id_customer,int track) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Product> products = new LinkedList<Product>();
		
		String	selectSQL = null;	
		
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
						"where selection.product_id=product.id AND selection.purchase_id=purchase.id AND purchase.customer_address=address.id ";
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
				
				Product product_bean = new Product(0, null, null, null, null, null, 0, 0, 0);

				product_bean.setName(rs.getString("product.product_name"));
				product_bean.setSize(rs.getString("product.size"));
				
				product_bean.setType(rs.getString("product.product_type"));
				
		
				products.add(product_bean);
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
		return products;
	}
	
	public synchronized boolean doUpdateByKey(int id, String action) throws SQLException {
		boolean t = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateSQL;
		if(action.equals("add")) {
			updateSQL ="update " + ProductDAO.TABLE_NAME + " set availability = availability+1 where id = ?";
		} else {
			updateSQL ="update " + ProductDAO.TABLE_NAME +" set availability = availability-1 where id = ?";
		}
		
		try {
			connection = ds.getConnection();
			
			preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
			t = true;
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
		return t;
	}
	

}
