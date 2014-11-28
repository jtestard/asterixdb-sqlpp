/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;

/**
 * @author julestestard
 *
 */
public class SQLPPArrayAcess extends SQLPPAbstractAccessor {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7082948386543680620L;
	private AbstractExpression indexExpr;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.ARRAY_ACCESS_EXPRESSION;
	}

	/**
	 * @return the index
	 */
	public AbstractExpression getIndex() {
		return indexExpr;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(AbstractExpression index) {
		this.indexExpr = index;
	}

	/**
	 * @param index
	 */
	public SQLPPArrayAcess(AbstractExpression expr, AbstractExpression index) {
		super(expr);
		this.indexExpr = index;
	}
}
