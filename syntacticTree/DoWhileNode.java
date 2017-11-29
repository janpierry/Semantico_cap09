package syntacticTree;

import parser.*;


public class DoWhileNode extends StatementNode {
    public StatementNode statement;
    public ExpreNode expressao;

    public DoWhileNode(Token a, StatementNode s, ExpreNode e) {
        super(a);
        statement = s;
        expressao = e;
    }

}
