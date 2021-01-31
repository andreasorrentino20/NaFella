package GestioneCarrelloTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.NaFella.Control.GestioneAutenticazione.SignupControl;
import com.NaFella.Control.GestioneCarrello.AddToCart;
import com.NaFella.Model.DAO.AddressDAO;
import com.NaFella.Model.DAO.AdminDAO;
import com.NaFella.Model.DAO.CustomerDAO;
import com.NaFella.Model.DAO.OrderDAO;
import com.NaFella.Model.DAO.ProductDAO;

class AddToCartTest {

	ProductDAO productDAO = new ProductDAO();
	OrderDAO orderDAO = new OrderDAO();
	AddressDAO addressDAO = new AddressDAO();
	CustomerDAO customerDAO = new CustomerDAO();
	AdminDAO adminDAO = new AdminDAO();
	AddToCart AddToCartControl = new AddToCart();
	
	@Test
	void testAddToCart() {
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
