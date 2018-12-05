package com.foodbird.generate.sql;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLOr extends SQLFieldLogicRelation {

    public SQLOr() {
        super(SQLLogicOpr.OR);
    }

    public SQLOr(SQLExpression leftExpression) {
        super(SQLLogicOpr.OR, leftExpression);
    }

    public SQLOr(SQLExpression leftExpression, SQLExpression rightExpression) {
        super(SQLLogicOpr.OR, leftExpression, rightExpression);
    }
}
