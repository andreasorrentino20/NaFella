package BeanTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.NaFella.Model.Bean.ReadFile;

class ReadFileTest {

	ReadFile read = new ReadFile();
	int n = 2;
	
	@Test
	void testReadFile1() throws FileNotFoundException {
		Boolean tester = false;

		if(read.readFile()!=0) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

	@Test
	void testWriteFile() throws IOException {
		Boolean tester = false;

		read.writeFile(n);
		
		if(read.readFile()!=0) {
			tester=true;
			assertEquals(tester, true);
		}
		else
			fail("Test Fallito");
	}

}
