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
public class SQLPPTupleAccess extends SQLPPAbstractAccessor {
	
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
	public SQLPPTupleAccess(AbstractExpression expr, Identifier ident) {
		super(expr);
		this.ident = ident;
	}
	
    public String toJSON() throws IOException {
		return "{" +
				"\"expression\":" + this.expr.toJSON() + "," +
				"\".\":" + ident.toJSON() +
				"}";
	}

}
