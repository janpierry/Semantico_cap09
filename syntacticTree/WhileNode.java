package syntacticTree;

import parser.*;


public class WhileNode extends StatementNode {
    public ExpreNode expressao;
    public StatementNode statement;    

    public WhileNode(Token a, ExpreNode e, StatementNode s) {
        super(a);
        expressao = e;
        statement = s;
    }

}
