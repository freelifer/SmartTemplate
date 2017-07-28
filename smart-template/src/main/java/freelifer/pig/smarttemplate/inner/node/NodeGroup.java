package freelifer.pig.smarttemplate.inner.node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kzhu on 2017/7/27.
 */
public class NodeGroup implements Node {

    protected final List<Node> nodes;

    protected NodeGroup() {
        nodes = new ArrayList<>();
    }

    public void addChild(Node node) {
        nodes.add(node);
    }

    @Override
    public boolean exec(StringBuilder stringBuilder) {
        for (Node node: nodes) {
            node.exec(stringBuilder);
        }
        return true;
    }
}
