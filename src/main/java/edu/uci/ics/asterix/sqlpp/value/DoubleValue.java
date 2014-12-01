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
public class DoubleValue extends AbstractValue implements DefinedValue {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6845170704924057664L;
	private double value;

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
		return Type.DOUBLE;
	}
	
	public DoubleValue() {}
	
	public DoubleValue(double val) {
		super();
		value = val;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}
	
	public String toJSON() throws IOException {
		return "" + value;
	}

}
