package sql;

public enum SQLOrder implements SQLExpression {
    ASC("ASC"),
    DESC("DESC"),
    NONE("");

    private String primitive;

    SQLOrder(String primitive) {
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
