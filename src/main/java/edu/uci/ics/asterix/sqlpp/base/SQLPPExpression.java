/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.base;

import edu.uci.ics.asterix.aql.base.Expression;

/**
 * @author julestestard
 *
 */
public interface SQLPPExpression extends Expression {
    public enum Kind {
        LITERAL_EXPRESSION,
        //FLWOGR_EXPRESSION,
        //IF_EXPRESSION,
        //QUANTIFIED_EXPRESSION,
        // PARENTHESIZED_EXPRESSION,
        LIST_CONSTRUCTOR_EXPRESSION,
        RECORD_CONSTRUCTOR_EXPRESSION,
        VARIABLE_EXPRESSION,
        METAVARIABLE_EXPRESSION,
        CALL_EXPRESSION,
        OP_EXPRESSION,
        FIELD_ACCESSOR_EXPRESSION,
        INDEX_ACCESSOR_EXPRESSION,
        UNARY_EXPRESSION,
        UNION_EXPRESSION,
        //SQL++ specific expressions
        SFW_EXPRESSION,
        SQLPP_OP_EXPRESSION,
//        SQLPP_QUANTIFIED_EXPRESSION,
//        SQLPP_VALUE_EXPRESSION
    }
}
