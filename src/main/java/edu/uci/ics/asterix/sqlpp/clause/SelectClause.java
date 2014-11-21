/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.clause;

import java.util.ArrayList;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;
import edu.uci.ics.asterix.sqlpp.base.AbstractClause;
import edu.uci.ics.asterix.sqlpp.expression.Identifier;
import edu.uci.ics.asterix.sqlpp.expression.SQLPPSelectItemExpression;

/**
 * @author julestestard
 *
 */
public class SelectClause extends AbstractClause {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3173795173311127362L;
	
	private ArrayList<SQLPPSelectItemExpression> items;
	

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractClause#getClauseType()
	 */
	@Override
	public ClauseType getClauseType() {
		return ClauseType.SELECT_CLAUSE;
	}


	/**
	 * @param items
	 */
	public SelectClause(ArrayList<SQLPPSelectItemExpression> items) {
		super();
		this.items = items;
	}


	/**
	 * @return the items
	 */
	public ArrayList<SQLPPSelectItemExpression> getItems() {
		return items;
	}


	/**
	 * @param items the items to set
	 */
	public void setItems(ArrayList<SQLPPSelectItemExpression> items) {
		this.items = items;
	}

}
