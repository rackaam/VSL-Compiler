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
			return new ArrayAttribute(ident, e, exp);
		}
	}
//	
//	public static Code3a assignExpToArrayElem(SymbolTable symTab, ExpAttribute arrayElem, 
//			ExpAttribute e){
//			Code3a code = Code3aGenerator.genVarTab(arrayElem., e, e);
//			return new ExpAttribute(o.type, code, temp);
//		}
//	}
//	^(ASSIGN_KW expression array_elem)
//	{
//		
//	} 
//|
}
