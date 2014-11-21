/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;
import edu.uci.ics.asterix.sqlpp.base.AbstractValue;

/**
 * @author julestestard
 *
 */
public class SQLPPNamedValueExpression extends AbstractExpression {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5155470808163010522L;

	private Identifier name;
	private AbstractValue value;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.NAMED_EXPRESSION;
	}

	/**
	 * @param name
	 * @param value
	 */
	public SQLPPNamedValueExpression(Identifier name, AbstractValue value) {
		super();
		this.name = name;
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public Identifier getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(Identifier name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public AbstractValue getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(AbstractValue value) {
		this.value = value;
	}

}
