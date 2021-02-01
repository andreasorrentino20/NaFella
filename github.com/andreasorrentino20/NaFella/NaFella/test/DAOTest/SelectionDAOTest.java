package DAOTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.NaFella.Model.Bean.Selection;
import com.NaFella.Model.DAO.SelectionDAO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.xml.bind.CycleRecoverable.Context;

class SelectionDAOTest {
	
	List<Selection> selections;
	String order = "1";
	
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

	Selection selection = new Selection(1,2,"path",15);
	
	Selection selection1 = new Selection(1,2,"path1",15);
	Selection selection2 = new Selection(1,2,"path2",15);
	Selection selection3 = new Selection(1,2,"path3",15);
	
	SelectionDAO selectionDAO = new SelectionDAO();
	
	@Test
	void testDoSave() throws SQLException {
		assertNotNull(ds);
		when(c.prepareStatement(any(String.class))).thenReturn(stmt);
		when(ds.getConnection()).thenReturn(c);
		Boolean tester = false;
		
		selectionDAO.doSave(selection);
		
		
		if(selectionDAO.doRetrieveByKey(1).equals(selection)) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testDoSaveSelection() throws SQLException {
		assertNotNull(ds);
		when(c.prepareStatement(any(String.class))).thenReturn(stmt);
		when(ds.getConnection()).thenReturn(c);
		Boolean tester = false;
		
		selections.add(selection1);
		selections.add(selection2);
		selections.add(selection3);
		selectionDAO.doSaveSelection(selections);
		
		if(selectionDAO.doRetrieveByKey(1).equals(selection2)) {
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
		
		if(selectionDAO.doRetrieveByKey(1).equals(selection)) {
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
		
		if(selectionDAO.doDelete(1)) {
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
		
		if(selectionDAO.doRetrieveAll(order) != null) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

}
