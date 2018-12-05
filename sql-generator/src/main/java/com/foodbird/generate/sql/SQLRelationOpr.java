package com.foodbird.generate.sql;

public enum SQLRelationOpr implements SQLOperator {
    EQUALS("="),
    NOT_EQUALS("!="),
    IN("IN"),
    NOTIN("NOT IN"),
    //BETWEEN("BETWEEN"),
    GREATER(">"),
    GREATER_AND_EQUALS(">="),
    LESS("<"),
    LESS_AND_EQUALS("<=");

    private String primitive;

    SQLRelationOpr(String primitive) {
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

    public static SQLRelationOpr get(String oprStr) {
        for (SQLRelationOpr opr : values()) {
            if (opr.primitive.equals(oprStr) || opr.name().equals(oprStr)) {
                return opr;
            }
        }
        return null;
    }

}
