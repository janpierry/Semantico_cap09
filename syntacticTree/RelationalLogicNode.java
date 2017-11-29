package syntacticTree;

import parser.*;


public class RelationalLogicNode extends ExpreNode {
    public ExpreNode expr1;
    public Token possivelNull;

    //Construtor para representar algo tipo: xor b. Serve para ser colocado no ListNode no construtor de cima
    public RelationalLogicNode(Token b, Token c, ExpreNode e1){
    	super(b);
    	possivelNull = c;
    	expr1 = e1;
    }
}
