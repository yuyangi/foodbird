package sql;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/30
 */
public class SQLColumn implements SQLExpression {

    private String field;

    private SQLDataType type;

    private String alias;

    public SQLColumn() {
    }

    public SQLColumn(String field) {
        this.field = field;
    }

    public SQLColumn(String field, SQLDataType type) {
        this.field = field;
        this.type = type;
    }

    public SQLColumn(String field, SQLDataType type, String alias) {
        this.field = field;
        this.type = type;
        this.alias = alias;
    }

    @Override
    public String toExpression() {
        return field;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

}
