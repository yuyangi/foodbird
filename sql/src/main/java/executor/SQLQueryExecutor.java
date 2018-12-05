package executor;

import com.foodbird.generate.sql.SQLBuilder;
import com.foodbird.generate.sql.SQLFilter;
import com.foodbird.generate.sql.SQLMeta;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/31
 */
@Service
@Scope("singleton")
public class SQLQueryExecutor {

    private static Logger LOGGER = LoggerFactory.getLogger(SQLQueryExecutor.class);

    private Map<String, List<String>> tableMetaCache = Maps.newConcurrentMap();

    @Autowired
    private DataSource dataSource;

    public List<?> query(String db, String tableNames, String sql) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Map<String, Object>> result = Lists.newArrayList();
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (resultSet != null) {
                while (resultSet.next()) {
                    Map<String, Object> row = Maps.newHashMap();
                    for (int i = 1; i <= columnCount; i++) {
                        row.put(metaData.getColumnName(i), resultSet.getObject(i));
                    }
                    result.add(row);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Query static info error:" + e.getMessage(), e);
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("Query static info close resource error:" + e.getMessage(), e);
            }
        }
        return result;
    }

    /**
     * 根据库表信息、查询条件加载单表数据
     *
     * @param db
     * @param table
     * @param condition
     * @return
     */
    public List<?> query(String db, String table, Map<String, Object> condition) {
        SQLBuilder builder = new SQLBuilder();
        SQLFilter filter = builder.filter();
        for (String field : condition.keySet()) {
            filter.field(field).equal(condition.get(field));
        }
        // 构建sql结构数据
        SQLMeta sqlMeta = builder.meta().db(db).table(table).action("SELECT").condition(filter);
        // 查询数据
        return query(db, table, sqlMeta.toExpression());
    }

}
