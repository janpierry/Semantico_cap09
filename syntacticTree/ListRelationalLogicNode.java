package syntacticTree;

import parser.*;


public class ListRelationalLogicNode extends ExpreNode {
    public ExpreNode expr1;
    public ListNode lista;
    public Token possivelNull;

    //Construtor para expressoes logicas tipo: a or b and c xor d...
    public ListRelationalLogicNode(Token a, ExpreNode e1, ListNode l){
    	super(e1.position);
    	possivelNull = a;
    	expr1 = e1;
    	lista = l;
    }

}
