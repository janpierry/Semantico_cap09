package syntacticTree;

import parser.*;


public class SwitchCaseNode extends StatementNode {
    public Token doisp;
    public ExpreNode factor;
    public StatementNode statement;

    public SwitchCaseNode(Token a, ExpreNode e, Token b, StatementNode s) {
        super(a);
        factor = e;
        doisp = b;
    	statement = s;
    }

}
