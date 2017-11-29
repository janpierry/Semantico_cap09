package syntacticTree;

import parser.*;


public class ResultMethodCallNode extends ExpreNode {
	public MethodCallNode methodCall;

    public ResultMethodCallNode(MethodCallNode m) {
        super(null);
        methodCall = m;
    }
}