package sql;

public interface SQLExpression {

    String toExpression();

    boolean hasChildren();

    String toString();

}
