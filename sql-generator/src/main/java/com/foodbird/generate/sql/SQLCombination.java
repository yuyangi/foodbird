package com.foodbird.generate.sql;

import java.io.Serializable;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLCombination implements Serializable, SQLExpression {

    private static final long serialVersionUID = 3255458866950022597L;

    private SQLFieldLogicRelation expressions;

    @Override
    public String toExpression() {
        StringBuilder builder = new StringBuilder("(");
        builder.append(expressions.toExpression());
        builder.append(")");
        return builder.toString();
    }

    public void and(SQLExpression expression) {
        if (expressions == null) {
            expressions = new SQLFieldLogicRelation(expression);
        } else {
            expressions.and(expression);
        }
    }

    @Override
    public boolean hasChildren() {
        return true;
    }

    @Override
    public String toString() {
        return toExpression();
    }

}
