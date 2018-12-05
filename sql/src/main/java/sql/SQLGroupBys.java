package sql;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLGroupBys implements SQLExpression {

    private List<SQLGroupBy> groupBys;

    public SQLGroupBys() {
    }

    public SQLGroupBys(String... groupBys) {
        if (groupBys != null) {
            if (this.groupBys == null) {
                this.groupBys = Lists.newArrayList();
            }
            for (String field : groupBys) {
                this.groupBys.add(new SQLGroupBy(field));
            }
        }
    }

    public SQLGroupBys(List<SQLGroupBy> groupBys) {
        this.groupBys = groupBys;
    }

    @Override
    public String toExpression() {
        List<String> fields = Lists.newArrayList();
        for (SQLGroupBy groupBy : groupBys) {
            fields.add(groupBy.getField());
        }
        String grouByFlds = Joiner.on(",").join(fields);
        return "GROUP BY " + grouByFlds;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

}
