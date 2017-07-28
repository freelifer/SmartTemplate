package freelifer.pig.smarttemplate.inner.node;

/**
 * @author kzhu on 2017/7/27.
 */
public class ElseNodeGroup extends NodeGroup {

    private final String expression;

    protected ElseNodeGroup() {
        super();
        this.expression = null;
    }

    protected ElseNodeGroup(String expression) {
        super();
        this.expression = expression;
    }

    public static ElseNodeGroup create(String expression) {
        return new ElseNodeGroup(expression);
    }

    @Override
    public boolean exec(StringBuilder stringBuilder) {

        return false;
    }
}
