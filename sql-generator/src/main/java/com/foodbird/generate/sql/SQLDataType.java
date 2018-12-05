package com.foodbird.generate.sql;

/**
 * @author yuyang48
 * @prject waimai_m_crm_changjiang
 * @date 2018/7/30
 */
public enum SQLDataType implements SQLExpression {

    // 数字类型
    TINYINT,
    SMALLINT,
    MEDIUMINT,
    INT,
    INTEGER,
    BIGINT,
    FLOAT,
    DOUBLE,
    DECIMAL,

    // 字符类型
    CHAR,
    VARCHAR,
    TINYBLOB,
    TINYTEXT,
    BLOB,
    TEXT,
    MEDIUMBLOB,
    MEDIUMTEXT,
    LOGNGBLOB,
    LONGTEXT,

    // 时间类型
    DATE,
    TIME,
    YEAR,
    DATETIME,
    TIMESTAMP
    ;

    @Override
    public String toExpression() {
        return name();
    }

    @Override
    public boolean hasChildren() {
        return false;
    }
}
