/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import java.io.IOException;
import java.util.ArrayList;

import edu.uci.ics.asterix.sqlpp.base.AbstractClause;
import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;

/**
 * @author julestestard
 *
 */
public class SQLPPSFWExpression extends AbstractExpression {
	
	ArrayList<AbstractClause> clauses;

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
	public SQLPPSFWExpression(ArrayList<AbstractClause> clauses) {
		super();
		this.clauses = clauses;
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
	
	public String toJSON() throws IOException {
		String it = "[";
		for (AbstractClause item : clauses) {
			it += item.toJSON() + ",";
		}
		it = it.substring(0, it.length()-1) + "]";
		return it;
	}

}
