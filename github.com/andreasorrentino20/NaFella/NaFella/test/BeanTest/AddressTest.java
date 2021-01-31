package BeanTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.NaFella.Model.Bean.Address;

class AddressTest {

	Address address = new Address(1,"Casmez","80030","Carbonara","NA","Italia",3);

	@Test
	void testGetId() {
		Boolean tester = false;

		if(address.getId()==1) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetId() {
		Boolean tester = false;

		address.setId(2);
		if(address.getId()==2) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testGetStreet() {
		Boolean tester = false;

		String via = address.getStreet();
		if(via.equals("Casmez")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}


	@Test
	void testSetStreet() {
		Boolean tester = false;

		address.setStreet("Roma");
		if(address.getStreet().equals("Roma")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testGetPostalCode() {
		Boolean tester = false;

		String postal = address.getPostalCode();
		if(postal.equals("80030")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetPostalCode() {
		Boolean tester = false;

		address.setPostalCode("80031");
		if(address.getPostalCode().equals("80031")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	}

	@Test
	void testGetCity() {
		Boolean tester = false;

		String citta = address.getCity();
		if(citta.equals("Carbonara")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}	

	@Test
	void testSetCity() {
		Boolean tester = false;

		address.setCity("Fisciano");
		if(address.getCity().equals("Fisciano")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");		

	}

	@Test
	void testGetProvince() {
		Boolean tester = false;

		String prov = address.getProvince();
		if(prov.equals("NA")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testSetProvince() {
		Boolean tester = false;

		address.setProvince("SA");
		if(address.getProvince().equals("SA")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");		
	}

	@Test
	void testGetCountry() {
		Boolean tester = false;

		String conutry = address.getCountry();
		if(conutry.equals("Italia")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetCountry() {
		Boolean tester = false;

		address.setCountry("Francia");
		if(address.getCountry().equals("Francia")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}

	@Test
	void testGetIdCustomer() {
		Boolean tester = false;

		int idCost = address.getIdCustomer();
		if(idCost==3) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}	

	@Test
	void testSetIdCustomer() {
		Boolean tester = false;

		address.setIdCustomer(4);
		if(address.getIdCustomer()==4) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");	
	}	
}

