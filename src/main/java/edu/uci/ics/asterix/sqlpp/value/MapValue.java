/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.value;

import java.util.HashMap;

import edu.uci.ics.asterix.sqlpp.base.AbstractValue;

/**
 * @author julestestard
 *
 */
public class MapValue extends AbstractValue {

	private HashMap<AbstractValue,AbstractValue> values;
	/**
	 * 
	 */
	private static final long serialVersionUID = 9129962312680247968L;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractValue#getValue()
	 */
	@Override
	public Object getValue() {
		return values;
	}

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractValue#getLiteralType()
	 */
	@Override
	public Type getLiteralType() {
		return Type.MAP;
	}

	/**
	 * @return the values
	 */
	public HashMap<AbstractValue,AbstractValue> getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(HashMap<AbstractValue,AbstractValue> values) {
		this.values = values;
	}

	/**
	 * @param values
	 */
	public MapValue(HashMap<AbstractValue,AbstractValue> values) {
		super();
		this.values = values;
	}
}
