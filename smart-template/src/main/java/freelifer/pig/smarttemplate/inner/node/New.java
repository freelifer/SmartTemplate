package freelifer.pig.smarttemplate.inner.node;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author kzhu on 2017/7/27.
 */
public class New {

    public static TextNode TextNode(String text) {
        return TextNode.create(text);
    }

    public static ValueNode ValueNode(String text) {
        return ValueNode.create(text);
    }

    public static NodeGroup NodeGroup() {
        return new NodeGroup();
    }

    public static IfNodeGroup IfNodeGroup(String expression) {
        return IfNodeGroup.create(expression);
    }

    public static ElseNodeGroup ElseNodeGroup(String expression) {
        return ElseNodeGroup.create(expression);
    }

    public static ForNodeGroup ForNodeGroup(String expression) {
        return ForNodeGroup.create(expression);
    }

    public static IfElseNodeGroup IfElseNodeGroup() {
        return IfElseNodeGroup.create();
    }
}
