package com.NaFella.Model.Bean;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SelectionTest {
	
	Selection selection = new Selection(1,2,"path",15);

	@Test
	void testGetProductId() {
		Boolean tester = false;

		if(selection.getProductId()==1) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetProductId() {
		Boolean tester = false;

		selection.setProductId(2);
		if(selection.getProductId()==2) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testGetPurchaseId() {
		Boolean tester = false;

		if(selection.getPurchaseId()==2) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetPurchaseId() {
		Boolean tester = false;

		selection.setPurchaseId(3);
		if(selection.getPurchaseId()==3) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testGetImage() {
		Boolean tester = false;

		if(selection.getImage().equals("path")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetImage() {
		Boolean tester = false;

		selection.setImage("path1");
		if(selection.getImage().equals("path1")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testGetRealPrice() {
		Boolean tester = false;

		if(selection.getRealPrice()==15) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetRealPrice() {
		Boolean tester = false;

		selection.setRealPrice(20);
		if(selection.getRealPrice()==20) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

}
