package BeanTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.NaFella.Model.Bean.Customer;

class CustomerTest {
	
	Customer customer = new Customer(1,"gigi@gmail.com","Luigi","Cicalese","18/09/95","3409934503","rootroot");

	@Test
	void testGetId() {
		Boolean tester = false;

		if(customer.getId()==1) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetId() {
		Boolean tester = false;

		customer.setId(2);
		if(customer.getId()==2) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testGetEmail() {
		Boolean tester = false;

		String via = customer.getEmail();
		if(via.equals("gigi@gmail.com")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetEmail() {
		Boolean tester = false;

		customer.setEmail("luigi@gmail.com");
		if(customer.getEmail().equals("luigi@gmail.com")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testGetFirstName() {
		Boolean tester = false;

		String postal = customer.getFirstName();
		if(postal.equals("Luigi")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetFirstName() {
		Boolean tester = false;

		customer.setFirstName("Giuseppe");
		if(customer.getFirstName().equals("Giuseppe")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testGetLastName() {
		Boolean tester = false;

		String postal = customer.getLastName();
		if(postal.equals("Cicalese")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetLastName() {
		Boolean tester = false;

		customer.setLastName("Celentano");
		if(customer.getLastName().equals("Celentano")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testGetBirthdate() {
		Boolean tester = false;

		String postal = customer.getBirthdate();
		if(postal.equals("18/09/95")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetBirthdate() {
		Boolean tester = false;

		customer.setBirthdate("01/01/01");
		if(customer.getBirthdate().equals("01/01/01")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testGetPhoneNumber() {
		Boolean tester = false;

		String postal = customer.getPhoneNumber();
		if(postal.equals("3409934503")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetPhoneNumber() {
		Boolean tester = false;

		customer.setPhoneNumber("1234567890");
		if(customer.getPhoneNumber().equals("1234567890")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testGetPsw() {
		Boolean tester = false;

		String postal = customer.getPsw();
		if(postal.equals("rootroot")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testSetPsw() {
		Boolean tester = false;

		customer.setPsw("gigigigi");
		if(customer.getPsw().equals("gigigigi")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

}
