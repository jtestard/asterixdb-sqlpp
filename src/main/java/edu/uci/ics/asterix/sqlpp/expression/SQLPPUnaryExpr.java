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

import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;
import edu.uci.ics.asterix.sqlpp.base.ISqlppExpression;

public class SQLPPUnaryExpr extends AbstractExpression {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3796356616567750731L;
	private Sign sign;
    private AbstractExpression expr;

    public SQLPPUnaryExpr() {
    }

    public SQLPPUnaryExpr(Sign sign, AbstractExpression expr) {
        this.sign = sign;
        this.expr = expr;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public AbstractExpression getExpr() {
        return expr;
    }

    public void setExpr(AbstractExpression expr) {
        this.expr = expr;
    }

    @Override
    public Kind getKind() {
        return Kind.UNARY_EXPRESSION;
    }

    public enum Sign implements ISqlppExpression {
        POSITIVE,
        NEGATIVE;

		public String toJSON() throws IOException {
			return "\"" + name() + "\"";
		}
    }
    
    public String toJSON() throws IOException {
		return "{" + 
				"\"expression\":" + expr.toJSON() + "," +
				"\"sign\":" + sign.toJSON() +
				"}";
	}
}
