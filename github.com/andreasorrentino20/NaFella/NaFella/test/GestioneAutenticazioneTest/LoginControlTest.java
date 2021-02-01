package GestioneAutenticazioneTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.catalina.manager.ManagerServlet;
import org.junit.jupiter.api.Test;

import com.NaFella.Control.GestioneAutenticazione.LoginControl;
import com.NaFella.Model.DAO.AddressDAO;
import com.NaFella.Model.DAO.AdminDAO;
import com.NaFella.Model.DAO.CustomerDAO;
import com.NaFella.Model.DAO.OrderDAO;
import com.NaFella.Model.DAO.ProductDAO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.xml.bind.CycleRecoverable.Context;

class LoginControlTest {
	
	ProductDAO productDAO = new ProductDAO();
	OrderDAO orderDAO = new OrderDAO();
	AddressDAO addressDAO = new AddressDAO();
	CustomerDAO customerDAO = new CustomerDAO();
	AdminDAO adminDAO = new AdminDAO();
	LoginControl loginControl = new LoginControl();
	
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

	 ManagerServlet servlet = new ManagerServlet();
	 String action;
	 
	@Test
	void testLoginControl() throws IOException, ServletException {
		request.setAttribute(action, "login_admin");
		
	}

	@Test
	void testDoGetHttpServletRequestHttpServletResponse() throws IOException, ServletException {
		request.setAttribute(action, "login_admin");
		servlet.doGet(request, response);
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

}
