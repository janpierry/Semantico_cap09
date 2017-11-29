package syntacticTree;

import parser.*;


public class PrintTree {
    int kk;

    public PrintTree() {
        kk = 1; // inicializa contador de nos
    }

    public void printRoot(ListNode x) {
        if (x == null) {
            System.out.println("Empty syntatic tree. Nothing to be printed");
        } else {
            numberClassDeclListNode(x);
            printClassDeclListNode(x);
        }

        System.out.println();
    }

    // ------------- lista de classes --------------------------
    public void numberClassDeclListNode(ListNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberClassDeclNode((ClassDeclNode) x.node);
        numberClassDeclListNode(x.next);
    }

    public void printClassDeclListNode(ListNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": ListNode (ClassDeclNode)  ===> " +
            x.node.number + " " +
            ((x.next == null) ? "null" : String.valueOf(x.next.number)));

        printClassDeclNode((ClassDeclNode) x.node);
        printClassDeclListNode(x.next);
    }

    // ------------- declaracao de classe -------------------------
    public void numberClassDeclNode(ClassDeclNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberClassBodyNode(x.body);
    }

    public void printClassDeclNode(ClassDeclNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        /*
        System.out.print(x.number + ": ClassDeclNode ===> " + x.name.image +
            " " + ((x.supername == null) ? "null" : x.supername.image) + " " +
            ((x.body == null) ? "null" : String.valueOf(x.body.number)));

		*/
		System.out.print(x.number + ": ClassDeclNode ===> " + ((x.escopo == null) ? "null" : x.escopo.image) + " "
			+ x.position.image + " " + x.name.image +
            " " + ((x.supername == null) ? "null" : x.supername.image) + " " +
            ((x.body == null) ? "null" : String.valueOf(x.body.number)));

        printClassBodyNode(x.body);
    }

    //------------------------- Corpo da classe -------------------
    public void numberClassBodyNode(ClassBodyNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberClassDeclListNode(x.clist);
        numberVarDeclListNode(x.vlist);
        numberAtribListNode(x.aslist);
        numberConstructDeclListNode(x.ctlist);
        numberMethodDeclListNode(x.mlist);
    }

    public void printClassBodyNode(ClassBodyNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        /*
        System.out.print(x.number + ": ClassBodyNode ===> " +
            ((x.clist == null) ? "null" : String.valueOf(x.clist.number)) +
            " " + ((x.vlist == null) ? "null" : String.valueOf(x.vlist.number)) +
            " " +
            ((x.ctlist == null) ? "null" : String.valueOf(x.ctlist.number)) +
            " " + ((x.mlist == null) ? "null" : String.valueOf(x.mlist.number)));
		*/
		System.out.print(x.number + ": ClassBodyNode ===> " +
            ((x.clist == null) ? "null" : String.valueOf(x.clist.number)) +
            " " + ((x.vlist == null) ? "null" : String.valueOf(x.vlist.number)) +
            " " + ((x.aslist == null) ? "null" : String.valueOf(x.aslist.number)) +
            " " + ((x.ctlist == null) ? "null" : String.valueOf(x.ctlist.number)) +
            " " + ((x.mlist == null) ? "null" : String.valueOf(x.mlist.number)));

        printClassDeclListNode(x.clist);
        printVarDeclListNode(x.vlist);
        printAtribListNode(x.aslist);
        printConstructDeclListNode(x.ctlist);
        printMethodDeclListNode(x.mlist);
    }

    // ---------------- Lista de declaracoes de variaveis ---------------- 
    public void numberVarDeclListNode(ListNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberVarDeclNode((VarDeclNode) x.node);
        numberVarDeclListNode(x.next);
    }

    public void printVarDeclListNode(ListNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": ListNode (VarDeclNode) ===> " +
            x.node.number + " " +
            ((x.next == null) ? "null" : String.valueOf(x.next.number)));

        printVarDeclNode((VarDeclNode) x.node);
        printVarDeclListNode(x.next);
    }

    // -------------------- Declaracao de variavel --------------------
    public void numberVarDeclNode(VarDeclNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numbervarListNode(x.vars);
    }

    public void printVarDeclNode(VarDeclNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        /*
        System.out.print(x.number + ": VarDeclNode ===> " + x.position.image +
            " " + x.vars.number);
        */

		System.out.print(x.number + ": VarDeclNode ===> " + ((x.escopo == null) ? "null" : x.escopo.image)
        	+ " " + ((x.hasfinal == null) ? "null" : x.hasfinal.image) + " " + x.position.image +
            " " + x.vars.number);

        printvarListNode(x.vars);
    }

    // ------------------- Lista de variaveis --------------------
    public void numbervarListNode(ListNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberVarNode((VarNode) x.node);
        numbervarListNode(x.next);
    }

    public void printvarListNode(ListNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": ListNode (VarNode) ===> " +
            x.node.number + " " +
            ((x.next == null) ? "null" : String.valueOf(x.next.number)));

        printVarNode((VarNode) x.node);
        printvarListNode(x.next);
    }

    // ---------------- Lista de atribuicoes de valores a variaveis ---------------- 
    public void numberAtribListNode(ListNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberAtribNode((AtribNode) x.node);
        numberAtribListNode(x.next);
    }

    public void printAtribListNode(ListNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": ListNode (AtribNode) ===> " +
            x.node.number + " " +
            ((x.next == null) ? "null" : String.valueOf(x.next.number)));

        printAtribNode((AtribNode) x.node);
        printAtribListNode(x.next);
    }

    // -------------- Lista de construtores ---------------------
    public void numberConstructDeclListNode(ListNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberConstructDeclNode((ConstructDeclNode) x.node);
        numberConstructDeclListNode(x.next);
    }

    public void printConstructDeclListNode(ListNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": ListNode (ConstructDeclNode) ===> " +
            x.node.number + " " +
            ((x.next == null) ? "null" : String.valueOf(x.next.number)));

        printConstructDeclNode((ConstructDeclNode) x.node);
        printConstructDeclListNode(x.next);
    }

    // ------------------ Declaracao de construtor -----------------
    public void numberConstructDeclNode(ConstructDeclNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberMethodBodyNode(x.body);
    }

    public void printConstructDeclNode(ConstructDeclNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        /*
        System.out.print(x.number + ": ConstructDeclNode ===> " +
            x.body.number);
            */
		
		System.out.print(x.number + ": ConstructDeclNode ===> " + ((x.escopo == null) ? "null" : x.escopo.image) +
             " " + x.position.image + " " + x.body.number);

        printMethodBodyNode(x.body);
    }

    // -------------------------- Lista de metodos -----------------
    public void numberMethodDeclListNode(ListNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberMethodDeclNode((MethodDeclNode) x.node);
        numberMethodDeclListNode(x.next);
    }

    public void printMethodDeclListNode(ListNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": ListNode (MethodDeclNode) ===> " +
            x.node.number + " " +
            ((x.next == null) ? "null" : String.valueOf(x.next.number)));
        printMethodDeclNode((MethodDeclNode) x.node);
        printMethodDeclListNode(x.next);
    }

    // --------------------- Declaracao de metodo ---------------
    public void numberMethodDeclNode(MethodDeclNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberMethodBodyNode(x.body);
    }

    public void printMethodDeclNode(MethodDeclNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": MethodDeclNode ===> " + ((x.escopo == null) ? "null" : x.escopo.image ) + " " +
            ((x.hasfinal == null) ? "null" : x.hasfinal.image) + " " + x.position.image + " " + ((x.dim == 0) ? "" : ("[" + x.dim + "] ")) +
            x.name.image + " " + x.body.number);
        printMethodBodyNode(x.body);
    }

    //-------------------------- Corpo de metodo ----------------------
    public void numberMethodBodyNode(MethodBodyNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberVarDeclListNode(x.param);
        numberStatementNode(x.stat);
    }

    public void printMethodBodyNode(MethodBodyNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": MethodBodyNode ===> " +
            ((x.param == null) ? "null" : String.valueOf(x.param.number)) +
            " " + x.stat.number);
        printVarDeclListNode(x.param);
        printStatementNode(x.stat);
    }

    // --------------------------- Comando composto ----------------------
    public void numberBlockNode(BlockNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberStatementListNode(x.stats);
    }

    public void printBlockNode(BlockNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": BlockNode ===> " + x.stats.number);
        printStatementListNode(x.stats);
    }

    // --------------------- Lista de comandos --------------------
    public void numberStatementListNode(ListNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberStatementNode((StatementNode) x.node);
        numberStatementListNode(x.next);
    }

    public void printStatementListNode(ListNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": ListNode (StatementNode) ===> " +
            x.node.number + " " +
            ((x.next == null) ? "null" : String.valueOf(x.next.number)));

        printStatementNode((StatementNode) x.node);
        printStatementListNode(x.next);
    }

    // --------------------------- Comando print ---------------------
    public void numberPrintNode(PrintNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreNode(x.expr);
    }

    public void printPrintNode(PrintNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": PrintNode ===> " + x.expr.number);
        printExpreNode(x.expr);
    }

    // ---------------------- Comando read --------------------------
    public void numberReadNode(ReadNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreNode(x.expr);
    }

    public void printReadNode(ReadNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": ReadNode ===> " + x.expr.number);
        printExpreNode(x.expr);
    }

    // --------------------- Comando return -------------------------
    public void numberReturnNode(ReturnNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreNode(x.expr);
    }

    public void printReturnNode(ReturnNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": ReturnNode ===> " +
            ((x.expr == null) ? "null" : String.valueOf(x.expr.number)));
        printExpreNode(x.expr);
    }

    // ------------------------ Comando super --------------------------
    public void numberSuperNode(SuperNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreListNode(x.args);
    }

    public void printSuperNode(SuperNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": SuperNode ===> " +
            ((x.args == null) ? "null" : String.valueOf(x.args.number)));
        printExpreListNode(x.args);
    }

    // ------------------------- Comando de atribuicao -------------------
    public void numberAtribNode(AtribNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreNode(x.expr1);
        numberExpreNode(x.expr2);
    }

    public void printAtribNode(AtribNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": AtribNode ===> " + x.expr1.number + " "
            + x.position.image + " " + x.expr2.number);
        printExpreNode(x.expr1);
        printExpreNode(x.expr2);
    }

    // ---------------------------------- comando if --------------------
    public void numberIfNode(IfNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreNode(x.expr);
        numberStatementNode(x.stat1);
        numberStatementNode(x.stat2);
    }

    public void printIfNode(IfNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": IfNode ===> " + x.expr.number + " " +
            x.stat1.number + " " +
            ((x.stat2 == null) ? "null" : String.valueOf(x.stat2.number)));

        printExpreNode(x.expr);
        printStatementNode(x.stat1);
        printStatementNode(x.stat2);
    }

    // ------------------------- comando for -----------------------
    public void numberForNode(ForNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberAtribNode(x.init);
        numberExpreNode(x.expr);
        numberAtribNode(x.incr);
        numberStatementNode(x.stat);
    }

    public void printForNode(ForNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": ForNode ===> " +
            ((x.init == null) ? "null" : String.valueOf(x.init.number)) + " " +
            ((x.expr == null) ? "null" : String.valueOf(x.expr.number)) + " " +
            ((x.incr == null) ? "null" : String.valueOf(x.incr.number)) + " " +
            x.stat.number);

        printAtribNode(x.init);
        printExpreNode(x.expr);
        printAtribNode(x.incr);
        printStatementNode(x.stat);
    }

    // --------------------------- Comando break --------------------
    public void numberBreakNode(BreakNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
    }

    public void printBreakNode(BreakNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": BreakNode");
    }

    // --------------------------- Comando vazio -------------------
    public void numberNopNode(NopNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
    }

    public void printNopNode(NopNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": NopNode");
    }

    // --------------------------- Chamada de metodo -------------------
    public void numberMethodCallNode(MethodCallNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;

		numberExpreNode(x.caminho);
		numberExpreListNode(x.parametros);
    }

    public void printMethodCallNode(MethodCallNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": MethodCallNode ===> " + x.caminho.number + " " +
            ((x.parametros == null) ? "null" : String.valueOf(x.parametros.number)));
        printExpreNode(x.caminho);
        printExpreListNode(x.parametros);
    }

    // --------------------------- Comando dowhile -------------------
    public void numberDoWhileNode(DoWhileNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;

        numberStatementNode(x.statement);
        numberExpreNode(x.expressao);
    }

    public void printDoWhileNode(DoWhileNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": DoWhileNode ===> " +
            x.position.image + " " +
            x.statement.number + " " + 
            ((x.expressao == null) ? "null" : String.valueOf(x.expressao.number)));

        printStatementNode(x.statement);
        printExpreNode(x.expressao);
    }

    // --------------------------- Comando while -------------------
    public void numberWhileNode(WhileNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;

        numberExpreNode(x.expressao);
        numberStatementNode(x.statement);
    }

    public void printWhileNode(WhileNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": WhileNode ===> " +
            x.position.image + " " +
            ((x.expressao == null) ? "null" : String.valueOf(x.expressao.number)) + " " +
            x.statement.number);

        printExpreNode(x.expressao);
        printStatementNode(x.statement);
    }

    // --------------------------- Comando switch -------------------
    public void numberSwitchNode(SwitchNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;

        numberSwitchCaseListNode(x.lista);
    }

    public void printSwitchNode(SwitchNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": SwitchNode ===> " +
            x.position.image + " " + x.variavel.image + " " + 
            ((x.lista == null) ? "null" : String.valueOf(x.lista.number)));

        printSwitchCaseListNode(x.lista);
    }

    // --------------------- Lista de cases --------------------
    public void numberSwitchCaseListNode(ListNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberStatementNode((SwitchCaseNode) x.node);
        numberSwitchCaseListNode(x.next);
    }

    public void printSwitchCaseListNode(ListNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": ListNode (SwitchCaseNode) ===> " +
            x.node.number + " " +
            ((x.next == null) ? "null" : String.valueOf(x.next.number)));

        printStatementNode((SwitchCaseNode) x.node);
        printSwitchCaseListNode(x.next);
    }

    // --------------------------- Cases do Switch -------------------
    public void numberSwitchCaseNode(SwitchCaseNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;

        numberExpreNode(x.factor);
        numberStatementNode(x.statement);
    }

    public void printSwitchCaseNode(SwitchCaseNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": SwitchCaseNode ===> " +
            x.position.image + " " +
            ((x.factor == null) ? "" : String.valueOf(x.factor.number) + " ") +
            x.doisp.image + " " +
            ((x.statement == null) ? "null" : String.valueOf(x.statement.number)));

        printExpreNode(x.factor);
        printStatementNode(x.statement);


    }

    // -------------------------- Alocacao de objeto ------------------------
    public void numberNewObjectNode(NewObjectNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreListNode(x.args);
    }

    public void printNewObjectNode(NewObjectNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": NewObjectNode ===> " + x.name.image +
            " " + ((x.args == null) ? "null" : String.valueOf(x.args.number)));

        printExpreListNode(x.args);
    }

    // -------------------------- Alocacao de array ------------------------
    public void numberNewArrayNode(NewArrayNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreListNode(x.dims);
    }
    //mudanca name virou tipo
    public void printNewArrayNode(NewArrayNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": NewArrayNode ===> " + x.tipo.image +
            " " + ((x.dims == null) ? "null" : String.valueOf(x.dims.number)));

        printExpreListNode(x.dims);
    }

    // --------------------------- Lista de expressoes ---------------
    public void numberExpreListNode(ListNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreNode((ExpreNode) x.node);
        numberExpreListNode(x.next);
    }

    public void printExpreListNode(ListNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": ListNode (ExpreNode) ===> " +
            x.node.number + " " +
            ((x.next == null) ? "null" : String.valueOf(x.next.number)));
        printExpreNode((ExpreNode) x.node);
        printExpreListNode(x.next);
    }

    // --------------------- Expressao logica lista -------------------
    public void numberListRelationalLogicNode(ListRelationalLogicNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;

        numberExpreNode(x.expr1);
        numberExpreListNode(x.lista);

    }

    public void printListRelationalLogicNode(ListRelationalLogicNode x) {
        if (x == null) {
            return;
        }
        
        System.out.println();
        System.out.print(x.number + ": ListRelationalLogicNode ===> " + ((x.possivelNull == null) ? "null" : x.possivelNull.image)  +
            " " + x.expr1.number + " " + ((x.lista == null) ? "null" : String.valueOf(x.lista.number)));
		
        printExpreNode(x.expr1);
        printExpreListNode(x.lista);
        
       
    }

    // --------------------- Expressao logica -------------------
    public void numberRelationalLogicNode(RelationalLogicNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;

        numberExpreNode(x.expr1);

    }

    public void printRelationalLogicNode(RelationalLogicNode x) {
        if (x == null) {
            return;
        }
        
        System.out.println();
        System.out.print(x.number + ": RelationalLogicNode ===> " + x.position.image +
            " " + ((x.possivelNull == null) ? "null" : x.possivelNull.image) + " " + x.expr1.number);

        printExpreNode(x.expr1);
        
       
    }

    // --------------------- Expressao relacional -------------------
    public void numberRelationalNode(RelationalNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;

        numberExpreNode(x.expr1);
        numberExpreNode(x.expr2);

    }

    public void printRelationalNode(RelationalNode x) {
        if (x == null) {
            return;
        }
        
        System.out.println();
        System.out.print(x.number + ": RelationalNode ===> " + x.expr1.number +
            " " + x.position.image + " " + x.expr2.number);

        printExpreNode(x.expr1);
        printExpreNode(x.expr2);
        
       
    }

    // ------------------------ Soma ou subtracao  -------------------
    public void numberAddNode(AddNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreNode(x.expr1);
        numberExpreNode(x.expr2);
    }

    public void printAddNode(AddNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": AddNode ===> " + x.expr1.number + " " +
            x.position.image + " " + x.expr2.number);
        printExpreNode(x.expr1);
        printExpreNode(x.expr2);
    }

    // ---------------------- Multiplicacao ou divisao --------------------
    public void numberMultNode(MultNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreNode(x.expr1);
        numberExpreNode(x.expr2);
    }

    public void printMultNode(MultNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": MultNode ===> " + x.expr1.number + " " +
            x.position.image + " " + x.expr2.number);
        printExpreNode(x.expr1);
        printExpreNode(x.expr2);
    }

    // ------------------------- Expressao unaria ------------------------
    public void numberUnaryNode(UnaryNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreNode(x.expr);
    }

    public void printUnaryNode(UnaryNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": UnaryNode ===> " + x.position.image +
            " " + x.expr.number);
        printExpreNode(x.expr);
    }
    //parou aqui
    // -------------------------- Constante inteira ----------------------
    public void numberIntConstNode(IntConstNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
    }

    public void printIntConstNode(IntConstNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": IntConstNode ===> " + x.position.image);
    }

    // ------------------------ Constante string ----------------------------
    public void numberStringConstNode(StringConstNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
    }

    public void printStringConstNode(StringConstNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": StringConstNode ===> " +
            x.position.image);
    }

    // -------------------------- Constante booleano ----------------------
    public void numberBooleanConstNode(BooleanConstNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
    }

    public void printBooleanConstNode(BooleanConstNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": BooleanConstNode ===> " + x.position.image);
    }

    // -------------------------- Constante char ----------------------
    public void numberCharConstNode(CharConstNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
    }

    public void printCharConstNode(CharConstNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": CharConstNode ===> " + x.position.image);
    }

    // -------------------------- Constante double ----------------------
    public void numberDoubleConstNode(DoubleConstNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
    }

    public void printDoubleConstNode(DoubleConstNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": DoubleConstNode ===> " + x.position.image);
    }

    // -------------------------- Constante byte ----------------------
    public void numberByteConstNode(ByteConstNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
    }

    public void printByteConstNode(ByteConstNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": ByteConstNode ===> " + x.position.image);
    }

    // -------------------------- Constante short ----------------------
    public void numberShortConstNode(ShortConstNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
    }

    public void printShortConstNode(ShortConstNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": ShortConstNode ===> " + x.position.image);
    }

    // -------------------------- Constante long ----------------------
    public void numberLongConstNode(LongConstNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
    }

    public void printLongConstNode(LongConstNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": LongConstNode ===> " + x.position.image);
    }

    // -------------------------- Constante float ----------------------
    public void numberFloatConstNode(FloatConstNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
    }

    public void printFloatConstNode(FloatConstNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": FloatConstNode ===> " + x.position.image);
    }

    // ------------------------------ Constante null --------------------------
    public void numberNullConstNode(NullConstNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
    }

    public void printNullConstNode(NullConstNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": NullConstNode ===> " + x.position.image);
    }

    // -------------------------------- Nome de variavel ------------------
    public void numberVarNode(VarNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
    }

    public void printVarNode(VarNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": VarNode ===> " + x.position.image + " " +
            ((x.dim == 0) ? "" : ("[" + x.dim + "]")));
    }

    // ---------------------------- Chamada de metodo ------------------------
    public void numberCallNode(CallNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreNode(x.expr);
        numberExpreListNode(x.args);
    }

    public void printCallNode(CallNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": CallNode ===> " + x.expr.number + " " +
            x.meth.image + " " +
            ((x.args == null) ? "null" : String.valueOf(x.args.number)));
        printExpreNode(x.expr);
        printExpreListNode(x.args);
    }

    // --------------------------- Indexacao de variavel ---------------
    public void numberIndexNode(IndexNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreNode(x.expr1);
        numberExpreNode(x.expr2);
    }

    public void printIndexNode(IndexNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": IndexNode ===> " + x.expr1.number + " " +
            x.expr2.number);
        printExpreNode(x.expr1);
        printExpreNode(x.expr2);
    }

    // -------------------------- Acesso a campo de variavel ---------------
    public void numberDotNode(DotNode x) {
        if (x == null) {
            return;
        }

        x.number = kk++;
        numberExpreNode(x.expr);
    }

    public void printDotNode(DotNode x) {
        if (x == null) {
            return;
        }

        System.out.println();
        System.out.print(x.number + ": DotNode ===> " + x.expr.number + " " +
            x.field.image);
        printExpreNode(x.expr);
    }

    // --------------------------- Expressao em geral --------------------------
    //ExpreNode virou GeneralNode
    public void printExpreNode(GeneralNode x) {
        if (x instanceof NewObjectNode) {
            printNewObjectNode((NewObjectNode) x);
        } else if (x instanceof NewArrayNode) {
            printNewArrayNode((NewArrayNode) x);
        } else if (x instanceof RelationalNode) {
            printRelationalNode((RelationalNode) x);
        } else if (x instanceof AddNode) {
            printAddNode((AddNode) x);
        } else if (x instanceof MultNode) {
            printMultNode((MultNode) x);
        } else if (x instanceof UnaryNode) {
            printUnaryNode((UnaryNode) x);
        } else if (x instanceof CallNode) {
            printCallNode((CallNode) x);
        } else if (x instanceof IntConstNode) {
            printIntConstNode((IntConstNode) x);
        } else if (x instanceof StringConstNode) {
            printStringConstNode((StringConstNode) x);
        } else if (x instanceof BooleanConstNode) {
            printBooleanConstNode((BooleanConstNode) x);
        } else if (x instanceof CharConstNode) {
            printCharConstNode((CharConstNode) x);
        } else if (x instanceof DoubleConstNode) {
            printDoubleConstNode((DoubleConstNode) x);
        } else if (x instanceof ByteConstNode) {
            printByteConstNode((ByteConstNode) x);
        } else if (x instanceof ShortConstNode) {
            printShortConstNode((ShortConstNode) x);
        } else if (x instanceof LongConstNode) {
            printLongConstNode((LongConstNode) x);
        } else if (x instanceof FloatConstNode) {
            printFloatConstNode((FloatConstNode) x);
        } else if (x instanceof NullConstNode) {
            printNullConstNode((NullConstNode) x);
        } else if (x instanceof IndexNode) {
            printIndexNode((IndexNode) x);
        } else if (x instanceof DotNode) {
            printDotNode((DotNode) x);
        } else if (x instanceof VarNode) {
            printVarNode((VarNode) x);
        } else if (x instanceof RelationalLogicNode) {
            printRelationalLogicNode((RelationalLogicNode) x);
        } else if (x instanceof ListRelationalLogicNode) {
            printListRelationalLogicNode((ListRelationalLogicNode) x);
        }
    }

    //mudanca ExpreeNode virou GeneralNode
    public void numberExpreNode(GeneralNode x) {
        if (x instanceof NewObjectNode) {
            numberNewObjectNode((NewObjectNode) x);
        } else if (x instanceof NewArrayNode) {
            numberNewArrayNode((NewArrayNode) x);
        } else if (x instanceof RelationalNode) {
            numberRelationalNode((RelationalNode) x);
        } else if (x instanceof AddNode) {
            numberAddNode((AddNode) x);
        } else if (x instanceof MultNode) {
            numberMultNode((MultNode) x);
        } else if (x instanceof UnaryNode) {
            numberUnaryNode((UnaryNode) x);
        } else if (x instanceof CallNode) {
            numberCallNode((CallNode) x);
        } else if (x instanceof IntConstNode) {
            numberIntConstNode((IntConstNode) x);
        } else if (x instanceof StringConstNode) {
            numberStringConstNode((StringConstNode) x);
        } else if (x instanceof BooleanConstNode) {
            numberBooleanConstNode((BooleanConstNode) x);
        } else if (x instanceof CharConstNode) {
            numberCharConstNode((CharConstNode) x);
        } else if (x instanceof DoubleConstNode) {
            numberDoubleConstNode((DoubleConstNode) x);
        } else if (x instanceof ByteConstNode) {
            numberByteConstNode((ByteConstNode) x);
        } else if (x instanceof ShortConstNode) {
            numberShortConstNode((ShortConstNode) x);
        } else if (x instanceof LongConstNode) {
            numberLongConstNode((LongConstNode) x);
        } else if (x instanceof FloatConstNode) {
            numberFloatConstNode((FloatConstNode) x);
        } else if (x instanceof NullConstNode) {
            numberNullConstNode((NullConstNode) x);
        } else if (x instanceof IndexNode) {
            numberIndexNode((IndexNode) x);
        } else if (x instanceof DotNode) {
            numberDotNode((DotNode) x);
        } else if (x instanceof VarNode) {
            numberVarNode((VarNode) x);
        } else if (x instanceof RelationalLogicNode) {
            numberRelationalLogicNode((RelationalLogicNode) x);
        } else if (x instanceof ListRelationalLogicNode) {
            numberListRelationalLogicNode((ListRelationalLogicNode) x);
        }
    }

    // --------------------------- Comando em geral -------------------
    public void printStatementNode(StatementNode x) {
        if (x instanceof BlockNode) {
            printBlockNode((BlockNode) x);
        } else if (x instanceof VarDeclNode) {
            printVarDeclNode((VarDeclNode) x);
        } else if (x instanceof AtribNode) {
            printAtribNode((AtribNode) x);
        } else if (x instanceof IfNode) {
            printIfNode((IfNode) x);
        } else if (x instanceof ForNode) {
            printForNode((ForNode) x);
        } else if (x instanceof PrintNode) {
            printPrintNode((PrintNode) x);
        } else if (x instanceof NopNode) {
            printNopNode((NopNode) x);
        } else if (x instanceof ReadNode) {
            printReadNode((ReadNode) x);
        } else if (x instanceof ReturnNode) {
            printReturnNode((ReturnNode) x);
        } else if (x instanceof SuperNode) {
            printSuperNode((SuperNode) x);
        } else if (x instanceof BreakNode) {
            printBreakNode((BreakNode) x);
        } else if (x instanceof MethodCallNode) {
            printMethodCallNode((MethodCallNode) x);
        } else if (x instanceof DoWhileNode) {
            printDoWhileNode((DoWhileNode) x);
        } else if (x instanceof WhileNode) {
            printWhileNode((WhileNode) x);
        } else if (x instanceof SwitchNode) {
            printSwitchNode((SwitchNode) x);
        } else if (x instanceof SwitchCaseNode){
        	printSwitchCaseNode((SwitchCaseNode) x);
        }
    }

    public void numberStatementNode(StatementNode x) {
        if (x instanceof BlockNode) {
            numberBlockNode((BlockNode) x);
        } else if (x instanceof VarDeclNode) {
            numberVarDeclNode((VarDeclNode) x);
        } else if (x instanceof AtribNode) {
            numberAtribNode((AtribNode) x);
        } else if (x instanceof IfNode) {
            numberIfNode((IfNode) x);
        } else if (x instanceof ForNode) {
            numberForNode((ForNode) x);
        } else if (x instanceof PrintNode) {
            numberPrintNode((PrintNode) x);
        } else if (x instanceof NopNode) {
            numberNopNode((NopNode) x);
        } else if (x instanceof ReadNode) {
            numberReadNode((ReadNode) x);
        } else if (x instanceof ReturnNode) {
            numberReturnNode((ReturnNode) x);
        } else if (x instanceof SuperNode) {
            numberSuperNode((SuperNode) x);
        } else if (x instanceof BreakNode) {
            numberBreakNode((BreakNode) x);
        } else if (x instanceof MethodCallNode) {
            numberMethodCallNode((MethodCallNode) x);
        } else if (x instanceof DoWhileNode) {
            numberDoWhileNode((DoWhileNode) x);
        } else if (x instanceof WhileNode) {
            numberWhileNode((WhileNode) x);
        } else if (x instanceof SwitchNode) {
            numberSwitchNode((SwitchNode) x);
        } else if (x instanceof SwitchCaseNode){
        	numberSwitchCaseNode((SwitchCaseNode) x);
        }
    }
}
