/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.value;

import java.io.IOException;

import edu.uci.ics.asterix.sqlpp.base.AbstractValue;
import edu.uci.ics.asterix.sqlpp.base.DefinedValue;

/**
 * @author julestestard
 *
 */
public class LongValue extends AbstractValue implements DefinedValue {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8051524815021781878L;
	private long value;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractValue#getValue()
	 */
	@Override
	public Object getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractValue#getLiteralType()
	 */
	@Override
	public Type getLiteralType() {
		return Type.LONG;
	}

	/**
	 * @param value
	 */
	public LongValue(long value) {
		super();
		this.value = value;
	}

	public String toJSON() throws IOException {
		return "" + value;
	}
}
