package freelifer.pig.smarttemplate.inner.node;

/**
 * @author kzhu on 2017/7/27.
 */
public class ValueNode implements Node {

    private final String text;

    public static ValueNode create(String text) {
        return new ValueNode(text);
    }

    private ValueNode(String text) {
        this.text = text;
    }

    @Override
    public boolean exec(StringBuilder stringBuilder) {

        return false;
    }
}
