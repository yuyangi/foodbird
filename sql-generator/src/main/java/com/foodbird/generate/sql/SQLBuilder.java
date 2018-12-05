package com.foodbird.generate.sql;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLBuilder {

    private SQLExpression root;

    public SQLExpression createFilter(String field) {
        return new SQLFilter(field);
    }

    public SQLFilter filter() {
        return  new SQLFilter();
    }

    public SQLMeta meta() {
        return new SQLMeta();
    }

}
