package GestioneCarrelloTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.NaFella.Control.GestioneCarrello.ConfirmCheckout;
import com.NaFella.Model.DAO.AddressDAO;
import com.NaFella.Model.DAO.AdminDAO;
import com.NaFella.Model.DAO.CustomerDAO;
import com.NaFella.Model.DAO.OrderDAO;
import com.NaFella.Model.DAO.ProductDAO;

class ConfirmCheckoutTest {

	ProductDAO productDAO = new ProductDAO();
	OrderDAO orderDAO = new OrderDAO();
	AddressDAO addressDAO = new AddressDAO();
	CustomerDAO customerDAO = new CustomerDAO();
	AdminDAO adminDAO = new AdminDAO();
	ConfirmCheckout confirmCheckout = new ConfirmCheckout();
	
	@Test
	void testConfirmCheckout() {
		fail("Not yet implemented");
	}

	@Test
	void testDoGetHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

}
