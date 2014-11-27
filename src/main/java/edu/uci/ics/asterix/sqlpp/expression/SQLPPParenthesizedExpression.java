/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;

/**
 * @author julestestard
 *
 */
public class SQLPPParenthesizedExpression extends AbstractExpression {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6128513727472807410L;
	private SQLPPSFWExpression expression;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.PARENTHESIZED_EXPRESSION;
	}

	/**
	 * @return the expression
	 */
	public SQLPPSFWExpression getExpression() {
		return expression;
	}

	/**
	 * @param expression the expression to set
	 */
	public void setExpression(SQLPPSFWExpression expression) {
		this.expression = expression;
	}

	/**
	 * @param expression
	 */
	public SQLPPParenthesizedExpression(SQLPPSFWExpression expression) {
		super();
		this.expression = expression;
	}

}
