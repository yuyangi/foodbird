package sql;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLGeneratorFactory {


    private static Map<SQLAction, SQLGenerator> generators = Maps.newHashMap();

    static {
        generators.put(SQLAction.DELETE, new SQLDeleteGenerator());
        generators.put(SQLAction.INSERT, new SQLInsertGenerator());
        generators.put(SQLAction.SELECT, new SQLSelectGenerator());
        generators.put(SQLAction.UPDATE, new SQLUpdateGenerator());
    }

    public SQLGenerator createGenerator(SQLAction action) {
        return generators.get(action);
    }

    private SQLGeneratorFactory() {

    }

}
