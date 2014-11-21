/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.statement;

import java.io.IOException;

import com.cedarsoftware.util.io.JsonWriter;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;
import edu.uci.ics.asterix.sqlpp.base.AbstractStatement;

/**
 * @author julestestard
 *
 */
public class SQLPPQuery extends AbstractStatement {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3451569601760923546L;
	private AbstractExpression body;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.Statement#getKind()
	 */
	public Kind getKind() {
		// TODO Auto-generated method stub
		return Kind.Query;
	}

	/**
	 * @return the body
	 */
	public AbstractExpression getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(AbstractExpression body) {
		this.body = body;
	}

}
