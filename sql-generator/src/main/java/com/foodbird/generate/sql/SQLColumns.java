package com.foodbird.generate.sql;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/30
 */
public class SQLColumns implements SQLExpression {

    private List<SQLColumn> columns;

    private List<String> expressions;

    public SQLColumns(List<SQLColumn> columns) {
        this.columns = columns;
        this.expressions = Lists.newArrayList();
    }

    @Override
    public String toExpression() {
        if (columns != null) {
            if (expressions == null) {
                this.toExpressions();
            }
            return Joiner.on(",").join(expressions);
        }
        return "*";
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    private void toExpressions() {
        if (columns != null) {
            if (expressions == null) {
                expressions = Lists.newArrayList();
            }
            for (SQLColumn col : columns) {
                expressions.add(col.toExpression());
            }
        }
    }
}
