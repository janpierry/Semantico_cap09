package syntacticTree;

import parser.*;


public class VarDeclNode extends StatementNode {
    public ListNode vars;
    public Token hasfinal;
    public Token tipoClasse;
    public Token escopo;

    public VarDeclNode(Token a, Token b, Token t, ListNode p) {
        super(t);
        escopo = a;
        hasfinal = b;
        vars = p;
    }

}
