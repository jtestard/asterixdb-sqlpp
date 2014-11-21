/*
 * Copyright 2009-2013 by The Regents of the University of California
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * you may obtain a copy of the License from
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.uci.ics.asterix.sqlpp.base;

import java.io.IOException;

import com.cedarsoftware.util.io.JsonWriter;

public abstract class AbstractValue implements ISqlppExpression {
    /**
     * 
     */
    private static final long serialVersionUID = -6468144574890768345L;

    public enum Type {
        STRING,
        INTEGER,
        LONG,
        NULL,
        TRUE,
        FALSE,
        FLOAT,
        DOUBLE,
        MISSING,
        TUPLE,
        BAG,
        MAP,
        ARRAY
    }

    abstract public Object getValue();

    abstract public Type getLiteralType();

    public String getStringValue() {
        return getValue().toString();
    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractValue)) {
            return false;
        }
        AbstractValue literal = (AbstractValue) obj;
        return getValue().equals(literal.getValue());
    }

    @Override
    public String toString() {
        return getStringValue();
    }
    
    public String toJSON() throws IOException {
    	return JsonWriter.objectToJson(this);
	}
}
