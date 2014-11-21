/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.value;

import java.util.ArrayList;

import edu.uci.ics.asterix.sqlpp.base.AbstractValue;

/**
 * @author julestestard
 *
 */
public class ArrayValue extends AbstractValue {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3209026529760283251L;
	private ArrayList<AbstractValue> values;

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
		return Type.ARRAY;
	}

	/**
	 * @return the values
	 */
	public ArrayList<AbstractValue> getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(ArrayList<AbstractValue> values) {
		this.values = values;
	}

	/**
	 * @param values
	 */
	public ArrayValue(ArrayList<AbstractValue> values) {
		super();
		this.values = values;
	}
}
