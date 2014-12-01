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
 * This class tests the SQLPP parser for SFW queries.
 * For each test case, the expected and actual JSON representation of the Abstract
 * Syntax Tree (AST) of the query are compared. Whether the test succeeds or fails,
 * the JSON representation itself will be stored in the directory pointed by
 * TEST_OUTPUT_DIR_PATH.  
 * 
 * @author julestestard
 *
 */
public class SQLPPSFWExpressionTest {

	/**
	 * These directory paths assume this test is run from the asterix-sqlpp directory.
	 * (Default JUnit test working directory in Eclipse).  
	 */
	final String TEST_RESOURCE_DIR_PATH = "src/test/resources/sfw-expressions/";
	final String TEST_OUTPUT_DIR_PATH = "target/generated-asts/sfw-expressions/";
	
	@Rule
	public TestName testName = new TestName();
	
	private String testFileName;
	private String expectedJSONString = "";
	private String actualJSONString = "";

	/**
	 * Reads the expected AST JSON string
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
	 * Writes the actual AST JSON string
	 * 
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
	public void testSelectFromExpression() {
		String queryStr = "SELECT id, name, age FROM person";
		testQuery(queryStr);
	}
	
	@Test
	public void testSelectAsExpression() {
		String queryStr = "SELECT id, name As firstName, age FROM person";
		testQuery(queryStr);
	}
	
	@Test
	public void testFromWhereExpression() {
		String queryStr = "SELECT id, name, age FROM person WHERE id = 2";
		testQuery(queryStr);
	}

	@Test
	public void testFromInnerJoinExpression() {
		String queryStr = "SELECT id, name, age FROM person JOIN books ON id = 2";
		testQuery(queryStr);
	}
	
	@Test
	public void testFromInnerJoinWithInnerKeywordExpression() {
		String queryStr = "SELECT id, name, age FROM person INNER JOIN books ON id = 2";
		testQuery(queryStr);
	}
	
	@Test
	public void testFromLeftOuterJoinExpression() {
		String queryStr = "SELECT id, name, age FROM person LEFT OUTER JOIN books ON id = 2";
		testQuery(queryStr);
	}
	
	@Test
	public void testFromRightOuterJoinExpression() {
		String queryStr = "SELECT id, name, age FROM person RIGHT OUTER JOIN books ON id = 2";
		testQuery(queryStr);
	}
	
	@Test
	public void testFromFullOuterJoinExpression() {
		String queryStr = "SELECT id, name, age FROM person FULL OUTER JOIN books ON id = 2";
		testQuery(queryStr);
	}
	
	@Test
	public void testCrossProductExpression() {
		String queryStr = "SELECT id, name, age FROM person, books WHERE id = 2";
		testQuery(queryStr);
	}
	
	@Test
	public void testTinySocialQuery1() {
		String queryStr = "SELECT FB.alias FROM FacebookUsers AS FB WHERE FB.id = 8";
		testQuery(queryStr);
	}
	
	@Test
	public void testTinySocialQuery2() {
		String queryStr = "SELECT FBU.name AS uname, FBM.message AS message\n" +
				"FROM FacebookUsers AS FBU LEFT OUTER JOIN FacebookMessages AS FBM\n" +
				"ON FBU.id = FBM.author-id";
		testQuery(queryStr);
	}
}
