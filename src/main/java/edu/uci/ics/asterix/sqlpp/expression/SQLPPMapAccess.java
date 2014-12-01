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
public class SQLPPMapAccess extends SQLPPAbstractAccessor {
	
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
	public SQLPPMapAccess(AbstractExpression expr, AbstractValue value) {
		super(expr);
		this.value = value;
	}

    public String toJSON() throws IOException {
		return "{" +
				"\"expression\":" + this.expr.toJSON() + "," +
				"\"()\":" + value.toJSON() +
				"}";
	}
	
}
