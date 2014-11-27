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

public abstract class AbstractExpression implements ISqlppExpression {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7182696313506770654L;

	public abstract Kind getKind();

    public enum Kind {
        PARENTHESIZED_EXPRESSION,
        VALUE_EXPRESSION,
        VARIABLE_EXPRESSION,
        CALL_EXPRESSION,
        OP_EXPRESSION,
        TUPLE_ACCESS_EXPRESSION,
        MAP_ACCESS_EXPRESSION,
        ARRAY_ACCESS_EXPRESSION,
        ALIAS_EXPRESSION,
        NAMED_EXPRESSION,
        UNARY_EXPRESSION,
        SFW_EXPRESSION,
        SELECT_ITEM_EXPRESSION,
        FROM_ITEM_SINGLE_EXPRESSION,
        FROM_ITEM_INNER_JOIN_EXPRESSION,
        FROM_ITEM_OUTER_JOIN_EXPRESSION
    }
    
    public String toJSON() throws IOException {
    	return JsonWriter.objectToJson(this);
    }

}
