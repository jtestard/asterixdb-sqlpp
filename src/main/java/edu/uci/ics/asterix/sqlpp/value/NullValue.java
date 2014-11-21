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
public class NullValue extends AbstractValue implements DefinedValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7242553468908610148L;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractValue#getValue()
	 */
	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractValue#getLiteralType()
	 */
	@Override
	public Type getLiteralType() {
		// TODO Auto-generated method stub
		return Type.NULL;
	}

	public NullValue() {}
}
