package sql;


/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLGroupBy implements SQLExpression {

    private String field;

    public SQLGroupBy() {
    }

    public SQLGroupBy(String field) {
        this.field = field;
    }

    @Override
    public String toExpression() {
        return "GROUP BY " + field;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
