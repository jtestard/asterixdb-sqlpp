/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;

/**
 * @author julestestard
 *
 */
public class SQLPPFromSingle extends SQLPPFromItem {
	
	private SQLPPVariableRef var;
	
	private AbstractExpression expression;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2834753589276188069L;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.FROM_ITEM_SINGLE_EXPRESSION;
	}

	/**
	 * @param var
	 * @param expression
	 */
	public SQLPPFromSingle(SQLPPVariableRef var, AbstractExpression expression) {
		super();
		this.var = var;
		this.expression = expression;
	}

	/**
	 * @return the var
	 */
	public SQLPPVariableRef getVar() {
		return var;
	}

	/**
	 * @param var the var to set
	 */
	public void setVar(SQLPPVariableRef var) {
		this.var = var;
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

}