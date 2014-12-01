/**
 * 
 */
package edu.uci.ics.asterix.sqlpp.expression;

import java.io.IOException;
import java.util.ArrayList;

import edu.uci.ics.asterix.sqlpp.expression.OperatorType;
import edu.uci.ics.asterix.sqlpp.base.AbstractExpression;

/**
 * @author julestestard
 *
 */
public class SQLPPOperatorExpr extends AbstractExpression {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4003496933823847162L;
	
	private ArrayList<AbstractExpression> expressions;
	private ArrayList<OperatorType> operators;

	/* (non-Javadoc)
	 * @see edu.uci.ics.asterix.sqlpp.base.AbstractExpression#getKind()
	 */
	@Override
	public Kind getKind() {
		return Kind.OP_EXPRESSION;
	}
	
    public SQLPPOperatorExpr() {
        super();
        expressions = new ArrayList<AbstractExpression>();
        operators = new ArrayList<OperatorType>();
    }
    
    public SQLPPOperatorExpr(ArrayList<AbstractExpression> exps, ArrayList<OperatorType> ops) {
        super();
        expressions = exps;
        operators = ops;
    }
	
	public void addOperand(AbstractExpression operand) {
		expressions.add(operand);
	}
	
    public void addOperator(String strOp) {
        if ("or".equals(strOp))
            operators.add(OperatorType.OR);
        else if ("and".equals(strOp))
            operators.add(OperatorType.AND);
        else if ("<".equals(strOp))
            operators.add(OperatorType.LT);
        else if (">".equals(strOp))
            operators.add(OperatorType.GT);
        else if ("<=".equals(strOp))
            operators.add(OperatorType.LE);
        else if ("<=".equals(strOp))
            operators.add(OperatorType.LE);
        else if (">=".equals(strOp))
            operators.add(OperatorType.GE);
        else if ("=".equals(strOp))
            operators.add(OperatorType.EQ);
        else if ("!=".equals(strOp))
            operators.add(OperatorType.NEQ);
        else if ("+".equals(strOp))
            operators.add(OperatorType.PLUS);
        else if ("-".equals(strOp))
            operators.add(OperatorType.MINUS);
        else if ("*".equals(strOp))
            operators.add(OperatorType.MUL);
        else if ("/".equals(strOp))
            operators.add(OperatorType.DIV);
        else if ("%".equals(strOp))
            operators.add(OperatorType.MOD);
        else if ("^".equals(strOp))
            operators.add(OperatorType.CARET);
        else if ("idiv".equals(strOp))
            operators.add(OperatorType.IDIV);
        else if ("~=".equals(strOp))
            operators.add(OperatorType.FUZZY_EQ);
    }

	/**
	 * @return value expressions getter
	 */
	public ArrayList<AbstractExpression> getAndExpressions() {
		return expressions;
	}

	/**
	 * @param value expressions setter
	 */
	public void setAndExpressions(ArrayList<AbstractExpression> andExpressions) {
		this.expressions = andExpressions;
	}
	
	public String toJSON() throws IOException {
		String it = "[";
		for (int i = 0; i < expressions.size(); i++) {
			AbstractExpression expression = expressions.get(i);
			it += expression.toJSON() + ",";
			if (i < expressions.size() - 1) {
				OperatorType operator = operators.get(i);
				it += operator.toJSON() + ",";
			}
		}
		it = it.substring(0, it.length()-1) + "]";
		return it;
	}
}