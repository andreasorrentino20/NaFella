package BeanTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.NaFella.Model.Bean.md5;

class md5Test {

	md5 md = new md5();
	String stringa = "rootroot";
	String algoritmo = "MD5";
	
	@Test
	void testHashCodeStringString() {
		Boolean tester = false;

		if(md.hashCode(stringa,algoritmo).equals("b4b8daf4b8ea9d39568719e1e320076f")) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

}
