package freelifer.pig.smarttemplate.inner.lexer;

import com.sun.istack.internal.NotNull;

import freelifer.pig.smarttemplate.inner.exception.LexerException;
import freelifer.pig.smarttemplate.inner.log.Logger;
import freelifer.pig.smarttemplate.inner.node.New;
import freelifer.pig.smarttemplate.inner.node.NodeGroup;
import freelifer.pig.smarttemplate.inner.util.TextUtils;

/**
 * {{.Admpub}}
 *
 * {{if pipeline}} T1 {{end}}
 * {{if pipeline}} T1 {{else}} T0 {{end}}
 * {{if pipeline}} T1 {{else if pipeline}} T0 {{end}}
 *
 * {{range $k, $v := .Var}} {{$k}} => {{$v}} {{end}}
 * {{range .Var}} {{.}} {{end}}
 * {{range pipeline}} T1 {{else}} T0 {{end}}
 *
 * @author kzhu on 2017/7/25.
 */
public class Lexer {
    static Logger log = Logger.getLogger(true, Lexer.class);

    private final String leftDelim;
    private final String rightDelim;
    private final int leftDelimLen;
    private final int rightDelimLen;

    int start;
    int end;
    int last;

    private NodeGroup nodeGroup;

    private Lexer(Lexer.Builder builder) {
        this.leftDelim = builder.leftDelim;
        this.rightDelim = builder.rightDelim;
        this.leftDelimLen = builder.leftDelim.length();
        this.rightDelimLen = builder.rightDelim.length();
    }

    public void parse(String src) {
        if (TextUtils.isEmpty(src)) {
            throw new LexerException("Lexer parse() Parameters is empty!");
        }

        int len = src.length();

        while(lexLeftDelim(src)) {
        }
        if (start < len) {
            String result = src.substring(start, len);
            wrapText(result);
        }

        StringBuilder sb = new StringBuilder();
        nodeGroup.exec(sb);
        System.out.println(sb.toString());
    }

    private boolean lexLeftDelim(String src) {
        int leftIndex = src.indexOf(leftDelim, start);
        if (leftIndex == 0) {
            // 连续 left delim
            start = leftIndex + leftDelimLen;
            return lexRightDelim(src);
        } else if (leftIndex > 0) {
            // 中间有string字符串
            String result = src.substring(start, leftIndex);
            wrapText(result);

            start = leftIndex + leftDelimLen;
            return lexRightDelim(src);
        } else {
            // 结束
            return false;
        }
    }

    private boolean lexRightDelim(String src) {
        int rightIndex = src.indexOf(rightDelim, start);
        if (rightIndex == 0) {
            // 连续 right delim
            log.i("lexRightDelim == 0");

            return true;
        } else if (rightIndex > 0) {
            // 中间有string字符串
            String result = src.substring(start, rightIndex);
            wrapOpText(result);

            log.i("lexRightDelim > 0 result: %s .", result);
            start = rightIndex + rightDelimLen;
            return true;
        } else {
            // 出错 只有左边界 没有右边界
            return false;
        }
    }

    private void defaultNodeGroup() {
        if (nodeGroup == null) {
            nodeGroup = New.NodeGroup();
        }
    }
    private void wrapText(String text) {
        defaultNodeGroup();

        nodeGroup.addChild(New.TextNode(text));
    }

    private void wrapOpText(String text) {
        defaultNodeGroup();

        if (TextUtils.isEmpty(text)) {
            return;
        }

        String trimText = text.trim();
        boolean isValue = trimText.startsWith(".");
        if (isValue) {
            nodeGroup.addChild(New.ValueNode(text));
        } else {
            nodeGroup.addChild(New.TextNode(text));
        }
    }

    private void op(@NotNull String trimText) {
        String[] split = trimText.split(" ");

        if (trimText.startsWith("if")) {

        } else if(trimText.startsWith("else")) {

        } else if(trimText.startsWith("elseif")) {

        } else if(trimText.startsWith("range")) {

        } else if (trimText.startsWith("end")){

        }
    }

    public static class Builder {
        private static final String LEFT_DELIM = "{{";
        private static final String RIGHT_DELIM = "}}";

        private String leftDelim;
        private String rightDelim;

        public Builder() {
            this.leftDelim = LEFT_DELIM;
            this.rightDelim = RIGHT_DELIM;
        }

        public Lexer build() {
            return new Lexer(this);
        }
    }

}
