/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import java.io.IOException;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;
import edu.uci.ics.asterix.sqlpp.base.ISqlppExpression;

/**
 * @author julestestard
 *
 */
public class SQLPPFromJoin extends SQLPPFromItem {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8693383208706734723L;
	
	private JoinType joinType;
	private SQLPPFromItem left;
	private SQLPPFromItem right;
	private AbstractExpression conditionExpr;

	/**
	 * 
	 */
	public SQLPPFromJoin() {
	}

	/**
	 * @param outerJoinType
	 * @param left
	 * @param right
	 * @param conditionExpr
	 */
	public SQLPPFromJoin(JoinType joinType, SQLPPFromItem left,
			SQLPPFromItem right, AbstractExpression conditionExpr) {
		super();
		this.joinType = joinType;
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
	
    public enum JoinType implements ISqlppExpression {
        LEFT_OUTER,
        RIGHT_OUTER,
        FULL_OUTER,
        INNER;
        
        public String toJSON() {
        	return "\"" + name() + "\"";
        }
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
	public JoinType getJoinType() {
		return joinType;
	}
	
    public String toJSON() throws IOException {
		return "{" +
				"\"type\" : \""+ this.getJoinType() + "\"," +
				"\"left\" : " + left.toJSON() + "," +
				"\"right\" : " + right.toJSON() + "," +
				"\"condition\" : " + conditionExpr.toJSON() + 
				"}";
	}
}
