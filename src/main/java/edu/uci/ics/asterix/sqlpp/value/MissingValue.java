/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.value;

import edu.uci.ics.asterix.sqlpp.base.AbstractValue;

/**
 * @author julestestard
 *
 */
public class MissingValue extends AbstractValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4014744785950278418L;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractValue#getValue()
	 */
	@Override
	public Object getValue() {
		return "missing";
	}

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractValue#getLiteralType()
	 */
	@Override
	public Type getLiteralType() {
		return Type.MISSING;
	}

	public MissingValue() {}
}
