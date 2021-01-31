package BeanTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.NaFella.Model.Bean.Cart;
import com.NaFella.Model.Bean.Product;

class CartTest {

	ArrayList<Product> products = new ArrayList<>();
	Product prod = new Product(1, "Chianina", "path1", "Carne Rossa", "Carne di chianina succosa","15 Kg",25, 0, 15);
	Cart cart = new Cart();

	@Test
	void testAddItem() {
		Boolean tester = false;
		cart.addItem(prod, "pathImg");

		ArrayList<Product> temp = cart.getProducts();
		ArrayList<String> tempS = cart.getImages();

		if(temp.get(0).getName().equals("Chianina")&&tempS.get(0).equals("pathImg")){
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testRemoveItem(){
		Boolean tester = false;
		cart.addItem(prod, "pathImg");
		cart.removeItem(0);

		ArrayList<Product> temp = cart.getProducts();
		ArrayList<String> tempS = cart.getImages();


		if(temp.size()==0 && tempS.size()==0) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}


	@Test
	void testClearCart() {
		Boolean tester = false;
		cart.addItem(prod, "pathImg");
		cart.clearCart();

		ArrayList<Product> temp = cart.getProducts();
		ArrayList<String> tempS = cart.getImages();


		if(temp.size()==0 && tempS.size()==0) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");		
	}

	@Test
	void testGetProducts() {
		Boolean tester = false;
		cart.addItem(prod, "pathImg");

		ArrayList<Product> temp = cart.getProducts();

		if(temp.get(0).getName().equals("Chianina")) {
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");		
	}

	@Test
	void testGetImages() {
		Boolean tester = false;
		cart.addItem(prod, "pathImg");

		ArrayList<String> tempS = cart.getImages();

		if(tempS.get(0).equals("pathImg")) {
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	}

}

