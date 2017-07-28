package freelifer.pig.smarttemplate.inner.node;

import org.junit.Test;
import org.junit.rules.TestName;

/**
 * @author kzhu on 2017/7/27.
 */
public class TextNode implements Node {

    private final String text;

    public static TextNode create(String text) {
        return new TextNode(text);
    }

    private TextNode(String text) {
        this.text = text;
    }

    @Override
    public boolean exec(StringBuilder stringBuilder) {
        stringBuilder.append(text);
        return false;
    }
}
