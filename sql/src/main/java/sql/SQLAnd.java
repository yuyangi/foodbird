package sql;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLAnd extends SQLFieldLogicRelation {

    public SQLAnd() {
        super(SQLLogicOpr.AND);
    }

    public SQLAnd(SQLExpression leftExpression) {
        super(SQLLogicOpr.AND, leftExpression);
    }

    public SQLAnd(SQLExpression leftExpression, SQLExpression rightExpression) {
        super(SQLLogicOpr.AND, leftExpression, rightExpression);
    }
}
