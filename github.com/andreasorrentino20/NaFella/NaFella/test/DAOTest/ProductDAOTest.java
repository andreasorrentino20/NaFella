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

import com.NaFella.Model.Bean.Product;
import com.NaFella.Model.DAO.ProductDAO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.xml.bind.CycleRecoverable.Context;

class ProductDAOTest {
	String order = "1";
	String action = "action";
	String sex = "nullo";
	int idPurchase = 1;
	
	int idCustomer = 1;
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

	Product prod = new Product(1, "Chianina", "path", "Carne Rossa", "Carne di chianina succosa","15 Kg",25, 0, 15);
	Product newProd = new Product(2, "Chianina", "path", "Carne Rossa", "Carne di chianina succosa","15 Kg",25, 0, 15);
	ProductDAO productDAO = new ProductDAO();
	
	@Test
	void testDoSave() throws SQLException {
		assertNotNull(ds);
		when(c.prepareStatement(any(String.class))).thenReturn(stmt);
		when(ds.getConnection()).thenReturn(c);
		Boolean tester = false;
		
		productDAO.doSave(prod);
		
		
		if(productDAO.doRetrieveByKey(1).equals(prod)) {
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
		
		if(productDAO.doRetrieveByKey(1).equals(prod)) {
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
		
		if(productDAO.doModify(newProd)) {
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
		
		if(productDAO.doDelete(1)) {
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
		
		if(productDAO.doRetrieveAll(order,action,sex,idPurchase) != null) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testDoRetrieveAll_for_Order() throws SQLException {
		assertNotNull(ds);
		when(c.prepareStatement(any(String.class))).thenReturn(stmt);
		when(ds.getConnection()).thenReturn(c);
		Boolean tester = false;
		
		if(productDAO.doRetrieveAll_for_Order(order,idCustomer,track) != null) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testDoUpdateByKey() throws SQLException {
		assertNotNull(ds);
		when(c.prepareStatement(any(String.class))).thenReturn(stmt);
		when(ds.getConnection()).thenReturn(c);
		Boolean tester = false;
		
		if(productDAO.doUpdateByKey(2,action)) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

}
