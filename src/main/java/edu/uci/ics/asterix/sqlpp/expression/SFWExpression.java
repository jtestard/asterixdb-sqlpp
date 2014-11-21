/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import java.util.ArrayList;

import edu.uci.ics.asterix.sqlpp.base.AbstractClause;
import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;

/**
 * @author julestestard
 *
 */
public class SFWExpression extends AbstractExpression {
	
	ArrayList<AbstractClause> clauses;
	AbstractExpression returnExpr;

	/**
	 * 
	 */
	private static final long serialVersionUID = -3710544070434793095L;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.SFW_EXPRESSION;
	}

	/**
	 * @param clauses
	 * @param returnExpr
	 */
	public SFWExpression(ArrayList<AbstractClause> clauses,
			AbstractExpression returnExpr) {
		super();
		this.clauses = clauses;
		this.returnExpr = returnExpr;
	}

	/**
	 * @return the clauses
	 */
	public ArrayList<AbstractClause> getClauses() {
		return clauses;
	}

	/**
	 * @param clauses the clauses to set
	 */
	public void setClauses(ArrayList<AbstractClause> clauses) {
		this.clauses = clauses;
	}

	/**
	 * @return the returnExpr
	 */
	public AbstractExpression getReturnExpr() {
		return returnExpr;
	}

	/**
	 * @param returnExpr the returnExpr to set
	 */
	public void setReturnExpr(AbstractExpression returnExpr) {
		this.returnExpr = returnExpr;
	}

}
