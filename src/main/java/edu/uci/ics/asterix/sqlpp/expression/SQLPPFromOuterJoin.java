/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;

/**
 * @author julestestard
 *
 */
public class SQLPPFromOuterJoin extends SQLPPFromItem {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8693383208706734723L;
	
	private OuterJoinType outerJoinType;
	private SQLPPFromItem left;
	private SQLPPFromItem right;
	private AbstractExpression conditionExpr;

	/**
	 * 
	 */
	public SQLPPFromOuterJoin() {
	}

	/**
	 * @param outerJoinType
	 * @param left
	 * @param right
	 * @param conditionExpr
	 */
	public SQLPPFromOuterJoin(OuterJoinType outerJoinType, SQLPPFromItem left,
			SQLPPFromItem right, AbstractExpression conditionExpr) {
		super();
		this.outerJoinType = outerJoinType;
		this.left = left;
		this.right = right;
		this.conditionExpr = conditionExpr;
	}

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.FROM_ITEM_OUTER_JOIN_EXPRESSION;
	}
	
    public enum OuterJoinType {
        LEFT,
        RIGHT,
        FULL,
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

	/**
	 * @return the outerJoinType
	 */
	public OuterJoinType getOuterJoinType() {
		return outerJoinType;
	}
}
