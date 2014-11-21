public class TreeParserCode {

	public static ExpAttribute newArrayElem(SymbolTable symTab, String ident,
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
			return new ExpAttribute(o.type, code, temp);
		}
	}
}
