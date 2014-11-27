/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;

/**
 * @author julestestard
 *
 */
public class SQLPPVariableRef extends AbstractExpression {
	
	private Identifier variable;

	/**
	 * 
	 */
	private static final long serialVersionUID = 6088417110951552601L;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.VARIABLE_EXPRESSION;
	}

	/**
	 * @return the var
	 */
	public Identifier getVar() {
		return variable;
	}

	/**
	 * @param var the var to set
	 */
	public void setVar(Identifier var) {
		this.variable = var;
	}

	/**
	 * @param var
	 */
	public SQLPPVariableRef(Identifier var) {
		super();
		this.variable = var;
	}

}
