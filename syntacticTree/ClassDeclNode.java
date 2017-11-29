package syntacticTree;

import parser.*;


public class ClassDeclNode extends GeneralNode {
	public Token escopo;
    public Token name;
    public Token supername;
    public ClassBodyNode body;

    public ClassDeclNode(Token t1, Token t2, Token t3, Token t4, ClassBodyNode c) {
        super(t2); // passa token de referencia para construtor da superclasse
        escopo = t1;
        name = t3;
        supername = t4;
        body = c;
    }
}
