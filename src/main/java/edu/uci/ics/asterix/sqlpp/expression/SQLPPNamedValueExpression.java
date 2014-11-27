/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;
import edu.uci.ics.asterix.sqlpp.base.AbstractValue;

/**
 * @author julestestard
 *
 */
public class SQLPPNamedValueExpression extends AbstractExpression {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5155470808163010522L;

	private Identifier name;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.NAMED_EXPRESSION;
	}

	/**
	 * @param name
	 * @param value
	 */
	public SQLPPNamedValueExpression(Identifier name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public Identifier getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(Identifier name) {
		this.name = name;
	}
}
