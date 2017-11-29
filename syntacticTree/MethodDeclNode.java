package syntacticTree;

import parser.*;


public class MethodDeclNode extends GeneralNode {
    public int dim;
    public Token hasfinal;
    public Token escopo;
    public Token name;
    public MethodBodyNode body;

    public MethodDeclNode(Token a, Token b, Token t, int k, Token t2, MethodBodyNode m) {
        super(t);
        escopo = a;
        hasfinal = b;
        dim = k;
        name = t2;
        body = m;
    }
}
