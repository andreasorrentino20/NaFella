package DAOTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.NaFella.Model.Bean.Customer;
import com.NaFella.Model.DAO.AddressDAO;
import com.NaFella.Model.DAO.AdminDAO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.xml.bind.CycleRecoverable.Context;

class AdminDAOTest {

	String order = "1";
	String email = "gigi@gmail.com";
	String psw = "rootroot";
	
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
	
	Customer customer = new Customer(1,"gigi@gmail.com","Luigi","Cicalese","18/09/95","3409934503","rootroot");
	AdminDAO adminDAO = new AdminDAO();
	
	@Test
	void testDoSave() throws SQLException {
		assertNotNull(ds);
		when(c.prepareStatement(any(String.class))).thenReturn(stmt);
		when(ds.getConnection()).thenReturn(c);
		Boolean tester = false;
		
		adminDAO.doSave(customer);
		
		if((adminDAO.doRetrieveByKey(1)).equals(customer)) {
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
		
		if(adminDAO.doRetrieveByKey(1).equals(customer)) {
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
		
		if(adminDAO.doDelete(1)) {
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
		
		if(adminDAO.doRetrieveAll(order) != null) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testLoginAdmin() throws SQLException {
		assertNotNull(ds);
		when(c.prepareStatement(any(String.class))).thenReturn(stmt);
		when(ds.getConnection()).thenReturn(c);
		Boolean tester = false;
		
		if(adminDAO.loginAdmin(email,psw) == adminDAO.doRetrieveByKey(1)) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

}
