tree grammar VSLTreeParser;

options {
  language     = Java;
  tokenVocab   = VSLParser;
  ASTLabelType = CommonTree;
}

s [SymbolTable symTab] returns [Code3a code]
: 
    st=statement[symTab] 
    { 
        code = st; 
    }
;
  
statement [SymbolTable symTab] returns [Code3a code]
: 
    ^(ASSIGN_KW e=expression[symTab] (
    (	IDENT 
	    {
	        Operand3a id = symTab.lookup($IDENT.text);
	        if (id != null) {
	            code = e.code;
	            code.append(new Code3a(new Inst3a(Inst3a.TAC.COPY, id, e.place, null)));
	        }
	        else {
	            System.err.println("Error: variable \"" + $IDENT.text + "\" is not declared.");
	        }
	    }
    )
	|
	(
		arrayElem=array_elem[symTab])
		{
			code = e.code;
			code.append(Code3aGenerator.genVarTab(arrayElem, e));
		}
	) 
	)
|
    ^( IF_KW  e=expression[symTab] 
    {
        LabelSymbol l_else = SymbDistrib.newLabel();
        LabelSymbol l_fin = SymbDistrib.newLabel();
        code = Code3aGenerator.genIfZ(e, l_else);
    }
        s1 = statement[symTab]
    {
        code.append(s1);
        code.append(Code3aGenerator.genGoTo(l_fin));
        code.append(Code3aGenerator.genLabel(l_else));
    }
        (s2 = statement[symTab]
        {
            code.append(s2);
        }
        )?
    {
        code.append(Code3aGenerator.genLabel(l_fin));
    }
    )
| 
    ^(  WHILE_KW e = expression[symTab]
    {
        LabelSymbol l_deb = SymbDistrib.newLabel();
        LabelSymbol l_fin = SymbDistrib.newLabel();
        code = (Code3aGenerator.genLabel(l_deb));
        code.append(Code3aGenerator.genIfZ(e, l_fin));
    }
        st = statement[symTab]
    {
        code.append(st);
        code.append(Code3aGenerator.genGoTo(l_deb));
        code.append(Code3aGenerator.genLabel(l_fin));
    }
    )
|
	^(PRINT_KW pl = print_list[symTab])
	{
		code = pl;
	}
|
	^(READ_KW rl = read_list[symTab])
	{
		code = rl;
	}
|
    b=block[symTab] 
    {
        code = b;
    }
;

block [SymbolTable symTab] returns [Code3a code]
: 
    ^(BLOCK 
    {
        symTab.enterScope();
    }
        d=declaration[symTab] il=inst_list[symTab]) 
    {
        code = d;
        code.append(il);
        symTab.leaveScope();
    }
| 
    ^(BLOCK il=inst_list[symTab]) 
    {
        code = il;
    }
;

inst_list [SymbolTable symTab] returns [Code3a code]
@init
{
    code = new Code3a();
}
: 
    ^(INST (st=statement[symTab]
    {
        code.append(st);
    }
    )+ )
;

expression [SymbolTable symTab] returns [ExpAttribute expAtt]
: 
    ^(PLUS e1 = expression[symTab] e2 = expression[symTab]) 
    { 
        Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
        VarSymbol temp = SymbDistrib.newTemp();
        Code3a code = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, e1, e2, temp);
        expAtt = new ExpAttribute(ty, code, temp);
    }
|
    ^(MINUS e1 = expression[symTab] e2 = expression[symTab]) 
    { 
        Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
        VarSymbol temp = SymbDistrib.newTemp();
        Code3a code = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, e1, e2, temp);
        expAtt = new ExpAttribute(ty, code, temp);
    }
|
    ^(MUL e1 = expression[symTab] e2 = expression[symTab]) 
    { 
        Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
        VarSymbol temp = SymbDistrib.newTemp();
        Code3a code = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, e1, e2, temp);
        expAtt = new ExpAttribute(ty, code, temp);
    }
|
    ^(DIV e1 = expression[symTab] e2 = expression[symTab]) 
    { 
        Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
        VarSymbol temp = SymbDistrib.newTemp();
        Code3a code = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, e1, e2, temp);
        expAtt = new ExpAttribute(ty, code, temp);
    }
| 
    pe = primary_exp[symTab] 
    { 
        expAtt = pe; 
    }
;

array_elem [SymbolTable symTab] returns [ArrayAttribute arrAtt]
:
	^(ARELEM  IDENT e=expression[symTab])
	{
		arrAtt = TreeParserCode.newArrayElem(symTab, $IDENT.text, e);
    }
;
 
primary_exp [SymbolTable symTab] returns [ExpAttribute expAtt]
: 
    INTEGER
    {
        ConstSymbol cs = new ConstSymbol(Integer.parseInt($INTEGER.text));
        expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
    }
| 
    IDENT
    {
        Operand3a o = symTab.lookup($IDENT.text);
        if(o == null){
           System.err.println("Error: variable \"" + $IDENT.text + "\" is not declared.");
        }
        expAtt = new ExpAttribute(o.type, new Code3a(), symTab.lookup($IDENT.text));
    }
|
	a = array_elem[symTab]
	{
		expAtt = a.exp;
	}
;

declaration [SymbolTable symTab] returns [Code3a code]
: 
    ^(DECL (dl = decl_list[symTab]
    {
		code = dl;
	}))
;

decl_list [SymbolTable symTab] returns [Code3a code]
@init
{
    code = new Code3a();
}
: 
    (di = decl_item[symTab]
    {
		code.append(di);
	}
	)+
;

decl_item [SymbolTable symTab] returns [Code3a code]
: 
    IDENT
	{
		Operand3a o = symTab.lookup($IDENT.text);
		int currentScope = symTab.getScope();
		if (o != null && o.getScope() == currentScope){
			System.err.println("Error: \"" + $IDENT.text + "\" is already declared.");
		} else {
			VarSymbol vs = new VarSymbol(Type.INT, $IDENT.text, symTab.getScope());
			symTab.insert($IDENT.text, vs);
			code = Code3aGenerator.genVar(vs);
		}
	}
| 
    ^(ARDECL IDENT INTEGER)
	{
		Operand3a o = symTab.lookup($IDENT.text);
		int currentScope = symTab.getScope();
		if (o != null && o.getScope() == currentScope){
			System.err.println("Error: variable \"" + $IDENT.text + "\" is already declared.");
		} else {
			ArrayType at = new ArrayType(Type.INT, Integer.parseInt($INTEGER.text));
			VarSymbol vs = new VarSymbol(at, $IDENT.text, symTab.getScope());
			symTab.insert($IDENT.text, vs);
			code = Code3aGenerator.genVar(vs);
		}
	}
;


print_list [SymbolTable symTab] returns [Code3a code]
@init
{
    code = new Code3a();
}
: 
    (pi = print_item[symTab]
    {
		code.append(pi);
	}
	)+
;

print_item [SymbolTable symTab] returns [Code3a code]
:
	TEXT
	{
		LabelSymbol ls = SymbDistrib.builtinPrintS;
		Data3a data = new Data3a($TEXT.text);
		code = Code3aGenerator.genArg(data.getLabel());
		code.appendData(data);
		code.append(Code3aGenerator.genCall(ls));
	}
	|
	e = expression[symTab]
	{
		LabelSymbol ls = SymbDistrib.builtinPrintN;
		code = e.code;
		code.append(Code3aGenerator.genArg(e.place));
		code.append(Code3aGenerator.genCall(ls));
	}
;

read_list [SymbolTable symTab] returns [Code3a code]
@init
{
    code = new Code3a();
}
: 
    (ri = read_item[symTab]
    {
		code.append(ri);
	}
	)+
;

read_item [SymbolTable symTab] returns [Code3a code]
:
	IDENT
	{
		Operand3a o = symTab.lookup($IDENT.text);
		if(o == null){
			System.err.println("Error: variable \"" + $IDENT.text + "\" is not declared.");
		}else {
			LabelSymbol ls = SymbDistrib.builtinRead;
			code = Code3aGenerator.genCallReturn(o, ls);
		}
	}
;
