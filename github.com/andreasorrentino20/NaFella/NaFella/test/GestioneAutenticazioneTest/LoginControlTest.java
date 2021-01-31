package GestioneAutenticazioneTest;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import com.NaFella.Control.GestioneAutenticazione.LoginControl;
import com.NaFella.Model.DAO.AddressDAO;
import com.NaFella.Model.DAO.AdminDAO;
import com.NaFella.Model.DAO.CustomerDAO;
import com.NaFella.Model.DAO.OrderDAO;
import com.NaFella.Model.DAO.ProductDAO;

class LoginControlTest {
	
	ProductDAO productDAO = new ProductDAO();
	OrderDAO orderDAO = new OrderDAO();
	AddressDAO addressDAO = new AddressDAO();
	CustomerDAO customerDAO = new CustomerDAO();
	AdminDAO adminDAO = new AdminDAO();
	LoginControl loginControl = new LoginControl();

	@Test
	void testLoginControl() {
		fail("Not yet implemented");
	}

	@Test
	void testDoGetHttpServletRequestHttpServletResponse() {
		
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

}
