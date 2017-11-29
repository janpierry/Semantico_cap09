package syntacticTree;

import parser.*;


public class PrimitiveTypeNode extends GeneralNode {
	public Token tipo;

    public PrimitiveTypeNode(Token t) {
        super(t);
        tipo = t;
    }
}