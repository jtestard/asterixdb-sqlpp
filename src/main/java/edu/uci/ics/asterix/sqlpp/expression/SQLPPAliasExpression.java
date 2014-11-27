/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;

/**
 * This class isn't used currently.
 * 
 * @author julestestard
 *
 */
public class SQLPPAliasExpression extends AbstractExpression {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4090324983722968389L;
	
	private Identifier alias;

	/**
	 * 
	 */
	public SQLPPAliasExpression() {
	}

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.ALIAS_EXPRESSION;
	}

	/**
	 * @param ident
	 */
	public SQLPPAliasExpression(Identifier ident) {
		super();
		this.alias = ident;
	}

	/**
	 * @return the ident
	 */
	public Identifier getIdent() {
		return alias;
	}

	/**
	 * @param ident the ident to set
	 */
	public void setIdent(Identifier ident) {
		this.alias = ident;
	}

}
