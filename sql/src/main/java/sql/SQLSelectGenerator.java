package sql;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.List;

import static com.foodbird.generate.sql.SQLKeyword.*;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLSelectGenerator implements SQLGenerator {

    @Override
    public String generate(SQLMeta meta) {

        Builder builder = new Builder();
        builder.build(meta.getAction());
        builder.build(ASTERISK);
        builder.build(FROM);
        builder.build(new SQLElement(meta.getTableName()));
        builder.build(WHERE);
        builder.build(meta.getCondition());
        builder.build(new SQLOrderBys(meta.getOrderBys()));
        builder.build(new SQLGroupBys(meta.getGroupBys()));

        return builder.toSql();
    }


    private class Builder {

        private StringBuilder builder = new StringBuilder();

        private List<String> exprs = Lists.newArrayList();

        void build(SQLExpression expr) {
            if (expr != null) {
                exprs.add(expr.toExpression());
            }

        }

        void buildln(SQLExpression expr) {
            if (expr != null) {
                exprs.add(expr.toExpression() + "\n");
            }
        }

        String toSql() {
            return Joiner.on(" ").join(exprs);
        }

    }

    @Override
    public SQLAction actType() {
        return SQLAction.SELECT;
    }
}
