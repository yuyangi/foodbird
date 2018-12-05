package com.foodbird.generate.sql;

import com.google.common.base.Joiner;
import org.apache.commons.collections.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * TODO 参数预处理操作
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLFilter implements Serializable, SQLExpression {

    private static final long serialVersionUID = 2075806571421790504L;

    private String field;

    private SQLRelationOpr relationOpr;

    private Object value;

    private boolean isPretreatment;

    public SQLFilter() {
        super();
    }

    public SQLFilter(String field) {
        this.field = field;
    }

    public SQLFilter(String field, SQLRelationOpr relationOpr, Object value) {
        this.field = field;
        this.relationOpr = relationOpr;
        this.value = value;
    }

    public SQLFilter field(String field) {
        this.field = field;
        return this;
    }

    public SQLFilter opr(String opr) {
        this.relationOpr = SQLRelationOpr.get(opr);
        if (this.relationOpr == null) {
            this.relationOpr = SQLRelationOpr.EQUALS;
        }
        return this;
    }

    public SQLFilter value(Object value) {
        this.value = value;
        return this;
    }

    public SQLFilter equal(Object value) {
        if (value instanceof List || Collection.class.isAssignableFrom(value.getClass())) {
            return in((List) value);
        } else {
            this.relationOpr = SQLRelationOpr.EQUALS;
            this.value = value;
            return this;
        }
    }

    public SQLFilter greater(String value) {
        this.relationOpr = SQLRelationOpr.GREATER;
        this.value = value;
        return this;
    }

    public SQLFilter greaterEquals(String value) {
        this.relationOpr = SQLRelationOpr.GREATER_AND_EQUALS;
        this.value = value;
        return this;
    }

    public SQLFilter less(String value) {
        this.relationOpr = SQLRelationOpr.LESS;
        this.value = value;
        return this;
    }

    public SQLFilter lessEquals(String value) {
        this.relationOpr = SQLRelationOpr.LESS_AND_EQUALS;
        this.value = value;
        return this;
    }

    public SQLFilter in(List<String> values) {
        if (CollectionUtils.isNotEmpty(values)) {
            this.relationOpr = SQLRelationOpr.IN;
            this.value = values;
        }
        return this;
    }

    public SQLFilter notIn(List<String> values) {
        this.relationOpr = SQLRelationOpr.NOTIN;
        this.value = values;
        return this;
    }

    public SQLFieldLogicRelation and(SQLExpression and) {
        SQLAnd rel = new SQLAnd(this, and);
        return rel;
    }

    public SQLFieldLogicRelation and(String field) {
        SQLAnd rel = new SQLAnd(this);
        rel.and(field);
        return rel;
    }

    public SQLFieldLogicRelation or(SQLExpression or) {
        SQLOr rel = new SQLOr(this, or);
        return rel;
    }

    public SQLFieldLogicRelation or(String field) {
        SQLOr rel = new SQLOr(this);
        rel.and(field);
        return rel;
    }

    @Override
    public String toExpression() {
        if (value == null) {
            return null;
        }
        return Joiner.on(" ").join(field, relationOpr.toExpression(), valueString(value));
    }

    private String valueString(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof List || value.getClass().isAssignableFrom(List.class)) {
            return "(" + Joiner.on(",").join((List)value) + ")";
        }
        return value.toString();
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public String toString() {
        return toExpression();
    }

}
