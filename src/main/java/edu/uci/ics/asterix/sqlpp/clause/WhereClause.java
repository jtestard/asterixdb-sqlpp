/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.clause;

import java.io.IOException;

import edu.uci.ics.asterix.sqlpp.base.AbstractClause;
import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPFromItem;

/**
 * @author julestestard
 *
 */
public class WhereClause extends AbstractClause {

	/**
	 * 
	 */
	private static final long serialVersionUID = 372080076848459040L;
	
	private AbstractExpression expression;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractClause#getClauseType()
	 */
	@Override
	public ClauseType getClauseType() {
		return ClauseType.WHERE_CLAUSE;
	}

	/**
	 * @param expression
	 */
	public WhereClause(AbstractExpression expression) {
		super();
		this.expression = expression;
	}

	/**
	 * @return the expression
	 */
	public AbstractExpression getExpression() {
		return expression;
	}

	/**
	 * @param expression the expression to set
	 */
	public void setExpression(AbstractExpression expression) {
		this.expression = expression;
	}
	
	public String toJSON() throws IOException {
		return "{\"where\":" + expression.toJSON() + "}";
	}
}
