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
public class SQLPPSelectItemExpression extends AbstractExpression {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6427048095884193761L;

	/**
	 * SQLPPAliasExpression in case of "AS" statement. May be null.
	 */
	private SQLPPVariableRef alias;
	
	/**
	 * Item expression. May not be null.
	 */
	private AbstractExpression expression;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.SELECT_ITEM_EXPRESSION;
	}

	/**
	 * @param ident
	 * @param expression
	 */
	public SQLPPSelectItemExpression(SQLPPVariableRef var,
			AbstractExpression expression) {
		super();
		this.alias = var;
		this.expression = expression;
	}

	/**
	 * @return the ident
	 */
	public SQLPPVariableRef getIdent() {
		return alias;
	}

	/**
	 * @param ident the ident to set
	 */
	public void setIdent(SQLPPVariableRef var) {
		this.alias = var;
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
