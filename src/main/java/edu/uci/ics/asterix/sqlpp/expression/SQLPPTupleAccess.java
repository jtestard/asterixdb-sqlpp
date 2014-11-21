/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;

/**
 * @author julestestard
 *
 */
public class SQLPPTupleAccess extends AbstractExpression {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2037922104713201977L;
	private Identifier ident;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.TUPLE_ACCESS_EXPRESSION;
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
	 * @param ident
	 */
	public SQLPPTupleAccess(Identifier ident) {
		super();
		this.ident = ident;
	}

}
