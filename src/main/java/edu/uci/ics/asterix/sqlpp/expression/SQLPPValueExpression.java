/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import java.io.IOException;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;
import edu.uci.ics.asterix.sqlpp.base.AbstractValue;

/**
 * @author julestestard
 *
 */
public class SQLPPValueExpression extends AbstractExpression {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7854378625623889210L;

	private AbstractValue value;

	public SQLPPValueExpression() {
	}

	public SQLPPValueExpression(AbstractValue val) {
		value = val;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.VALUE_EXPRESSION;
	}

	/**
	 * @return the value
	 */
	public AbstractValue getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(AbstractValue value) {
		this.value = value;
	}
	
    public String toJSON() throws IOException {
		return value.toJSON();
	}

}
