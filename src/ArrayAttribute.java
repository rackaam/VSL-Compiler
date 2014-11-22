
public class ArrayAttribute {

	public String ident;
	public ExpAttribute index;
	public ExpAttribute exp;
	
	/**
	 * 
	 * @param ident Array's name
	 * @param index 
	 * @param exp
	 */
	public ArrayAttribute(String ident, ExpAttribute index, ExpAttribute exp){
		this.ident = ident;
		this.index = index;
		this.exp = exp;
	}
	
}
