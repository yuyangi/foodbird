package sql;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLOrderBy implements SQLExpression {

    private String field;

    private SQLOrder order;

    public SQLOrderBy() {
    }

    public SQLOrderBy(String field, SQLOrder order) {
        this.field = field;
        this.order = order;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public SQLOrder getOrder() {
        return order;
    }

    public void setOrder(SQLOrder order) {
        this.order = order;
    }

    @Override
    public String toExpression() {
        return "ORDER BY " + field + " " + order.toExpression();
    }

    @Override
    public boolean hasChildren() {
        return false;
    }
}
