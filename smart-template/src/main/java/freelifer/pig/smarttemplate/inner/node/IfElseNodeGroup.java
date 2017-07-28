package freelifer.pig.smarttemplate.inner.node;

import java.util.ArrayList;
import java.util.List;

import freelifer.pig.smarttemplate.inner.exception.NodeGroupException;

/**
 * @author kzhu on 2017/7/27.
 */
public class IfElseNodeGroup extends NodeGroup {

    protected IfElseNodeGroup() {
        super();
    }

    public static IfElseNodeGroup create() {
        return new IfElseNodeGroup();
    }

    @Override
    public void addChild(Node node) {
        if (node instanceof IfNodeGroup || node instanceof ElseNodeGroup) {
            super.addChild(node);
        } else {
            throw new NodeGroupException("IfElseNodeGroup must add child node IfNodeGroup and ElseNodeGroup");
        }
    }

    @Override
    public boolean exec(StringBuilder stringBuilder) {

        return false;
    }
}
