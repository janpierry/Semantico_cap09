package syntacticTree;

import parser.*;


public class AtribNode extends StatementNode {
    public ExpreNode expr1;
    public GeneralNode expr2;

    public AtribNode(Token t, ExpreNode e1, GeneralNode e2) {
        super(t);
        expr1 = e1;
        expr2 = e2;
    }
}
