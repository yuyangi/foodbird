package com.foodbird.generate.sql;

import com.google.common.base.Joiner;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLFieldLogicRelation implements Serializable, SQLExpression {

    private static final long serialVersionUID = -341458334820994106L;

    private SQLLogicOpr opr;

    private SQLExpression leftExpression;
    private SQLExpression rightExpression;

    private SQLFilter tempFilter = null;

    public SQLFieldLogicRelation(SQLExpression leftExpression) {
        this.leftExpression = leftExpression;
    }

    public SQLFieldLogicRelation(SQLLogicOpr opr, SQLExpression leftExpression) {
        this.opr = opr;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public SQLFieldLogicRelation(SQLLogicOpr opr, SQLExpression leftExpression, SQLExpression rightExpression) {
        this.opr = opr;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public SQLFieldLogicRelation(SQLLogicOpr opr) {
        this.opr = opr;
    }

    @Override
    public String toExpression() {
        if (leftExpression == null && rightExpression == null) {
            return "";
        }
        if (rightExpression == null) {
            return rightExpression.toExpression();
        }

        return Joiner.on(" " + opr.toExpression() + " ").join(leftExpression, rightExpression);
    }

    public SQLFieldLogicRelation and(SQLExpression expression) {
        if (leftExpression == null) {
            leftExpression = expression;
        } else if (rightExpression == null) {
            rightExpression = expression;
        } else {
            leftExpression = new SQLFieldLogicRelation(this.opr, leftExpression, rightExpression);
            rightExpression = expression;
        }
        this.opr = SQLLogicOpr.AND;
        return this;
    }

    public SQLFieldLogicRelation or(SQLExpression expression) {
        if (leftExpression == null) {
            leftExpression = expression;
        } else if (rightExpression == null) {
            rightExpression = expression;
        } else {
            leftExpression = new SQLFieldLogicRelation(this.opr, leftExpression, rightExpression);
            rightExpression = expression;
        }
        this.opr = SQLLogicOpr.OR;
        return this;
    }

    public SQLFieldLogicRelation and(String field) {
        tempFilter = new SQLFilter(field);
        and(tempFilter);
        return this;
    }

    public SQLFieldLogicRelation equal(Object value) {
        getTempFilter().equal(value);
        return this;
    }

    public SQLFieldLogicRelation greater(String value) {
        getTempFilter().greater(value);
        return this;
    }

    public SQLFieldLogicRelation greaterEquals(String value) {
        getTempFilter().greaterEquals(value);
        return this;
    }

    public SQLFieldLogicRelation less(String value) {
        getTempFilter().less(value);
        return this;
    }

    public SQLFieldLogicRelation lessEquals(String value) {
        getTempFilter().lessEquals(value);
        return this;
    }

    public SQLFieldLogicRelation in(List<String> values) {
        getTempFilter().in(values);
        return this;
    }

    public SQLFieldLogicRelation notIn(List<String> values) {
        getTempFilter().notIn(values);
        return this;
    }

    public SQLFilter getTempFilter() {
        return tempFilter;
    }

    protected void setTempFilter(SQLFilter tempFilter) {
        this.tempFilter = tempFilter;
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
