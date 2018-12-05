package com.foodbird.generate.sql;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/25
 */
public class SQLMeta implements Serializable, SQLExpression {

    private static final long serialVersionUID = -6425908701042494010L;

    private String dbName;
    private SQLAction action;
    private String tableName;
    private List<SQLColumn> columns;
    private SQLExpression condition;
    private List<SQLGroupBy> groupBys;
    private List<SQLOrderBy> orderBys;
    private boolean withDbPrefix = false;

    @Override
    public String toExpression() {
        StringBuilder builder = new StringBuilder();
        String table = tableName;
        if (withDbPrefix) {
            table = dbName + "." + tableName;
        }
        List<SQLExpression> expressions = Lists.newArrayList();
        expressions.add(action);
        expressions.add(new SQLColumns(columns));
        expressions.add(SQLKeyword.FROM);
        expressions.add(new SQLElement(table));
        expressions.add(SQLKeyword.WHERE);
        expressions.add(condition);
        if (groupBys != null) {
            expressions.add(new SQLGroupBys(groupBys));
        }
        if (orderBys != null) {
            expressions.add(new SQLOrderBys(orderBys));
        }
        return new SQLStatement(expressions).toExpression();
    }

    @Override
    public boolean hasChildren() {
        return true;
    }

    @Override
    public String toString() {
        return toExpression();
    }

    public SQLMeta db(String dbName) {
        this.dbName = dbName;
        return this;
    }

    public SQLMeta table(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public SQLMeta select(String... columns) {
        if (this.columns == null) {
            this.columns = Lists.newArrayList();
        }
        for (String column : columns) {
            this.columns.add(new SQLColumn(column));
        }
        return this;
    }

    public SQLMeta action(String action) {
        if (action != null) {
            this.action = SQLAction.valueOf(action.toUpperCase());
            if (this.action == null) {
                this.action = SQLAction.SELECT;
            }
        }
        return this;
    }

    public SQLMeta condition(SQLExpression condition) {
        this.condition = condition;
        return this;
    }

    public SQLMeta groupBy(String field) {
        SQLGroupBy groupBy = new SQLGroupBy(field);
        if (groupBys == null) {
            groupBys = Lists.newArrayList();
        }
        groupBys.add(groupBy);
        return this;
    }

    public SQLMeta orderByDesc(String field) {
        SQLOrderBy orderBy = new SQLOrderBy(field, SQLOrder.DESC);
        if (orderBys == null) {
            orderBys = Lists.newArrayList();
        }
        orderBys.add(orderBy);
        return this;
    }

    public SQLMeta orderByAsc(String field) {
        SQLOrderBy orderBy = new SQLOrderBy(field, SQLOrder.ASC);
        if (orderBys == null) {
            orderBys = Lists.newArrayList();
        }
        orderBys.add(orderBy);
        return this;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public SQLAction getAction() {
        return action;
    }

    public void setAction(SQLAction action) {
        this.action = action;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<SQLColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<SQLColumn> columns) {
        this.columns = columns;
    }

    public SQLExpression getCondition() {
        return condition;
    }

    public void setCondition(SQLExpression condition) {
        this.condition = condition;
    }

    public List<SQLGroupBy> getGroupBys() {
        return groupBys;
    }

    public void setGroupBys(List<SQLGroupBy> groupBys) {
        this.groupBys = groupBys;
    }

    public List<SQLOrderBy> getOrderBys() {
        return orderBys;
    }

    public void setOrderBys(List<SQLOrderBy> orderBys) {
        this.orderBys = orderBys;
    }

    public boolean isWithDbPrefix() {
        return withDbPrefix;
    }

    public void setWithDbPrefix(boolean withDbPrefix) {
        this.withDbPrefix = withDbPrefix;
    }
}
