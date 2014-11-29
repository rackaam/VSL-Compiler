import java.util.List;

/**
 * This class implements all the methods for 3a code generation (NOTE: this
 * class must be coded by the student; the methods indicated here can be seen as
 * a suggestion, but are not actually necessary).
 * 
 * @author MLB
 * 
 */
public class Code3aGenerator {

	// Constructor not needed
	private Code3aGenerator() {
	}

	/**
	 * Generates the 3a statement: VAR t
	 **/
	public static Code3a genVar(Operand3a t) {
		Inst3a i = new Inst3a(Inst3a.TAC.VAR, t, null, null);
		return new Code3a(i);
	}

	public static Code3a genTabVar(VarSymbol temp, Operand3a tab,
			ExpAttribute exp) {
		return new Code3a(new Inst3a(Inst3a.TAC.TABVAR, temp, tab, exp.place));
	}

	public static Code3a genVarTab(ArrayAttribute arrayElem, VarSymbol value) {
		return new Code3a(new Inst3a(Inst3a.TAC.VARTAB, arrayElem.place,
				arrayElem.index.place, value));
	}

	/**
	 * Generate code for a binary operation
	 * 
	 * @param op
	 *            must be a code op: Inst3a.TAC.XXX
	 */
	public static Code3a genBinOp(Inst3a.TAC op, ExpAttribute exp1,
			ExpAttribute exp2, Operand3a temp) {
		Code3a cod = exp1.code;
		cod.append(exp2.code);
		cod.append(genVar(temp));
		cod.append(new Inst3a(op, temp, exp1.place, exp2.place));
		return cod;
	}

	public static Code3a genLabel(LabelSymbol label) {
		return new Code3a(new Inst3a(Inst3a.TAC.LABEL, label, null, null));
	}

	public static Code3a genIfZ(ExpAttribute exp, LabelSymbol label) {
		Code3a code = exp.code;
		code.append(new Inst3a(Inst3a.TAC.IFZ, exp.place, label, null));
		return code;
	}

	public static Code3a genGoTo(LabelSymbol label) {
		return new Code3a(new Inst3a(Inst3a.TAC.GOTO, label, null, null));
	}

	public static Code3a genArg(Operand3a op) {
		return new Code3a(new Inst3a(Inst3a.TAC.ARG, op, null, null));
	}

	public static Code3a genCall(Operand3a function) {
		return new Code3a(new Inst3a(Inst3a.TAC.CALL, null, function, null));
	}

	public static Code3a genCallReturn(Operand3a tempReturn, Operand3a function) {
		return new Code3a(new Inst3a(Inst3a.TAC.CALL, tempReturn, function,
				null));
	}

	public static Code3a genBeginFunc() {
		return new Code3a(new Inst3a(Inst3a.TAC.BEGINFUNC, null, null, null));
	}

	public static Code3a genEndFunc() {
		return new Code3a(new Inst3a(Inst3a.TAC.ENDFUNC, null, null, null));
	}

	/***********************************************************************/

	public static Code3a newVarDeclaration(SymbolTable symTab, String name) {
		Code3a code = null;
		Operand3a o = symTab.lookup(name);
		int currentScope = symTab.getScope();
		if (o != null && o.getScope() == currentScope) {
			System.err.println("Error: \"" + name + "\" is already declared.");
			System.exit(-1);
		} else {
			VarSymbol vs = new VarSymbol(Type.INT, name, symTab.getScope());
			symTab.insert(name, vs);
			code = genVar(vs);
		}
		return code;
	}

	public static Code3a newArrayDeclaration(SymbolTable symTab, String name,
			int size) {
		Code3a code = null;
		Operand3a o = symTab.lookup(name);
		int currentScope = symTab.getScope();
		if (o != null && o.getScope() == currentScope) {
			System.err.println("Error: variable \"" + name
					+ "\" is already declared.");
		} else {
			ArrayType at = new ArrayType(Type.INT, size);
			VarSymbol vs = new VarSymbol(at, name, symTab.getScope());
			symTab.insert(name, vs);
			code = genVar(vs);
		}
		return code;
	}

	public static ArrayAttribute newArrayElem(SymbolTable symTab, String ident,
			ExpAttribute e) {
		Operand3a o = symTab.lookup(ident);
		if (o == null) {
			System.err.println("Error: variable \"" + ident
					+ "\" is not declared.");
			return null;
		}
		if (!o.isArray()) {
			System.err.println("Error: variable \"" + ident
					+ "\" is not an array");
			return null;
		} else {
			VarSymbol temp = SymbDistrib.newTemp();
			Code3a code = genTabVar(temp, o, e);
			ExpAttribute exp = new ExpAttribute(o.type, code, temp);
			return new ArrayAttribute(o, e, exp);
		}
	}

	public static VarSymbol newVarParam(SymbolTable symTab, String ident) {
		VarSymbol vs = new VarSymbol(Type.INT, ident, symTab.getScope());
		vs.setParam();
		return vs;
	}

	public static VarSymbol newArrayParam(SymbolTable symTab, String ident) {
		VarSymbol vs = new VarSymbol(Type.POINTER, ident, symTab.getScope());
		vs.setParam();
		return vs;
	}
	
	public static Code3a assignExp(SymbolTable symTab, String varName, ExpAttribute e){
		Code3a code = null;
		Operand3a id = symTab.lookup(varName);
        if (id != null) {
            code = e.code;
            code.append(new Code3a(new Inst3a(Inst3a.TAC.COPY, id, e.place, null)));
        }
        else {
            System.err.println("Error: variable " + varName + " is not declared.");
        }
		return code;
	}

	public static Code3a newProto(SymbolTable symTab, Type returnType,
			String name, List<VarSymbol> params) {
		Operand3a o = symTab.lookup(name);

		if (o != null) {
			System.err.println("Error: function " + name
					+ " is already declared");
			System.exit(1);
		}

		LabelSymbol ls = new LabelSymbol(name);
		FunctionType ft = new FunctionType(returnType, true);
		for (VarSymbol vs : params)
			ft.extend(vs.type);
		FunctionSymbol fs = new FunctionSymbol(ls, ft);
		symTab.insert(name, fs);

		return null; // Prototype returns no code
	}

	public static Code3a newFunctionSCall(SymbolTable symTab,
			String functionName, VSLTreeParser.argument_list_return alr) {
		Code3a code = null;
		Operand3a o = symTab.lookup(functionName);
		if (o != null) {
			List<Type> expectedArgs = ((FunctionType) o.type).getArguments();
			if ((alr == null && expectedArgs == null)
					|| (alr == null && expectedArgs.size() == 0)
					|| (expectedArgs.size() == alr.args.size())) {
				// todo verifier le type des arguments
				code = new Code3a();
				if (alr != null)
					code.append(alr.code);
				code.append(genCall(o));
			} else {
				System.err.println("Error: incompatible with the function "
						+ functionName + ".");
				System.exit(-1);
			}
		} else {
			System.err.println("Error: function " + functionName
					+ " is not declared.");
			System.exit(-1);
		}
		return code;
	}

	public static ExpAttribute newFunctionCall(SymbolTable symTab,
			String functionName, VSLTreeParser.argument_list_return alr) {
		ExpAttribute expAtt = null;
		Operand3a o = symTab.lookup(functionName);
		if (o != null) {
			if (((FunctionType) o.type).getReturnType() == Type.VOID) {
				System.err
						.println("Error: VOID function cannot be used in primary_exp.");
				System.exit(-1);
			}
			List<Type> expectedArgs = ((FunctionType) o.type).getArguments();
			if ((alr == null && expectedArgs == null)
					|| (alr == null && expectedArgs.size() == 0)
					|| (expectedArgs.size() == alr.args.size())) {
				// todo verifier le type des arguments
				Type ty = o.type;
				VarSymbol temp = SymbDistrib.newTemp();
				Code3a code = new Code3a();
				if (alr != null)
					code.append(alr.code);
				code.append(genCallReturn(temp, o));
				expAtt = new ExpAttribute(ty, code, temp);
			} else {
				System.err.println("Error: incompatible with the function "
						+ functionName + ".");
				System.exit(-1);
			}
		} else {
			System.err.println("Error: function " + functionName
					+ " is not declared.");
			System.exit(-1);
		}
		return expAtt;
	}
	
	public static Code3a genFunctionHeader(SymbolTable symTab, String name, Type returnType, List<VarSymbol> params){
		Code3a code = null;
		Operand3a func = symTab.lookup(name);
       	if(func != null){
        	FunctionType ft = (FunctionType)func.type;
        	if(ft.prototype == false){
	            System.err.println("Fonction déjà définie");
	        } 
		}
		
        LabelSymbol ls = new LabelSymbol(name);
        FunctionType newFt = new FunctionType(returnType, false);
        for (VarSymbol vs : params)
        	newFt.extend(vs.type);
        FunctionSymbol fs = new FunctionSymbol(ls, newFt);
        symTab.insert(name, fs);
        
        code = Code3aGenerator.genLabel(fs.label);
        code.append(Code3aGenerator.genBeginFunc());
        symTab.enterScope();
        for(VarSymbol vs : params){
            Operand3a o = symTab.lookup(vs.name);
            if(o != null && o.getScope() == symTab.getScope()){
                System.err.println("deux paramètres ont le même nom");
            }
            symTab.insert(vs.name, vs);
            code.append(Code3aGenerator.genVar(vs));
        }
        return code;
	}

	public static Code3a genPrintText(String text) {
		LabelSymbol ls = SymbDistrib.builtinPrintS;
		Data3a data = new Data3a(text);
		Code3a code = Code3aGenerator.genArg(data.getLabel());
		code.appendData(data);
		code.append(Code3aGenerator.genCall(ls));
		return code;
	}

	public static Code3a genPrintExp(ExpAttribute expAtt) {
		LabelSymbol ls = SymbDistrib.builtinPrintN;
		Code3a code = expAtt.code;
		code.append(Code3aGenerator.genArg(expAtt.place));
		code.append(Code3aGenerator.genCall(ls));
		return code;
	}

	public static Code3a readVarItem(SymbolTable symTab, String name) {
		Code3a code = null;
		Operand3a o = symTab.lookup(name);
		if (o == null) {
			System.err.println("Error: variable \"" + name
					+ "\" is not declared.");
			System.exit(-1);
		} else {
			LabelSymbol ls = SymbDistrib.builtinRead;
			code = Code3aGenerator.genCallReturn(o, ls);
		}
		return code;
	}
	
	public static Code3a readArrayItem(SymbolTable symTab, ArrayAttribute arrAtt){
		Code3a code = null;
		Operand3a o = symTab.lookup(arrAtt.place.getName3a());

        if (o == null) {
            System.err.println("Error: array " + arrAtt.place.getName3a() + " is not declared.");
            System.exit(-1);
        }

        VarSymbol temp = SymbDistrib.newTemp();
        LabelSymbol ls = SymbDistrib.builtinRead;
		code = Code3aGenerator.genCallReturn(temp, ls);
        code.append(genVarTab(arrAtt, temp));
		return code;
	}

} // Code3aGenerator ***
