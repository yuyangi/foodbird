package com.foodbird.generate.sql;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLElement implements SQLExpression {

    private String primitive;

    public SQLElement(String primitive) {
        this.primitive = primitive;
    }

    @Override
    public String toExpression() {
        return primitive;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }
}
