/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.clause;

import java.util.ArrayList;

import edu.uci.ics.asterix.sqlpp.base.AbstractClause;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPFromItem;

/**
 * @author julestestard
 *
 */
public class FromClause extends AbstractClause {
	
	private ArrayList<SQLPPFromItem> items;

	/**
	 * 
	 */
	private static final long serialVersionUID = 9222840415638727897L;

	@Override
	public ClauseType getClauseType() {
		return ClauseType.FROM_CLAUSE;
	}

	/**
	 * @param items
	 */
	public FromClause(ArrayList<SQLPPFromItem> items) {
		super();
		this.items = items;
	}

	/**
	 * @return the items
	 */
	public ArrayList<SQLPPFromItem> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(ArrayList<SQLPPFromItem> items) {
		this.items = items;
	}
}
