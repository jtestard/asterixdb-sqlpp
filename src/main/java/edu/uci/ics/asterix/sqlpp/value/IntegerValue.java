/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.value;

import edu.uci.ics.asterix.sqlpp.base.AbstractValue;
import edu.uci.ics.asterix.sqlpp.base.DefinedValue;

/**
 * @author julestestard
 *
 */
public class IntegerValue extends AbstractValue implements DefinedValue {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1375561542236084675L;
	private int value;

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
		return Type.INTEGER;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @param value
	 */
	public IntegerValue(int value) {
		super();
		this.value = value;
	}

}
