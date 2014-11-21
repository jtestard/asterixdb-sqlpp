/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;

/**
 * @author julestestard
 *
 */
public class SQLPPFromInnerJoin extends SQLPPFromItem {
	
	private SQLPPFromItem left;
	private SQLPPFromItem right;
	private AbstractExpression conditionExpr;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3848019099410931274L;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.FROM_ITEM_INNER_JOIN_EXPRESSION;
	}

	/**
	 * @param left
	 * @param right
	 * @param conditionExpr
	 */
	public SQLPPFromInnerJoin(SQLPPFromItem left, SQLPPFromItem right,
			AbstractExpression conditionExpr) {
		super();
		this.left = left;
		this.right = right;
		this.conditionExpr = conditionExpr;
	}

	/**
	 * @return the left
	 */
	public SQLPPFromItem getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(SQLPPFromItem left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public SQLPPFromItem getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(SQLPPFromItem right) {
		this.right = right;
	}

	/**
	 * @return the conditionExpr
	 */
	public AbstractExpression getConditionExpr() {
		return conditionExpr;
	}

	/**
	 * @param conditionExpr the conditionExpr to set
	 */
	public void setConditionExpr(AbstractExpression conditionExpr) {
		this.conditionExpr = conditionExpr;
	}

}
