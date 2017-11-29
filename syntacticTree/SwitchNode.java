package syntacticTree;

import parser.*;


public class SwitchNode extends StatementNode {
    public Token variavel;
    public Token lbrace;
    public ListNode lista;

    public SwitchNode(Token a, Token b, Token c, ListNode l) {
        super(a);
        variavel = b;
        lbrace = c;
        lista = l;
    }

}
