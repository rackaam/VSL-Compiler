tree grammar VSLTreeParser;

options {
  language     = Java;
  tokenVocab   = VSLParser;
  ASTLabelType = CommonTree;
}

s [SymbolTable symTab] returns [Code3a code]
  : st=statement[symTab] { code = st; }
  ;
  
statement [SymbolTable symTab] returns [Code3a cod]
	: ^(ASSIGN_KW e=expression[symTab] IDENT) {
		Operand3a id = symTab.lookup($IDENT.text);
		if (id != null) {
			cod = e.code;
			cod.append(new Code3a(new Inst3a(Inst3a.TAC.COPY, id, e.place, null)));
		}
		else {
			System.err.println("Errot: variable \"" + $IDENT.text + "\" is not declared.");
		}
	}
	| b=block[symTab] {
        cod = b;
    }
	;

block [SymbolTable symTab] returns [Code3a cod]
	: ^(BLOCK d=declaration[symTab] il=inst_list[symTab])
	{
		symTab.enterScope();
		cod = d;
		cod.append(il);
		symTab.leaveScope();
	}
	| ^(BLOCK il=inst_list[symTab])
	{
		cod = il;
	}
	;
	
inst_list [SymbolTable symTab] returns [Code3a cod]
	@init{
		cod = new Code3a();
	}
	: ^(INST (st=statement[symTab]{
		cod.append(st) ;
	})+)
	;

expression [SymbolTable symTab] returns [ExpAttribute expAtt]
  : ^(PLUS e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, e1, e2, temp);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  |
    ^(MINUS e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, e1, e2, temp);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  |
   ^(MUL e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, e1, e2, temp);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  |
    ^(DIV e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, e1, e2, temp);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  | 
     pe=primary_exp[symTab] 
    { expAtt = pe; }
  ;
 
primary_exp [SymbolTable symTab] returns [ExpAttribute expAtt]
  : INTEGER
    {
      ConstSymbol cs = new ConstSymbol(Integer.parseInt($INTEGER.text));
      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
    }
  | IDENT
    {
      Operand3a id = symTab.lookup($IDENT.text);
      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup($IDENT.text));
    }
  ;

declaration [SymbolTable symTab] returns [Code3a cod]
	: ^(DECL (dl=decl_list[symTab]{
		cod = dl ;
	}))
	;

decl_list [SymbolTable symTab] returns [Code3a cod]
	@init{
		cod = new Code3a();
	}
	: (di = decl_item[symTab]{
		cod.append(di);
	})+
	;

decl_item [SymbolTable symTab] returns [Code3a cod]
	: IDENT
	{
		Operand3a id = symTab.lookup($IDENT.text);
		if (id == null){
			VarSymbol vs = new VarSymbol(Type.INT, $IDENT.text, symTab.getScope());
			symTab.insert($IDENT.text, vs);
			cod = Code3aGenerator.genVar(vs);
		}
		else {
			System.err.println("Error: \"" + $IDENT.text + "\" is already declared.");
		}
	}
	| ^(ARDECL IDENT INTEGER)
	{
		Operand3a id = symTab.lookup($IDENT.text);
		if (id == null){
			ArrayType aty = new ArrayType(Type.INT, Integer.parseInt($INTEGER.text));
			VarSymbol vs = new VarSymbol(aty, $IDENT.text, symTab.getScope());
			symTab.insert($IDENT.text, vs);
			cod = Code3aGenerator.genVar(vs);
		}
		else {
			System.err.println("Error: variable \"" + $IDENT.text + "\" is already declared.");
		}
	}
	;
