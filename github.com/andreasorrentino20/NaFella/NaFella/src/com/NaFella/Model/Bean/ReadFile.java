package com.NaFella.Model.Bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ReadFile {
	
	static {
		file = new File("C:/Program Files/Apache Software Foundation/Tomcat 8.5/webapps/NaFella/last_save.dat");
	}
	
	public ReadFile() {}
	
	public synchronized static int readFile() throws FileNotFoundException {
		int n = 0;
		Scanner s = new Scanner(file);
		while(s.hasNextInt()) {
			n = s.nextInt();
		}
		s.close();
		return n;
	}
	
	public synchronized static void writeFile(int n) throws IOException {
		FileOutputStream fs = new FileOutputStream(file.getPath());
		PrintStream ps = new PrintStream(file);
		ps.print(n);
		ps.close();
		fs.close();
	}
	
	static File file;
}
