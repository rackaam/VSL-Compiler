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
	
	public static Code3a genTabVar(VarSymbol temp, Operand3a tab, ExpAttribute exp){
		return new Code3a(new Inst3a(Inst3a.TAC.TABVAR, temp , tab, exp.place));
	}
	
	//PROBLEME=>ARRAY ELEM ne contient pas l'ident=>creation tabAttribute?
//	public static Code3a genVarTab(ExpAttribute arrayElem, ExpAttribute exp2){
//		return new Code3a(new Inst3a(Inst3a.TAC.VARTAB, arrayElem.place , arrayElem., exp2.place));
//	}

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
	
	public static Code3a genCall(LabelSymbol label) {
		return new Code3a(new Inst3a(Inst3a.TAC.CALL, null, label, null));
	}
	
	public static Code3a genCallReturn(Operand3a o, LabelSymbol label) {
		return new Code3a(new Inst3a(Inst3a.TAC.CALL, o, label, null));
	}

} // Code3aGenerator ***
