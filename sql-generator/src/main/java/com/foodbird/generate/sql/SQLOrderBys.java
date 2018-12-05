package com.foodbird.generate.sql;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLOrderBys implements SQLExpression {

    private List<SQLOrderBy> orderBys;

    public SQLOrderBys(List<SQLOrderBy> orderBys) {
        this.orderBys = orderBys;
    }

    @Override
    public String toExpression() {
        List<String> fields = Lists.newArrayList();
        for (SQLOrderBy orderBy : orderBys) {
            fields.add(orderBy.getField() + " " + orderBy.getOrder().toExpression());
        }
        String orderByFlds = Joiner.on(",").join(fields);
        return "ORDER BY " + orderByFlds;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }
}
