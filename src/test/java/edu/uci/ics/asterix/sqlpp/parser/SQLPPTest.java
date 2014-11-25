/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.parser;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.uci.ics.asterix.sqlpp.base.AbstractStatement;

/**
 * @author julestestard
 *
 */
public class SQLPPTest {

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
	public void test() {
		String string = "1+(2+3)*4*2+7";
		InputStream stringStream = new java.io.ByteArrayInputStream(string.getBytes());
		try {
			SQLPP parser = new SQLPP(stringStream);
			List<AbstractStatement> results = parser.Statements();
	        for (AbstractStatement stmt : results) {
	            SQLPPQuery q = (SQLPPQuery) stmt; 
	            System.out.println(q);	
	        }
		} catch (ParseException e) {
	        System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
