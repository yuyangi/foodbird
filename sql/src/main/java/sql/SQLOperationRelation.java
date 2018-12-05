package sql;

import com.google.common.base.Joiner;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLOperationRelation implements SQLExpression {

    private SQLOperator operator;

    private SQLExpression leftExpression;
    private SQLExpression rightExpression;

    public SQLOperationRelation() {
    }

    public SQLOperationRelation(SQLOperator operator) {
        this.operator = operator;
    }

    public SQLOperationRelation(SQLOperator operator, SQLExpression leftExpression) {
        this.operator = operator;
        this.leftExpression = leftExpression;
    }

    public SQLOperationRelation(SQLOperator operator, SQLExpression leftExpression, SQLExpression rightExpression) {
        this.operator = operator;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public String toExpression() {
        return Joiner.on(" ").join(leftExpression.toExpression(), operator.toExpression(), rightExpression.toExpression());
    }

    @Override
    public boolean hasChildren() {
        return false;
    }
}
