package com.NaFella.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TimeZone;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.TimeZone;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.tomcat.jdbc.pool.PoolProperties;

import com.NaFella.Model.Bean.Address;
import com.NaFella.Model.DAO.AddressDAO;


public class AddressDAO {
	
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


	private static final String TABLE_NAME = "address";

	
	public synchronized void doSave(Address address) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into " + AddressDAO.TABLE_NAME + " (street, city, postal_code, province, country, id_customer) values (?, ?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, address.getStreet());
			preparedStatement.setString(2, address.getCity());
			preparedStatement.setString(3, address.getPostalCode());
			preparedStatement.setString(4, address.getProvince());
			preparedStatement.setString(5, address.getCountry());
			preparedStatement.setInt(6, address.getIdCustomer());
			
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

	public synchronized boolean doModify(Address address) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int result = 0;
		
		String insertSQL = "UPDATE " + AddressDAO.TABLE_NAME + " SET street = ?, city=?, postal_code=?, province=? ,country=? where id = ?";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, address.getStreet());
			preparedStatement.setString(2, address.getCity());
			preparedStatement.setString(3, address.getPostalCode());
			preparedStatement.setString(4, address.getProvince());
			preparedStatement.setString(5, address.getCountry());
			preparedStatement.setInt(6, address.getId());
			
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
	
	public synchronized Address doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Address bean = new Address(0,null,null,null,null,null,0);

		String selectSQL = "select * from " + AddressDAO.TABLE_NAME + " where id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setStreet(rs.getString("street"));
				bean.setPostalCode(rs.getString("postal_code"));
				bean.setCity(rs.getString("city"));
				bean.setProvince(rs.getString("province"));
				bean.setCountry(rs.getString("country"));
				bean.setIdCustomer(rs.getInt("id_customer"));
				
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

	
	public synchronized boolean doDelete(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + AddressDAO.TABLE_NAME + " WHERE id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

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

	
	public synchronized Collection<Address> doRetrieveAll(String order,int id_customer, int track) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Address> addresses = new LinkedList<Address>(); 
		
		String	selectSQL = null;	
		
		if(id_customer!=0)
		{ 
			selectSQL = "select * from " + AddressDAO.TABLE_NAME + " where id_customer = ?";
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
				Address bean = new Address(0,null,null,null,null,null,0);

				bean.setId(rs.getInt("id"));
				bean.setStreet(rs.getString("street"));
				bean.setPostalCode(rs.getString("postal_code"));
				bean.setCity(rs.getString("city"));
				bean.setProvince(rs.getString("province"));
				bean.setCountry(rs.getString("country"));
				bean.setIdCustomer(rs.getInt("id_customer"));
				addresses.add(bean);
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
		return addresses;
	}
}
