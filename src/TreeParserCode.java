import java.util.List;

public class TreeParserCode {

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
			Code3a code = Code3aGenerator.genTabVar(temp, o, e);
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

}
