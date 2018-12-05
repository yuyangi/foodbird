package sql;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public interface SQLGenerator {

    String generate(SQLMeta meta);

    SQLAction actType();

}
