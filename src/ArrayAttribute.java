public class ArrayAttribute {

	public Operand3a place;
	public ExpAttribute index;
	public ExpAttribute exp;

	/**
	 * 
	 * @param ident
	 * @param index
	 * @param exp
	 */
	public ArrayAttribute(Operand3a place, ExpAttribute index, ExpAttribute exp) {
		this.place = place;
		this.index = index;
		this.exp = exp;
	}

}
