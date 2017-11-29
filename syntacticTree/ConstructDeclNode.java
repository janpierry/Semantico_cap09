package syntacticTree;

import parser.*;


public class ConstructDeclNode extends GeneralNode {
    
    public Token escopo;
    public MethodBodyNode body;

    public ConstructDeclNode(Token a, Token t, MethodBodyNode m) {
        super(t);
        escopo = a;
        body = m;
    }
}
