/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.parser;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cedarsoftware.util.io.JsonWriter;

import edu.uci.ics.asterix.sqlpp.base.AbstractStatement;
import edu.uci.ics.asterix.sqlpp.statement.SQLPPQuery;

/**
 * This class tests the SQLPP parser for asterix. For each test case,
 * a json file representing the generated Abstract Syntax Tree (AST) is 
 * available at `${asterix-sqlpp-root}/target/generated-asts`.
 * 
 * @author julestestard
 *
 */
public class SQLPPTest {

	/**
	 * These directory paths assume this test is run from the asterix-db directory. 
	 */
	final String TEST_RESOURCE_DIR_PATH = "test/resources/";
	final String TEST_OUTPUT_DIR_PATH = "target/generated-asts/"; //"/Users/julestestard/Development/eclipse-luna/workspace/asterixdb/asterix-sqlpp/target/generated-asts";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testHelloWorld() {
		String testFileName = "testHelloWorld";
		String queryStr = "\"Hello World!\"";
		InputStream stringStream = new java.io.ByteArrayInputStream(
				queryStr.getBytes());
		try {
			SQLPP parser = new SQLPP(stringStream);
			List<AbstractStatement> results = parser.Statements();
			String output = "";
			for (AbstractStatement stmt : results) {
				SQLPPQuery q = (SQLPPQuery) stmt;
				output += JsonWriter.formatJson(q.toJSON());
			}
			PrintWriter writer = new PrintWriter(TEST_OUTPUT_DIR_PATH
					+ testFileName + ".json", "UTF-8");
			writer.println(output);
			writer.close();
		} catch (ParseException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void testAndExpression() {
		String testFileName = "testAndExpression";
		String queryStr = "1 != 2 and true";
		InputStream stringStream = new java.io.ByteArrayInputStream(
				queryStr.getBytes());
		try {
			SQLPP parser = new SQLPP(stringStream);
			List<AbstractStatement> results = parser.Statements();
			String output = "";
			for (AbstractStatement stmt : results) {
				SQLPPQuery q = (SQLPPQuery) stmt;
				output += JsonWriter.formatJson(q.toJSON());
			}
			PrintWriter writer = new PrintWriter(TEST_OUTPUT_DIR_PATH
					+ testFileName + ".json", "UTF-8");
			writer.println(output);
			writer.close();
			assertTrue(true);
		} catch (ParseException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

}
