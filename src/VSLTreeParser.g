tree grammar VSLTreeParser;

options 
{
  language     = Java;
  tokenVocab   = VSLParser;
  ASTLabelType = CommonTree;
}

program [SymbolTable symTab] returns [Code3a code]
@init 
{ 
	code = new Code3a(); 
}
: 
    ^(PROG (u=unit[symTab]
    { 
        code.append(u); 
    })
    +)
;


unit [SymbolTable symTab] returns [Code3a code]
:
	(f = function[symTab]
	{
		code = f; 
	})
	|
	(p = proto[symTab]
	{
		code = p;
	})
;


param [SymbolTable symTab] returns [VarSymbol vs]
:	
	IDENT
    {
        vs = Code3aGenerator.newVarParam(symTab, $IDENT.text);
    }
    |
    ^(ARRAY IDENT)
    {
        vs = Code3aGenerator.newArrayParam(symTab, $IDENT.text);
    }
;

param_list [SymbolTable symTab] returns [List<VarSymbol> list_vs]
@init 
{ 
	list_vs = new ArrayList<VarSymbol>(); 
}
: 
	^(PARAM (p = param[symTab] 
{ 
	list_vs.add(p); 
}
)*)
;

type returns [Type t]
: 
	INT_KW 
{
	t = Type.INT;
}
| 
	VOID_KW 
{
	t = Type.VOID;
}
;

proto[SymbolTable symTab] returns [Code3a code]
:
    ^( PROTO_KW t=type IDENT params=param_list[symTab])
    {
        code = Code3aGenerator.newProto(symTab, t, $IDENT.text, params);
    }
;

function[SymbolTable symTab] returns [Code3a code]
:
    ^( FUNC_KW returnType=type IDENT params=param_list[symTab] 
    {
        code = Code3aGenerator.genFunctionHeader(symTab, $IDENT.text, returnType, params); 
    }
    ^(BODY st=statement[symTab] 
        { 
            code.append(st); 
        }
    )
    {
        symTab.leaveScope();
        code.append(Code3aGenerator.genEndFunc());
    })
;


  
statement [SymbolTable symTab] returns [Code3a code]
: 
    ^(ASSIGN_KW e=expression[symTab] (
    (	IDENT 
	    {
	        code = Code3aGenerator.assignExp(symTab, $IDENT.text, e);
	    }
    )
	|
	(
		arrayElem=array_elem[symTab])
		{
			code = e.code;
			code.append(Code3aGenerator.genVarTab(arrayElem, (VarSymbol)e.place));
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
    ^(WHILE_KW e = expression[symTab]
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
|   ^(RETURN_KW e = expression[symTab])
    {
        code = e.code;
        code.append(new Inst3a(Inst3a.TAC.RETURN, e.place, null, null));
    }
| 
    ^(FCALL_S IDENT (al=argument_list[symTab])?)
    {
        code = Code3aGenerator.newFunctionSCall(symTab, $IDENT.text, (argument_list_return)al);
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
		arrAtt = Code3aGenerator.newArrayElem(symTab, $IDENT.text, e);
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
| 
    ^(FCALL IDENT (al=argument_list[symTab])?)
    {
        expAtt = Code3aGenerator.newFunctionCall(symTab, $IDENT.text, (argument_list_return)al);
    }
;

argument_list[SymbolTable symTab] returns [Code3a code, List<Type> args]
@init
{
    $code = new Code3a();
    $args = new ArrayList<Type>();
}
:   (e=expression[symTab]
    {
        $args.add(Type.INT);
        $code.append(e.code);
        $code.append(Code3aGenerator.genArg(e.place));
    }
    )+
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
		code = Code3aGenerator.newVarDeclaration(symTab, $IDENT.text);
	}
| 
    ^(ARDECL IDENT INTEGER)
	{
        code = Code3aGenerator.newArrayDeclaration(symTab, $IDENT.text, Integer.parseInt($INTEGER.text));
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
		code = Code3aGenerator.genPrintText($TEXT.text);
	}
	|
	e = expression[symTab]
	{
		code = Code3aGenerator.genPrintExp(e);
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
		code = Code3aGenerator.readVarItem(symTab, $IDENT.text);
	}
    |
    arrAtt = array_elem[symTab]
    {
        code = Code3aGenerator.readArrayItem(symTab, arrAtt);
    }
;
