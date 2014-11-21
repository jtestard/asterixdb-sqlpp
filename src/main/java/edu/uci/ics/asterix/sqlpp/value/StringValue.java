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
public class StringValue extends AbstractValue implements DefinedValue {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1699403588340489952L;
	private String value;
	
	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractValue#getValue()
	 */
	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractValue#getLiteralType()
	 */
	@Override
	public Type getLiteralType() {
		// TODO Auto-generated method stub
		return Type.STRING;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @param value
	 */
	public StringValue(String value) {
		super();
		this.value = value;
	}

}
