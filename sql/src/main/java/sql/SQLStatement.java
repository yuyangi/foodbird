package sql;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/30
 */
public class SQLStatement implements SQLExpression {

    private List<SQLExpression> expressions;

    private String delimiter = " ";

    public SQLStatement(List<SQLExpression> expressions) {
        this.expressions = expressions;
    }

    public SQLStatement(List<SQLExpression> expressions, String delimiter) {
        this.expressions = expressions;
        this.delimiter = delimiter;
    }

    @Override
    public String toExpression() {
        if (expressions != null) {
            List<String> statement = Lists.newArrayList();
            for (SQLExpression expr : expressions) {
                statement.add(expr.toExpression());
            }
            return Joiner.on(delimiter).join(statement);
        }
        return null;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }
}
