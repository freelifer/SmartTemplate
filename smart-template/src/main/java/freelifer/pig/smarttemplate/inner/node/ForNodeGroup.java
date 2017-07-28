package freelifer.pig.smarttemplate.inner.node;

/**
 * @author kzhu on 2017/7/27.
 */
public class ForNodeGroup extends NodeGroup {

    private final String expression;

    protected ForNodeGroup() {
        super();
        this.expression = null;
    }

    protected ForNodeGroup(String expression) {
        super();
        this.expression = expression;
    }

    public static ForNodeGroup create(String expression) {
        return new ForNodeGroup(expression);
    }

    @Override
    public boolean exec(StringBuilder stringBuilder) {

        return false;
    }
}
