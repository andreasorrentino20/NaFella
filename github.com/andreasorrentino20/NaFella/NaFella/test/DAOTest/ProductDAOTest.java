package DAOTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.NaFella.Model.Bean.Product;
import com.NaFella.Model.DAO.ProductDAO;

class ProductDAOTest {

	Product prod = new Product(1, "Chianina", "path", "Carne Rossa", "Carne di chianina succosa","15 Kg",25, 0, 15);
	ProductDAO productDAO = new ProductDAO();
	
	@Test
	void testDoSave() {
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
	void testDoRetrieveAll() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveAll_for_Order() {
		fail("Not yet implemented");
	}

	@Test
	void testDoUpdateByKey() {
		fail("Not yet implemented");
	}

}
