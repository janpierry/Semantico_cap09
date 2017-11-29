package semanalysis;

import symtable.*;

import syntacticTree.*;


public class ClassCheck {
    Symtable Maintable; // tabela de mais alto nivel
    protected Symtable Curtable; // apontador para a tabela corrente
    int foundSemanticError; // contador de erros encontrados

    public ClassCheck() {
        EntrySimple k;

        foundSemanticError = 0;
        Maintable = new Symtable(); // cria tabela principal
        k = new EntrySimple("int"); // insere os tipos basicos da linguagem
        Maintable.add(k);
        k = new EntrySimple("string");
        Maintable.add(k);
        //mudancas
        k = new EntrySimple("char"); 
        Maintable.add(k);
        k = new EntrySimple("boolean"); 
        Maintable.add(k);
        k = new EntrySimple("double"); 
        Maintable.add(k);
        k = new EntrySimple("byte"); 
        Maintable.add(k);
        k = new EntrySimple("short"); 
        Maintable.add(k);
        k = new EntrySimple("long"); 
        Maintable.add(k);
        k = new EntrySimple("float"); 
        Maintable.add(k);
    }

    public void ClassCheckRoot(ListNode x) throws SemanticException {
        Curtable = Maintable; // tabela corrente = principal
        ClassCheckClassDeclListNode(x); // chama analise para raiz da arvore

        if (foundSemanticError != 0) { // se houve erro, lanca excecao
            throw new SemanticException(foundSemanticError +
                " Semantic Errors found (phase 1)");
        }
    }

    public void ClassCheckClassDeclListNode(ListNode x) {
        if (x == null) {
            return;
        }

        try {
            ClassCheckClassDeclNode((ClassDeclNode) x.node);
        } catch (SemanticException e) { // se um erro ocorreu na classe, da a msg mas faz a analise p/ proxima
            System.out.println(e.getMessage());
            foundSemanticError++;
        }

        ClassCheckClassDeclListNode(x.next);
    }

    //duvida: so existe o tratamento se a classe ja existe, e a superclasse?
    public void ClassCheckClassDeclNode(ClassDeclNode x)
        throws SemanticException {
        Symtable temphold = Curtable; //  salva apontador p/ tabela corrente
        EntryClass nc;

        if (x == null) {
            return;
        }

        // procura classe na tabela
        nc = (EntryClass) Curtable.classFindUp(x.name.image);

        if (nc != null) // ja declarada, ERRO
         {
            throw new SemanticException(x.name,
                "Class " + x.name.image + " already declared");
        }

        // inclui classe na tabela corrente
        Curtable.add(nc = new EntryClass(x.name.image, Curtable));
        Curtable = nc.nested; // tabela corrente = tabela da classe
        ClassCheckClassBodyNode(x.body);
        Curtable = temphold; // recupera apontador p/ tabela corrente
    }

    public void ClassCheckClassBodyNode(ClassBodyNode x) {
        if (x == null) {
            return;
        }

        ClassCheckClassDeclListNode(x.clist);
    }
}
