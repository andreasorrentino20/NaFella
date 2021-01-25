package com.NaFella.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.NaFella.Model.Bean.Order;
import com.NaFella.Model.DAO.ProductDAO;
import com.NaFella.Model.Bean.Selection;
import com.NaFella.Model.DAO.SelectionDAO;


public class SelectionDAO {
	
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
	
	static final String TABLE_NAME = "selection";
	
	public synchronized void doSave(Selection selection) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into " + SelectionDAO.TABLE_NAME
				+ " (product_id, purchase_id, image, real_price) values (?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, selection.getProductId());
			preparedStatement.setInt(2, selection.getPurchaseId());
			preparedStatement.setString(3, selection.getImage());
			preparedStatement.setDouble(4, selection.getRealPrice());
			
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
	
	public void doSaveSelection(List<Selection> selections) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into " + SelectionDAO.TABLE_NAME
				+ " (product_id, purchase_id, image, real_price) values (?, ?, ?, ?)";
		
		try {
			for(int i = 0; i < selections.size(); i++) {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, selections.get(i).getProductId());
			preparedStatement.setInt(2, selections.get(i).getPurchaseId());
			preparedStatement.setString(3, selections.get(i).getImage());
			preparedStatement.setDouble(4, selections.get(i).getRealPrice());
				
			preparedStatement.executeUpdate();
			
			connection.commit();
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
	}
	
	public synchronized Order doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Order bean = new Order(0,null,null,null,0,0,0);

		String selectSQL = "select * from " + SelectionDAO.TABLE_NAME + " where id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setPaymentState(rs.getString("payment_state"));
				bean.setCustomerId(rs.getInt("customer_id"));
				bean.setCustomerAddress(rs.getInt("customer_address"));
				bean.setPrice(rs.getDouble("totale_price"));
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

		String deleteSQL = "delete from " + ProductDAO.TABLE_NAME + " where id = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate();

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

	
	public synchronized Collection<Order> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Order> orders = new LinkedList<Order>();

		String selectSQL = "select * from " + SelectionDAO.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " order by " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Order bean = new Order(0,null,null,null,0,0,0);

				bean.setId(rs.getInt("id"));
				bean.setPaymentState(rs.getString("payment_state"));
				bean.setCustomerId(rs.getInt("customer_id"));
				bean.setCustomerAddress(rs.getInt("customer_address"));
				bean.setPrice(rs.getDouble("totale_price"));
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
