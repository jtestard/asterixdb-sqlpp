/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.base;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author julestestard
 *
 */
public interface ISqlppExpression extends Serializable {
	
	/**
	 * All SqlPP expression can be serialized as JSON strings.
	 * @return
	 */
	public String toJSON() throws IOException; 

}
