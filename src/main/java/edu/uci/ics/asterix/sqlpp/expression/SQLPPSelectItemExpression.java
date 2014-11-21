/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

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
	 * Identifier in case of "AS" statement. May be null.
	 */
	private Identifier ident;
	
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
	public SQLPPSelectItemExpression(Identifier ident,
			AbstractExpression expression) {
		super();
		this.ident = ident;
		this.expression = expression;
	}

	/**
	 * @return the ident
	 */
	public Identifier getIdent() {
		return ident;
	}

	/**
	 * @param ident the ident to set
	 */
	public void setIdent(Identifier ident) {
		this.ident = ident;
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
