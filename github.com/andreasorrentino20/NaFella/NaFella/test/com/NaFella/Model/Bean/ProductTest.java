package com.NaFella.Model.Bean;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {

	Product prod = new Product(1, "Chianina", "path", "Carne Rossa", "Carne di chianina succosa","15 Kg",25, 0, 15);

	@Test
	void testGetId() {
		Boolean tester = false;

		if(prod.getId()==1) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	}

	@Test
	void testSetId() {
		Boolean tester = false;

		prod.setId(2);
		if(prod.getId()==2) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	}

	@Test
	void testGetName() {
		Boolean tester = false;

		String nome = prod.getName();
		if(nome.equals("Chianina")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetName() {
		Boolean tester = false;

		prod.setName("Pollo");
		if(prod.getName().equals("Pollo")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}


	@Test
	void testGetType() {
		Boolean tester = false;

		String tipo	= prod.getType();
		if(tipo.equals("Carne Rossa")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testSetType() {
		Boolean tester = false;

		prod.setType("Carne Bianca");
		if(prod.getType().equals("Carne Bianca")) {
			tester=true;
		}
	}

	@Test
	void testGetDescription() {
		Boolean tester = false;

		String descr = prod.getDescription();
		if(descr.equals("Carne di chianina succosa")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testSetDescription() {
		Boolean tester = false;

		prod.setDescription("Pollo paesano");
		if(prod.getDescription().equals("Pollo paesano")) {
			tester=true;
		}
	}

	@Test
	void testGetPrice() {
		Boolean tester = false;

		double price = prod.getPrice();
		if(price==25) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testSetPrice() {
		Boolean tester = false;

		prod.setPrice(20);
		if(prod.getPrice() == 20) {
			tester=true;
		}
	}

	@Test
	void testGetDiscount() {
		Boolean tester = false;

		double discount = prod.getDiscount();
		if(discount==0) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetDiscount() {
		Boolean tester = false;

		prod.setDiscount(5);
		if(prod.getDiscount() == 5) {
			tester=true;
		}
	}

	@Test
	void testGetImg() {
		Boolean tester = false;

		String dispo = prod.getImg();
		if(dispo.equals("path")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	}

	@Test
	void testSetImg() {
		Boolean tester = false;

		prod.setImg("path1");
		if(prod.getImg().equals("path1")) {
			tester=true;	
		}
	}
	
	@Test
	void testGetSize() {
		Boolean tester = false;

		String dispo = prod.getSize();
		if(dispo.equals("15 Kg")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	}

	@Test
	void testSetSize() {
		Boolean tester = false;

		prod.setSize("10 kg");
		if(prod.getSize().equals("10 kg")) {
			tester=true;	
		}
	}
	
	@Test
	void testGetAvailability() {
		Boolean tester = false;

		int dispo = prod.getAvailability();
		if(dispo==15) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	}

	@Test
	void testSetAvailability() {
		Boolean tester = false;

		prod.setAvailability(20);
		if(prod.getAvailability() == 20) {
			tester=true;	
		}
	}
	
	@Test
	void testToString() {
		Boolean tester = false;
		
		if(prod.toString().equals("Product [id=\"prod.getId()\", name=\"prod.getName\", img=\"prod.getImg\", type=\"prod.getType\", description=\"prod.getDescription\", size=\"prod.getSize\", price=\"prod.getPrice\", discount=\"prod.getDiscount\", availability=\"prod.getAvailability\"]")) {
			tester = true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}
	
}
