package DAOTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.NaFella.Model.Bean.Address;
import com.NaFella.Model.DAO.AddressDAO;

class AddressDAOTest {

	Address address = new Address(1,"Casmez","80030","Carbonara","NA","Italia",3);
	
	AddressDAO addressDAO = new AddressDAO();
	
	@Test
	void testDoSave() throws SQLException {
		Boolean tester = false;

		addressDAO.doSave(address);
		
		if(addressDAO.doRetrieveByKey(1) == address) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testDoModify() {
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

}
