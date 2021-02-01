package DAOTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import org.junit.jupiter.api.Test;

import com.NaFella.Model.Bean.Address;
import com.NaFella.Model.DAO.AddressDAO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StatementImpl;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sun.xml.bind.CycleRecoverable.Context;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;


public class AddressDAOTest {
	
	String order = "1";
	int idcustomer = 3;
	int track = 1010;
  
	Context context = mock(Context.class);
	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	HttpSession session = mock(HttpSession.class);
	RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	ServletContext servletContext = mock(ServletContext.class);
	
	
	 DataSource ds = mock(DataSource.class);
	 Connection c = mock(Connection.class);
	 PreparedStatement stmt = mock(PreparedStatement.class);
	 ResultSet rs = mock(ResultSet.class);
	
	//AddressDAO addressDAO = mock(AddressDAO.class);
	Address address = new Address(1,"Casmez","80030","Carbonara","NA","Italia",3);
	
	AddressDAO addressDAO = new AddressDAO();
	DriverManager driverManager = mock(DriverManager.class);
	MysqlDataSource d = new MysqlDataSource();
	
	
	@Test
	void testDoSave() throws SQLException, NamingException {
		assertNotNull(ds);
		when(c.prepareStatement(any(String.class))).thenReturn(stmt);
		when(ds.getConnection()).thenReturn(c);
		Boolean tester = false;
		

		//when(rs.getInt(1)).thenReturn(address.getId());
		
		addressDAO.doSave(address);
		
		
		if(addressDAO.doRetrieveByKey(1).equals(address)) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testDoModify() throws SQLException {
		assertNotNull(ds);
		when(c.prepareStatement(any(String.class))).thenReturn(stmt);
		when(ds.getConnection()).thenReturn(c);
		Boolean tester = false;

		//when(rs.getInt(1)).thenReturn(address.getId());
		
		//addressDAO.doSave(address);
		
		
		if(addressDAO.doRetrieveByKey(1).equals(address)) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testDoRetrieveByKey() throws SQLException {
		assertNotNull(ds);
		when(c.prepareStatement(any(String.class))).thenReturn(stmt);
		when(ds.getConnection()).thenReturn(c);
		Boolean tester = false;
		
		if(addressDAO.doRetrieveByKey(1).equals(address)) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testDoDelete() throws SQLException {
		assertNotNull(ds);
		when(c.prepareStatement(any(String.class))).thenReturn(stmt);
		when(ds.getConnection()).thenReturn(c);
		Boolean tester = false;
		
		if(addressDAO.doDelete(1)) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testDoRetrieveAll() throws SQLException {
		assertNotNull(ds);
		when(c.prepareStatement(any(String.class))).thenReturn(stmt);
		when(ds.getConnection()).thenReturn(c);
		Boolean tester = false;
		
		
		if(addressDAO.doRetrieveAll(order, idcustomer, track) != null) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

}
