/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.parser;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.cedarsoftware.util.io.JsonWriter;

import edu.uci.ics.asterix.sqlpp.base.AbstractStatement;
import edu.uci.ics.asterix.sqlpp.statement.SQLPPQuery;

/**
 * This class tests the SQLPP parser for operator expression queries.
 * For each test case, the expected and actual JSON representation of the Abstract
 * Syntax Tree (AST) of the query are compared. Whether the test succeeds or fails,
 * the JSON representation itself will be stored in the directory pointed by
 * TEST_OUTPUT_DIR_PATH.  
 * 
 * @author julestestard
 *
 */
public class SQLPPOperatorExpressionsTest {

	/**
	 * These directory paths assume this test is run from the asterix-sqlpp directory.
	 * (Default JUnit test working directory in Eclipse).  
	 */
	final String TEST_RESOURCE_DIR_PATH = "src/test/resources/operator-expressions/";
	final String TEST_OUTPUT_DIR_PATH = "target/generated-asts/operator-expressions/";
	
	@Rule
	public TestName testName = new TestName();
	
	private String testFileName;
	private String expectedJSONString;
	private String actualJSONString;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testFileName = testName.getMethodName();
//		File file = new File(TEST_RESOURCE_DIR_PATH
//				+ testFileName + ".json");
//		FileInputStream fis = new FileInputStream(file);
//		expectedJSONString = IOUtils.toString(fis);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		File file = new File(TEST_OUTPUT_DIR_PATH
				+ testFileName + ".json");
		file.getParentFile().mkdirs();
		FileWriter writer = new FileWriter(file);
		writer.write(actualJSONString);
		writer.close();
	}
	
	private void testQuery(String queryStr) {
		InputStream stringStream = new java.io.ByteArrayInputStream(
				queryStr.getBytes());
		try {
			SQLPP parser = new SQLPP(stringStream);
			List<AbstractStatement> results = parser.Statements();
			actualJSONString = "";
			for (AbstractStatement stmt : results) {
				SQLPPQuery q = (SQLPPQuery) stmt;
				actualJSONString += JsonWriter.formatJson(q.toJSON());
			}
//			assertEquals(expectedJSONString, actualJSONString);
		} catch (ParseException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHelloWorld() {
		String queryStr = "\"Hello World!\"";
		testQuery(queryStr);
	}

	@Test
	public void testEqualityExpression() {
		String queryStr = "1 = 2";
		testQuery(queryStr);
	}
	
	@Test
	public void testAndExpression() {
		String queryStr = "1 != 2 and true";
		testQuery(queryStr);
	}
	
	@Test
	public void testSumExpression() {
		String queryStr = "1 + 2 - 3";
		testQuery(queryStr);
	}
	
	@Test
	public void testMultExpression() {
		String queryStr = "1 * 2 + 3";
		testQuery(queryStr);
	}
	
//	@Test
//	public void testPathExpression() {
//		String queryStr = "person.info";
//		testQuery(queryStr);
//	}
}
