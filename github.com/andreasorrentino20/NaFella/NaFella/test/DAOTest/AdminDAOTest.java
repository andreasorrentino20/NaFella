package DAOTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.NaFella.Model.Bean.Customer;
import com.NaFella.Model.DAO.AddressDAO;
import com.NaFella.Model.DAO.AdminDAO;

class AdminDAOTest {

	Customer customer = new Customer(1,"gigi@gmail.com","Luigi","Cicalese","18/09/95","3409934503","rootroot");
	AdminDAO adminDAO = new AdminDAO();
	
	@Test
	void testDoSave() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveByKey() {
		fail("Not yet implemented");
	}

	@Test
	void testDoDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveAll() {
		fail("Not yet implemented");
	}

	@Test
	void testLoginAdmin() {
		fail("Not yet implemented");
	}

}
