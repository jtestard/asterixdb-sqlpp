/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.value;

import java.util.HashMap;

import edu.uci.ics.asterix.sqlpp.base.AbstractValue;
import edu.uci.ics.asterix.sqlpp.base.DefinedValue;
import edu.uci.ics.asterix.sqlpp.expression.Identifier;

/**
 * @author julestestard
 *
 */
public class TupleValue extends AbstractValue implements DefinedValue {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5356718606741792399L;
	
	private HashMap<Identifier,AbstractValue> fields;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractValue#getValue()
	 */
	@Override
	public Object getValue() {
		return fields;
	}

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractValue#getLiteralType()
	 */
	@Override
	public Type getLiteralType() {
		return Type.TUPLE;
	}

	/**
	 * @return the fields
	 */
	public HashMap<Identifier, AbstractValue> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(HashMap<Identifier, AbstractValue> fields) {
		this.fields = fields;
	}

	/**
	 * @param fields
	 */
	public TupleValue(HashMap<Identifier, AbstractValue> fields) {
		super();
		this.fields = fields;
	}

}
