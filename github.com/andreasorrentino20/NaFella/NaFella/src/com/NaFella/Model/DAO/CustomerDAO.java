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

import com.NaFella.Model.Bean.Customer;
import com.NaFella.Model.DAO.CustomerDAO;

public class CustomerDAO {

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

	private static final String TABLE_NAME = "customer";

	
	public synchronized void doSave(Customer customer) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into " + CustomerDAO.TABLE_NAME
				+ " (email, first_name, last_name, birth_date, phone_number, psw) values (?, ?, ?, ?, ?, ?)";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, customer.getEmail());
			preparedStatement.setString(2, customer.getFirstName());
			preparedStatement.setString(3, customer.getLastName());
			preparedStatement.setString(4, customer.getBirthdate());
			preparedStatement.setString(5, customer.getPhoneNumber());
			preparedStatement.setString(6, customer.getPsw());
			
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

	
	public synchronized Customer doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Customer bean = new Customer(0,null,null,null,null,null,null);

		String selectSQL = "select * from " + CustomerDAO.TABLE_NAME + " where id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setEmail(rs.getString("email"));
				bean.setFirstName(rs.getString("first_name"));
				bean.setLastName(rs.getString("last_name"));
				bean.setBirthdate(rs.getString("birth_date"));
				bean.setPhoneNumber(rs.getString("phone_number"));
				bean.setPsw(rs.getString("psw"));
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

	
	public synchronized boolean doDelete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "delete from " + CustomerDAO.TABLE_NAME + " where id = ?";

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

	
	public synchronized Collection<Customer> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Customer> customers = new LinkedList<Customer>();

		String selectSQL = "select * from " + CustomerDAO.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Customer bean = new Customer(0,null,null,null,null,null,null);

				bean.setId(rs.getInt("id"));
				bean.setEmail(rs.getString("email"));
				bean.setFirstName(rs.getString("first_name"));
				bean.setLastName(rs.getString("last_name"));
				bean.setPhoneNumber(rs.getString("phone_number"));
				customers.add(bean);
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
		return customers;
	}
	
	public synchronized Customer loginCustomer(String email,String psw) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Customer bean = new Customer(0,null,null,null,null,null,null);

		String selectSQL = "SELECT * FROM " + CustomerDAO.TABLE_NAME + " WHERE email = ? AND psw = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, psw);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			int numeroRighe = 0;
			
			if (rs.last()) 
			{
				// Riprendo il numero di righe
				numeroRighe = rs.getRow();
				
				// Torno alla posizione iniziale, prima della prima righa, operazione non permessa con il ResultSet.TYPE_FORWARD_ONLY
				rs.beforeFirst();
			}
			
			if(numeroRighe==1)
			{
				while (rs.next()) {	
					bean.setId(rs.getInt("id"));
					bean.setEmail(rs.getString("email"));
					bean.setFirstName(rs.getString("first_name"));
					bean.setLastName(rs.getString("last_name"));
					bean.setBirthdate(rs.getString("birth_date"));
					bean.setPhoneNumber(rs.getString("phone_number"));
					bean.setPsw(rs.getString("psw"));
				}
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

}

