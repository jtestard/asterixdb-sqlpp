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
public class FalseValue extends AbstractValue implements DefinedValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4775892696270010885L;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractValue#getValue()
	 */
	@Override
	public Object getValue() {
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractValue#getLiteralType()
	 */
	@Override
	public Type getLiteralType() {
		return Type.FALSE;
	}
	
	public FalseValue() {
		super();
	}
	
	public String toJSON() throws IOException {
		return "false";
	}

}
