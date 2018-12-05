package sql;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLInsertGenerator implements SQLGenerator {
    @Override
    public String generate(SQLMeta meta) {
        return null;
    }

    @Override
    public SQLAction actType() {
        return SQLAction.INSERT;
    }
}
