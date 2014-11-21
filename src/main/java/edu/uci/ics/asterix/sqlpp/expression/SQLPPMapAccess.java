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
public class SQLPPMapAccess extends AbstractExpression {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3516893314255812484L;
	private AbstractValue value;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.MAP_ACCESS_EXPRESSION;
	}

	/**
	 * @return the value
	 */
	public AbstractValue getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(AbstractValue value) {
		this.value = value;
	}

	/**
	 * @param value
	 */
	public SQLPPMapAccess(AbstractValue value) {
		super();
		this.value = value;
	}

}
