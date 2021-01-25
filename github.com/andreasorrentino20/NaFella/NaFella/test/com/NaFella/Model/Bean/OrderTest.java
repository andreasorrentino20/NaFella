package com.NaFella.Model.Bean;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {

	Order order = new Order(1,"20/01/2021","TRKC96","Pagato",2,1,50);

	@Test
	void testGetId() {
		Boolean tester = false;

		if(order.getId()==1) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testSetId() {
		Boolean tester = false;

		order.setId(2);
		if(order.getId()==2) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testGetDate() {
		Boolean tester = false;

		if(order.getDate().equals("20/01/2021")){
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testSetDate() {
		Boolean tester = false;

		order.setDate("18/01/2021");
		if(order.getDate().equals("18/01/2021")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testGetTracking() {
		Boolean tester = false;

		if(order.getTracking().equals("TRKC96")){
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testSetTracking() {
		Boolean tester = false;

		order.setTracking("TRKC92");
		if(order.getTracking().equals("TRKC92")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testGetPaymentState() {
		Boolean tester = false;

		if(order.getPaymentState().equals("Pagato")){
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testSetPaymentState() {
		Boolean tester = false;

		order.setPaymentState("Non Pagato");
		if(order.getPaymentState().equals("Non Pagato")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testGetCustomerAddress() {
		Boolean tester = false;

		if(order.getCustomerAddress()==2){
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");		
	}

	@Test
	void testSetCustomerAddress() {
		Boolean tester = false;

		order.setCustomerAddress(3);
		if(order.getCustomerAddress()==3) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testGetCustomerId() {
		Boolean tester = false;

		if(order.getCustomerId()==1){
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testSetCustomerId() {
		Boolean tester = false;

		order.setCustomerId(3);
		if(order.getCustomerId()==3) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testGetPrice() {
		Boolean tester = false;

		if(order.getPrice()==50){
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");		}

	@Test
	void testSetPrice() {
		Boolean tester = false;

		order.setPrice(80);
		if(order.getPrice()==80) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");		
	}

}
