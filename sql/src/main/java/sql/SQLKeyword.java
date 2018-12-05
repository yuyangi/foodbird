package sql;

public enum SQLKeyword implements SQLExpression {
    FROM("FROM"),
    WHERE("WHERE"),
    DISTINCT("DISTINCT"),
    ASTERISK("*");

    private String primitive;

    SQLKeyword(String primitive) {
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
}
