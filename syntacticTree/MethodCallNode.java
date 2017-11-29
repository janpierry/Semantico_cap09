package syntacticTree;

import parser.*;


public class MethodCallNode extends StatementNode {
	public ExpreNode caminho; //ident.indent.indent...
	public ListNode parametros;

    public MethodCallNode(ExpreNode e, ListNode p) {
        super(e.position);
        caminho = e;
        parametros = p;
    }
}