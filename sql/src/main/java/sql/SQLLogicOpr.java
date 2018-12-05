package sql;

public enum SQLLogicOpr implements SQLOperator {

    AND("AND"),
    OR("OR");

    private String primitive;

    SQLLogicOpr(String primitive) {
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

    public SQLLogicOpr get(String oprStr) {
        for (SQLLogicOpr opr : values()) {
            if (opr.primitive.equals(oprStr) || opr.name().equals(oprStr)) {
                return opr;
            }
        }
        return null;
    }

}
