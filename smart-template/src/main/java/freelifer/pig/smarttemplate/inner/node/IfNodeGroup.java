package freelifer.pig.smarttemplate.inner.node;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @author kzhu on 2017/7/27.
 */
public class IfNodeGroup extends NodeGroup {

    private final String expression;

    protected IfNodeGroup() {
        super();
        this.expression = null;
    }

    protected IfNodeGroup(String expression) {
        super();
        this.expression = expression;
    }

    public static IfNodeGroup create(String expression) {
        return new IfNodeGroup(expression);
    }

    @Override
    public boolean exec(StringBuilder stringBuilder) {

        return false;
    }
}
