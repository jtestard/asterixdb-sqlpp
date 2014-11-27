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
package edu.uci.ics.asterix.sqlpp.expression;

import java.io.IOException;

import com.cedarsoftware.util.io.JsonWriter;

import edu.uci.ics.asterix.sqlpp.base.ISqlppExpression;

public class Identifier implements ISqlppExpression {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7001220918191136197L;
	protected String identifier;

    public Identifier() {
    }

    public Identifier(String value) {
        this.identifier = value;
    }

    public final String getValue() {
        return identifier;
    }

    public final void setValue(String value) {
        this.identifier = value;
    }

    public String toString() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Identifier)) {
            return false;
        } else {
            Identifier i = (Identifier) o;
            return this.identifier.equals(i.identifier);
        }
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    public String toJSON() throws IOException {
		return JsonWriter.objectToJson(this);
	}
}
