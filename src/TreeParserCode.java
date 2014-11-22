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
	
	public static VarSymbol newVarParam(SymbolTable symTab, String ident){
		VarSymbol vs = new VarSymbol(Type.INT, ident, symTab.getScope());
		vs.setParam();
		return vs;
	}
	
	public static VarSymbol newArrayParam(SymbolTable symTab, String ident){
		VarSymbol vs = new VarSymbol(Type.POINTER, ident, symTab.getScope());
		vs.setParam();
		return vs;
	}
	
	

}
