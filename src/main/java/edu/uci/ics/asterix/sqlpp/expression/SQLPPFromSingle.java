/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import java.io.IOException;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;

/**
 * @author julestestard
 *
 */
public class SQLPPFromSingle extends SQLPPFromItem {
	
	private SQLPPVariableRef alias;
	
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
	public SQLPPFromSingle(SQLPPVariableRef alias, AbstractExpression expression) {
		super();
		this.alias = alias;
		this.expression = expression;
	}

	/**
	 * @return the var
	 */
	public SQLPPVariableRef getVar() {
		return alias;
	}

	/**
	 * @param var the var to set
	 */
	public void setVar(SQLPPVariableRef alias) {
		this.alias = alias;
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
	
    public String toJSON() throws IOException {
		return "{" + 
				"\"expression\":" + expression.toJSON() + "," +
				"\"alias\":" + ((alias == null) ? "\"null\"" : alias.toJSON()) +
				"}";
	}

}