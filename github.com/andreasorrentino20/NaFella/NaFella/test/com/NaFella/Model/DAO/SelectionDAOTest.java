package com.NaFella.Model.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.mysql.jdbc.Statement;

class SelectionDAOTest {
	
	SelectionDAO selectionDAO = new SelectionDAO();
	
	private static DataSource ds = null;

	@Test
	void testDoSave() {
		fail("Not yet implemented");
	}

	@Test
	void testDoSaveSelection() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveByKey() {
		fail("Not yet implemented");
	}

	@Test
	void testDoDelete() {
		boolean inserito=false;
		Connection connection = null;
		Statement stmtSelect=null;
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveAll() {
		fail("Not yet implemented");
	}

}
