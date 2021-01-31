package GestioneMagazzinoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.NaFella.Control.GestioneMagazzino.UploadFile;
import com.NaFella.Model.DAO.AddressDAO;
import com.NaFella.Model.DAO.AdminDAO;
import com.NaFella.Model.DAO.CustomerDAO;
import com.NaFella.Model.DAO.OrderDAO;
import com.NaFella.Model.DAO.ProductDAO;

class UploadFileTest {

	ProductDAO productDAO = new ProductDAO();
	OrderDAO orderDAO = new OrderDAO();
	AddressDAO addressDAO = new AddressDAO();
	CustomerDAO customerDAO = new CustomerDAO();
	AdminDAO adminDAO = new AdminDAO();
	UploadFile uploadFile = new UploadFile();
	
	@Test
	void testUploadFile() {
		fail("Not yet implemented");
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

	@Test
	void testFolder() {
		fail("Not yet implemented");
	}

}
