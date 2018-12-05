package com.foodbird.generate.sql;

public enum SQLAction implements SQLExpression {

    INSERT("INSERT"),
    UPDATE("UPDATE"),
    DELETE("DELETE"),
    SELECT("SELECT");

    private String primitive;

    SQLAction(String primitive) {
        this.primitive = primitive;
    }

    @Override
    public String toExpression() {
        return primitive;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public String toString() {
        return primitive;
    }

    public SQLAction get(String oprStr) {
        for (SQLAction opr : values()) {
            if (opr.primitive.equals(oprStr)) {
                return opr;
            }
        }
        return null;
    }

}
