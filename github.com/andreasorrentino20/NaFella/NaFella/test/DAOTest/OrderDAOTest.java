package DAOTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.NaFella.Model.Bean.Order;
import com.NaFella.Model.DAO.CustomerDAO;
import com.NaFella.Model.DAO.OrderDAO;

class OrderDAOTest {

	Order order = new Order(1,"20/01/2021","TRKC96","Pagato",2,1,50);
	OrderDAO orderDAO = new OrderDAO();
	
	@Test
	void testDoSave() {
		fail("Not yet implemented");
	}

	@Test
	void testDoSaveSelection() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveByKey() {
		fail("Not yet implemented");
	}

	@Test
	void testDoModify() {
		fail("Not yet implemented");
	}

	@Test
	void testDoDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveLastId() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveAll() {
		fail("Not yet implemented");
	}

}
