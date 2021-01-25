package com.NaFella.Model.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.NaFella.Model.Bean.Address;
import com.NaFella.Model.DAO.AddressDAO;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.NaFella.Model.Bean.Address;
import com.mysql.jdbc.Statement;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

class AddressDAOTest {

	
	AddressDAO addressDAO = new AddressDAO();
//	Address address = new Address(5,"bo","1234","nocera","salerno","italia",3);
	
	private static DataSource ds = null;
	
	
	@Test
	void testDoSave() throws SQLException, NamingException {
		/*DataSource ds = DataSource.getDataSource("foo");
	    Connection conn = ds.getConnection();
		Boolean tester = false;
		addressDAO.doSave(address);
		if(addressDAO.doRetrieveByKey(5).equals(addressDAO.doRetrieveByKey(6)))
			assertEquals(tester,true);
		else
			fail("Test non andato a buon fine");*/
		fail("Not yet implemented");
	}

	@Test
	void testDoModify() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveByKey() {
		fail("Not yet implemented");
	}

	@Test
	void testDoDelete()throws SQLException {
		boolean inserito=false;
		Connection connection = null;
		Statement stmtSelect=null;

		connection = (Connection) ds.getConnection();
		try {
			stmtSelect = (Statement) connection.createStatement();
			String sql2 =
					("INSERT INTO address VALUES('10','casmez','80030','carbonara','napoli','italia','15');");
			stmtSelect.executeUpdate(sql2);
			connection.commit();
		} finally {
			try {
				if (stmtSelect != null) {
					stmtSelect.close();
				}
			}
				finally {
					connection.close();		
				}
			}
			addressDAO.doDelete(10);
			Address address2 = addressDAO.doRetrieveByKey(10);
			if (address2.getId()==10) {
				inserito =false;
			}
			else
				assertEquals(inserito, true);
		}

	@Test
	void testDoRetrieveAll() {
		fail("Not yet implemented");
	}

}
