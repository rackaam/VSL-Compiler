// $ANTLR 3.5.2 VSLTreeParser.g 2014-11-29 15:38:39

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class VSLTreeParser extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASCII", "ASSIGN_KW", "COM", "COMMENT", 
		"DIGIT", "DIV", "DO_KW", "ELSE_KW", "FI_KW", "FUNC_KW", "IDENT", "IF_KW", 
		"INTEGER", "INT_KW", "LB", "LC", "LETTER", "LP", "MINUS", "MUL", "OD_KW", 
		"PLUS", "PRINT_KW", "PROTO_KW", "RB", "RC", "READ_KW", "RETURN_KW", "RP", 
		"TEXT", "THEN_KW", "VOID_KW", "WHILE_KW", "WS", "ARDECL", "ARELEM", "ARRAY", 
		"BLOCK", "BODY", "DECL", "FCALL", "FCALL_S", "INST", "PARAM", "PROG"
	};
	public static final int EOF=-1;
	public static final int ASCII=4;
	public static final int ASSIGN_KW=5;
	public static final int COM=6;
	public static final int COMMENT=7;
	public static final int DIGIT=8;
	public static final int DIV=9;
	public static final int DO_KW=10;
	public static final int ELSE_KW=11;
	public static final int FI_KW=12;
	public static final int FUNC_KW=13;
	public static final int IDENT=14;
	public static final int IF_KW=15;
	public static final int INTEGER=16;
	public static final int INT_KW=17;
	public static final int LB=18;
	public static final int LC=19;
	public static final int LETTER=20;
	public static final int LP=21;
	public static final int MINUS=22;
	public static final int MUL=23;
	public static final int OD_KW=24;
	public static final int PLUS=25;
	public static final int PRINT_KW=26;
	public static final int PROTO_KW=27;
	public static final int RB=28;
	public static final int RC=29;
	public static final int READ_KW=30;
	public static final int RETURN_KW=31;
	public static final int RP=32;
	public static final int TEXT=33;
	public static final int THEN_KW=34;
	public static final int VOID_KW=35;
	public static final int WHILE_KW=36;
	public static final int WS=37;
	public static final int ARDECL=38;
	public static final int ARELEM=39;
	public static final int ARRAY=40;
	public static final int BLOCK=41;
	public static final int BODY=42;
	public static final int DECL=43;
	public static final int FCALL=44;
	public static final int FCALL_S=45;
	public static final int INST=46;
	public static final int PARAM=47;
	public static final int PROG=48;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public VSLTreeParser(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public VSLTreeParser(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return VSLTreeParser.tokenNames; }
	@Override public String getGrammarFileName() { return "VSLTreeParser.g"; }



	// $ANTLR start "program"
	// VSLTreeParser.g:10:1: program[SymbolTable symTab] returns [Code3a code] : ^( PROG (u= unit[symTab] )+ ) ;
	public final Code3a program(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a u =null;

		 
			code = new Code3a(); 

		try {
			// VSLTreeParser.g:15:5: ( ^( PROG (u= unit[symTab] )+ ) )
			// VSLTreeParser.g:16:5: ^( PROG (u= unit[symTab] )+ )
			{
			match(input,PROG,FOLLOW_PROG_in_program68); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:16:12: (u= unit[symTab] )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==FUNC_KW||LA1_0==PROTO_KW) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// VSLTreeParser.g:16:13: u= unit[symTab]
					{
					pushFollow(FOLLOW_unit_in_program73);
					u=unit(symTab);
					state._fsp--;

					 
					        code.append(u); 
					    
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "program"



	// $ANTLR start "unit"
	// VSLTreeParser.g:24:1: unit[SymbolTable symTab] returns [Code3a code] : ( (f= function[symTab] ) | (p= proto[symTab] ) );
	public final Code3a unit(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a f =null;
		Code3a p =null;

		try {
			// VSLTreeParser.g:25:2: ( (f= function[symTab] ) | (p= proto[symTab] ) )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==FUNC_KW) ) {
				alt2=1;
			}
			else if ( (LA2_0==PROTO_KW) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// VSLTreeParser.g:26:2: (f= function[symTab] )
					{
					// VSLTreeParser.g:26:2: (f= function[symTab] )
					// VSLTreeParser.g:26:3: f= function[symTab]
					{
					pushFollow(FOLLOW_function_in_unit110);
					f=function(symTab);
					state._fsp--;


							code = f; 
						
					}

					}
					break;
				case 2 :
					// VSLTreeParser.g:31:2: (p= proto[symTab] )
					{
					// VSLTreeParser.g:31:2: (p= proto[symTab] )
					// VSLTreeParser.g:31:3: p= proto[symTab]
					{
					pushFollow(FOLLOW_proto_in_unit126);
					p=proto(symTab);
					state._fsp--;


							code = p;
						
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "unit"



	// $ANTLR start "param"
	// VSLTreeParser.g:38:1: param[SymbolTable symTab] returns [VarSymbol vs] : ( IDENT | ^( ARRAY IDENT ) );
	public final VarSymbol param(SymbolTable symTab) throws RecognitionException {
		VarSymbol vs = null;


		CommonTree IDENT1=null;
		CommonTree IDENT2=null;

		try {
			// VSLTreeParser.g:39:2: ( IDENT | ^( ARRAY IDENT ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==IDENT) ) {
				alt3=1;
			}
			else if ( (LA3_0==ARRAY) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// VSLTreeParser.g:40:2: IDENT
					{
					IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param149); 

					        vs = TreeParserCode.newVarParam(symTab, (IDENT1!=null?IDENT1.getText():null));
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:45:5: ^( ARRAY IDENT )
					{
					match(input,ARRAY,FOLLOW_ARRAY_in_param168); 
					match(input, Token.DOWN, null); 
					IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param170); 
					match(input, Token.UP, null); 


					        vs = TreeParserCode.newArrayParam(symTab, (IDENT2!=null?IDENT2.getText():null));
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return vs;
	}
	// $ANTLR end "param"



	// $ANTLR start "param_list"
	// VSLTreeParser.g:51:1: param_list[SymbolTable symTab] returns [List<VarSymbol> list_vs] : ^( PARAM (p= param[symTab] )* ) ;
	public final List<VarSymbol> param_list(SymbolTable symTab) throws RecognitionException {
		List<VarSymbol> list_vs = null;


		VarSymbol p =null;

		 
			list_vs = new ArrayList<VarSymbol>(); 

		try {
			// VSLTreeParser.g:56:2: ( ^( PARAM (p= param[symTab] )* ) )
			// VSLTreeParser.g:57:2: ^( PARAM (p= param[symTab] )* )
			{
			match(input,PARAM,FOLLOW_PARAM_in_param_list201); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// VSLTreeParser.g:57:10: (p= param[symTab] )*
				loop4:
				while (true) {
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==IDENT||LA4_0==ARRAY) ) {
						alt4=1;
					}

					switch (alt4) {
					case 1 :
						// VSLTreeParser.g:57:11: p= param[symTab]
						{
						pushFollow(FOLLOW_param_in_param_list208);
						p=param(symTab);
						state._fsp--;

						 
							list_vs.add(p); 

						}
						break;

					default :
						break loop4;
					}
				}

				match(input, Token.UP, null); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return list_vs;
	}
	// $ANTLR end "param_list"



	// $ANTLR start "type"
	// VSLTreeParser.g:64:1: type returns [Type t] : ( INT_KW | VOID_KW );
	public final Type type() throws RecognitionException {
		Type t = null;


		try {
			// VSLTreeParser.g:65:2: ( INT_KW | VOID_KW )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==INT_KW) ) {
				alt5=1;
			}
			else if ( (LA5_0==VOID_KW) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// VSLTreeParser.g:66:2: INT_KW
					{
					match(input,INT_KW,FOLLOW_INT_KW_in_type231); 

						t = Type.INT;

					}
					break;
				case 2 :
					// VSLTreeParser.g:71:2: VOID_KW
					{
					match(input,VOID_KW,FOLLOW_VOID_KW_in_type240); 

						t = Type.VOID;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return t;
	}
	// $ANTLR end "type"



	// $ANTLR start "proto"
	// VSLTreeParser.g:77:1: proto[SymbolTable symTab] returns [Code3a code] : ^( PROTO_KW t= type IDENT params= param_list[symTab] ) ;
	public final Code3a proto(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT3=null;
		Type t =null;
		List<VarSymbol> params =null;

		try {
			// VSLTreeParser.g:78:5: ( ^( PROTO_KW t= type IDENT params= param_list[symTab] ) )
			// VSLTreeParser.g:79:5: ^( PROTO_KW t= type IDENT params= param_list[symTab] )
			{
			match(input,PROTO_KW,FOLLOW_PROTO_KW_in_proto263); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_proto267);
			t=type();
			state._fsp--;

			IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_proto269); 
			pushFollow(FOLLOW_param_list_in_proto273);
			params=param_list(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


			        code = TreeParserCode.newProto(symTab, t, (IDENT3!=null?IDENT3.getText():null), params);
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "proto"



	// $ANTLR start "function"
	// VSLTreeParser.g:85:1: function[SymbolTable symTab] returns [Code3a code] : ^( FUNC_KW returnType= type IDENT params= param_list[symTab] ^( BODY st= statement[symTab] ) ) ;
	public final Code3a function(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT4=null;
		Type returnType =null;
		List<VarSymbol> params =null;
		Code3a st =null;

		try {
			// VSLTreeParser.g:86:5: ( ^( FUNC_KW returnType= type IDENT params= param_list[symTab] ^( BODY st= statement[symTab] ) ) )
			// VSLTreeParser.g:87:5: ^( FUNC_KW returnType= type IDENT params= param_list[symTab] ^( BODY st= statement[symTab] ) )
			{
			match(input,FUNC_KW,FOLLOW_FUNC_KW_in_function301); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_function305);
			returnType=type();
			state._fsp--;

			IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function307); 
			pushFollow(FOLLOW_param_list_in_function311);
			params=param_list(symTab);
			state._fsp--;


			        Operand3a func = symTab.lookup((IDENT4!=null?IDENT4.getText():null));
			       
			       	if(func != null){
			        	FunctionType ft = (FunctionType)func.type;
			        	if(ft.prototype == false){
				            System.err.println("Fonction déjà définie");
				        } 
					}
					
			        LabelSymbol ls = new LabelSymbol((IDENT4!=null?IDENT4.getText():null));
			        FunctionType newFt = new FunctionType(returnType, false);
			        for (VarSymbol vs : params)
			        	newFt.extend(vs.type);
			        FunctionSymbol fs = new FunctionSymbol(ls, newFt);
			        symTab.insert((IDENT4!=null?IDENT4.getText():null), fs);
			        
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
			    
			match(input,BODY,FOLLOW_BODY_in_function326); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_statement_in_function330);
			st=statement(symTab);
			state._fsp--;

			 
			            code.append(st); 
			        
			match(input, Token.UP, null); 


			        symTab.leaveScope();
			        code.append(Code3aGenerator.genEndFunc());
			    
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "function"



	// $ANTLR start "statement"
	// VSLTreeParser.g:130:1: statement[SymbolTable symTab] returns [Code3a code] : ( ^( ASSIGN_KW e= expression[symTab] ( ( IDENT ) | (arrayElem= array_elem[symTab] ) ) ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pl= print_list[symTab] ) | ^( READ_KW rl= read_list[symTab] ) |b= block[symTab] | ^( RETURN_KW e= expression[symTab] ) | ^( FCALL_S IDENT (al= argument_list[symTab] )? ) );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT5=null;
		CommonTree IDENT6=null;
		ExpAttribute e =null;
		ArrayAttribute arrayElem =null;
		Code3a s1 =null;
		Code3a s2 =null;
		Code3a st =null;
		Code3a pl =null;
		Code3a rl =null;
		Code3a b =null;
		TreeRuleReturnScope al =null;

		try {
			// VSLTreeParser.g:131:5: ( ^( ASSIGN_KW e= expression[symTab] ( ( IDENT ) | (arrayElem= array_elem[symTab] ) ) ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pl= print_list[symTab] ) | ^( READ_KW rl= read_list[symTab] ) |b= block[symTab] | ^( RETURN_KW e= expression[symTab] ) | ^( FCALL_S IDENT (al= argument_list[symTab] )? ) )
			int alt9=8;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt9=1;
				}
				break;
			case IF_KW:
				{
				alt9=2;
				}
				break;
			case WHILE_KW:
				{
				alt9=3;
				}
				break;
			case PRINT_KW:
				{
				alt9=4;
				}
				break;
			case READ_KW:
				{
				alt9=5;
				}
				break;
			case BLOCK:
				{
				alt9=6;
				}
				break;
			case RETURN_KW:
				{
				alt9=7;
				}
				break;
			case FCALL_S:
				{
				alt9=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// VSLTreeParser.g:132:5: ^( ASSIGN_KW e= expression[symTab] ( ( IDENT ) | (arrayElem= array_elem[symTab] ) ) )
					{
					match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement380); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement384);
					e=expression(symTab);
					state._fsp--;

					// VSLTreeParser.g:132:38: ( ( IDENT ) | (arrayElem= array_elem[symTab] ) )
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==IDENT) ) {
						alt6=1;
					}
					else if ( (LA6_0==ARELEM) ) {
						alt6=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 6, 0, input);
						throw nvae;
					}

					switch (alt6) {
						case 1 :
							// VSLTreeParser.g:133:5: ( IDENT )
							{
							// VSLTreeParser.g:133:5: ( IDENT )
							// VSLTreeParser.g:133:7: IDENT
							{
							IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement395); 

								        Operand3a id = symTab.lookup((IDENT5!=null?IDENT5.getText():null));
								        if (id != null) {
								            code = e.code;
								            code.append(new Code3a(new Inst3a(Inst3a.TAC.COPY, id, e.place, null)));
								        }
								        else {
								            System.err.println("Error: variable \"" + (IDENT5!=null?IDENT5.getText():null) + "\" is not declared.");
								        }
								    
							}

							}
							break;
						case 2 :
							// VSLTreeParser.g:146:2: (arrayElem= array_elem[symTab] )
							{
							// VSLTreeParser.g:146:2: (arrayElem= array_elem[symTab] )
							// VSLTreeParser.g:147:3: arrayElem= array_elem[symTab]
							{
							pushFollow(FOLLOW_array_elem_in_statement421);
							arrayElem=array_elem(symTab);
							state._fsp--;

							}


										code = e.code;
										code.append(Code3aGenerator.genVarTab(arrayElem, e));
									
							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// VSLTreeParser.g:155:5: ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement444); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement449);
					e=expression(symTab);
					state._fsp--;


					        LabelSymbol l_else = SymbDistrib.newLabel();
					        LabelSymbol l_fin = SymbDistrib.newLabel();
					        code = Code3aGenerator.genIfZ(e, l_else);
					    
					pushFollow(FOLLOW_statement_in_statement471);
					s1=statement(symTab);
					state._fsp--;


					        code.append(s1);
					        code.append(Code3aGenerator.genGoTo(l_fin));
					        code.append(Code3aGenerator.genLabel(l_else));
					    
					// VSLTreeParser.g:167:9: (s2= statement[symTab] )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==ASSIGN_KW||LA7_0==IF_KW||LA7_0==PRINT_KW||(LA7_0 >= READ_KW && LA7_0 <= RETURN_KW)||LA7_0==WHILE_KW||LA7_0==BLOCK||LA7_0==FCALL_S) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// VSLTreeParser.g:167:10: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement493);
							s2=statement(symTab);
							state._fsp--;


							            code.append(s2);
							        
							}
							break;

					}


					        code.append(Code3aGenerator.genLabel(l_fin));
					    
					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// VSLTreeParser.g:177:5: ^( WHILE_KW e= expression[symTab] st= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement537); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement543);
					e=expression(symTab);
					state._fsp--;


					        LabelSymbol l_deb = SymbDistrib.newLabel();
					        LabelSymbol l_fin = SymbDistrib.newLabel();
					        code = (Code3aGenerator.genLabel(l_deb));
					        code.append(Code3aGenerator.genIfZ(e, l_fin));
					    
					pushFollow(FOLLOW_statement_in_statement564);
					st=statement(symTab);
					state._fsp--;


					        code.append(st);
					        code.append(Code3aGenerator.genGoTo(l_deb));
					        code.append(Code3aGenerator.genLabel(l_fin));
					    
					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// VSLTreeParser.g:192:2: ^( PRINT_KW pl= print_list[symTab] )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement583); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_print_list_in_statement589);
					pl=print_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


							code = pl;
						
					}
					break;
				case 5 :
					// VSLTreeParser.g:197:2: ^( READ_KW rl= read_list[symTab] )
					{
					match(input,READ_KW,FOLLOW_READ_KW_in_statement600); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_read_list_in_statement606);
					rl=read_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


							code = rl;
						
					}
					break;
				case 6 :
					// VSLTreeParser.g:202:5: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement621);
					b=block(symTab);
					state._fsp--;


					        code = b;
					    
					}
					break;
				case 7 :
					// VSLTreeParser.g:206:5: ^( RETURN_KW e= expression[symTab] )
					{
					match(input,RETURN_KW,FOLLOW_RETURN_KW_in_statement636); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement642);
					e=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        code = e.code;
					        code.append(new Inst3a(Inst3a.TAC.RETURN, e.place, null, null));
					    
					}
					break;
				case 8 :
					// VSLTreeParser.g:212:5: ^( FCALL_S IDENT (al= argument_list[symTab] )? )
					{
					match(input,FCALL_S,FOLLOW_FCALL_S_in_statement660); 
					match(input, Token.DOWN, null); 
					IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement662); 
					// VSLTreeParser.g:212:21: (al= argument_list[symTab] )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==DIV||LA8_0==IDENT||LA8_0==INTEGER||(LA8_0 >= MINUS && LA8_0 <= MUL)||LA8_0==PLUS||LA8_0==ARELEM||LA8_0==FCALL) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// VSLTreeParser.g:212:22: al= argument_list[symTab]
							{
							pushFollow(FOLLOW_argument_list_in_statement667);
							al=argument_list(symTab);
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					        Operand3a o = symTab.lookup((IDENT6!=null?IDENT6.getText():null));
					        if (o != null) {
					            List<Type> expectedArgs = ((FunctionType) o.type).getArguments();
					            if (   (al == null && expectedArgs == null) 
					                || (al == null && expectedArgs.size() == 0)
					                || (expectedArgs.size() == (al!=null?((VSLTreeParser.argument_list_return)al).args:null).size())){
					                // todo verifier le type des arguments
					                Type ty = o.type;
					                code = new Code3a();
					                code.append((al!=null?((VSLTreeParser.argument_list_return)al).code:null));
					                code.append(new Inst3a(Inst3a.TAC.CALL, null, o, null));
					            }
					            else {
					                System.err.println("Error: incompatible with the function " + (IDENT6!=null?IDENT6.getText():null) + ".");
					                System.exit(-1);
					            }
					        }
					        else {
					            System.err.println("Error: function " + (IDENT6!=null?IDENT6.getText():null) + " is not declared.");
					            System.exit(-1);
					        }
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "statement"



	// $ANTLR start "block"
	// VSLTreeParser.g:238:1: block[SymbolTable symTab] returns [Code3a code] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a d =null;
		Code3a il =null;

		try {
			// VSLTreeParser.g:239:5: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==BLOCK) ) {
				int LA10_1 = input.LA(2);
				if ( (LA10_1==DOWN) ) {
					int LA10_2 = input.LA(3);
					if ( (LA10_2==DECL) ) {
						alt10=1;
					}
					else if ( (LA10_2==INST) ) {
						alt10=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 10, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// VSLTreeParser.g:240:5: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block698); 

					        symTab.enterScope();
					    
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block717);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block722);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        code = d;
					        code.append(il);
					        symTab.leaveScope();
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:251:5: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block741); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block745);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        code = il;
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "block"



	// $ANTLR start "inst_list"
	// VSLTreeParser.g:257:1: inst_list[SymbolTable symTab] returns [Code3a code] : ^( INST (st= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a st =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:262:5: ( ^( INST (st= statement[symTab] )+ ) )
			// VSLTreeParser.g:263:5: ^( INST (st= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list780); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:263:12: (st= statement[symTab] )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==ASSIGN_KW||LA11_0==IF_KW||LA11_0==PRINT_KW||(LA11_0 >= READ_KW && LA11_0 <= RETURN_KW)||LA11_0==WHILE_KW||LA11_0==BLOCK||LA11_0==FCALL_S) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// VSLTreeParser.g:263:13: st= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list785);
					st=statement(symTab);
					state._fsp--;


					        code.append(st);
					    
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "inst_list"



	// $ANTLR start "expression"
	// VSLTreeParser.g:270:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// VSLTreeParser.g:271:5: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt12=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt12=1;
				}
				break;
			case MINUS:
				{
				alt12=2;
				}
				break;
			case MUL:
				{
				alt12=3;
				}
				break;
			case DIV:
				{
				alt12=4;
				}
				break;
			case IDENT:
			case INTEGER:
			case ARELEM:
			case FCALL:
				{
				alt12=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// VSLTreeParser.g:272:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression822); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression828);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression835);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					        Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a code = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, e1, e2, temp);
					        expAtt = new ExpAttribute(ty, code, temp);
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:280:5: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression853); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression859);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression866);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					        Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a code = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, e1, e2, temp);
					        expAtt = new ExpAttribute(ty, code, temp);
					    
					}
					break;
				case 3 :
					// VSLTreeParser.g:288:5: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression884); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression890);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression897);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					        Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a code = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, e1, e2, temp);
					        expAtt = new ExpAttribute(ty, code, temp);
					    
					}
					break;
				case 4 :
					// VSLTreeParser.g:296:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression915); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression921);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression928);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					        Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a code = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, e1, e2, temp);
					        expAtt = new ExpAttribute(ty, code, temp);
					    
					}
					break;
				case 5 :
					// VSLTreeParser.g:304:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression950);
					pe=primary_exp(symTab);
					state._fsp--;

					 
					        expAtt = pe; 
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "expression"



	// $ANTLR start "array_elem"
	// VSLTreeParser.g:310:1: array_elem[SymbolTable symTab] returns [ArrayAttribute arrAtt] : ^( ARELEM IDENT e= expression[symTab] ) ;
	public final ArrayAttribute array_elem(SymbolTable symTab) throws RecognitionException {
		ArrayAttribute arrAtt = null;


		CommonTree IDENT7=null;
		ExpAttribute e =null;

		try {
			// VSLTreeParser.g:311:2: ( ^( ARELEM IDENT e= expression[symTab] ) )
			// VSLTreeParser.g:312:2: ^( ARELEM IDENT e= expression[symTab] )
			{
			match(input,ARELEM,FOLLOW_ARELEM_in_array_elem975); 
			match(input, Token.DOWN, null); 
			IDENT7=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_array_elem978); 
			pushFollow(FOLLOW_expression_in_array_elem982);
			e=expression(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


					arrAtt = TreeParserCode.newArrayElem(symTab, (IDENT7!=null?IDENT7.getText():null), e);
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return arrAtt;
	}
	// $ANTLR end "array_elem"



	// $ANTLR start "primary_exp"
	// VSLTreeParser.g:318:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT |a= array_elem[symTab] | ^( FCALL IDENT (al= argument_list[symTab] )? ) );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER8=null;
		CommonTree IDENT9=null;
		CommonTree IDENT10=null;
		ArrayAttribute a =null;
		TreeRuleReturnScope al =null;

		try {
			// VSLTreeParser.g:319:5: ( INTEGER | IDENT |a= array_elem[symTab] | ^( FCALL IDENT (al= argument_list[symTab] )? ) )
			int alt14=4;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt14=1;
				}
				break;
			case IDENT:
				{
				alt14=2;
				}
				break;
			case ARELEM:
				{
				alt14=3;
				}
				break;
			case FCALL:
				{
				alt14=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// VSLTreeParser.g:320:5: INTEGER
					{
					INTEGER8=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp1008); 

					        ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER8!=null?INTEGER8.getText():null)));
					        expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:326:5: IDENT
					{
					IDENT9=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp1023); 

					        Operand3a o = symTab.lookup((IDENT9!=null?IDENT9.getText():null));
					        if(o == null){
					           System.err.println("Error: variable \"" + (IDENT9!=null?IDENT9.getText():null) + "\" is not declared.");
					        }
					        expAtt = new ExpAttribute(o.type, new Code3a(), symTab.lookup((IDENT9!=null?IDENT9.getText():null)));
					    
					}
					break;
				case 3 :
					// VSLTreeParser.g:335:2: a= array_elem[symTab]
					{
					pushFollow(FOLLOW_array_elem_in_primary_exp1038);
					a=array_elem(symTab);
					state._fsp--;


							expAtt = a.exp;
						
					}
					break;
				case 4 :
					// VSLTreeParser.g:340:5: ^( FCALL IDENT (al= argument_list[symTab] )? )
					{
					match(input,FCALL,FOLLOW_FCALL_in_primary_exp1052); 
					match(input, Token.DOWN, null); 
					IDENT10=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp1054); 
					// VSLTreeParser.g:340:19: (al= argument_list[symTab] )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==DIV||LA13_0==IDENT||LA13_0==INTEGER||(LA13_0 >= MINUS && LA13_0 <= MUL)||LA13_0==PLUS||LA13_0==ARELEM||LA13_0==FCALL) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// VSLTreeParser.g:340:20: al= argument_list[symTab]
							{
							pushFollow(FOLLOW_argument_list_in_primary_exp1059);
							al=argument_list(symTab);
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					        Operand3a o = symTab.lookup((IDENT10!=null?IDENT10.getText():null));
					        if (o != null) {
					            if(((FunctionType)o.type).getReturnType() == Type.VOID){
					                System.err.println("Error: VOID function cannot be used in primary_exp.");
					                System.exit(-1);
					            }
					            List<Type> expectedArgs = ((FunctionType) o.type).getArguments();
					            if (   (al == null && expectedArgs == null) 
					                || (al == null && expectedArgs.size() == 0)
					                || (expectedArgs.size() == (al!=null?((VSLTreeParser.argument_list_return)al).args:null).size())){
					                // todo verifier le type des arguments
					                Type ty = o.type;
					                VarSymbol temp = SymbDistrib.newTemp();
					                Code3a code = new Code3a();
					                code.append((al!=null?((VSLTreeParser.argument_list_return)al).code:null));
					                code.append(new Inst3a(Inst3a.TAC.CALL, temp, o, null));
					                expAtt = new ExpAttribute(ty, code, temp);
					            }
					            else {
					                System.err.println("Error: incompatible with the function " + (IDENT10!=null?IDENT10.getText():null) + ".");
					                System.exit(-1);
					            }
					        }
					        else {
					            System.err.println("Error: function " + (IDENT10!=null?IDENT10.getText():null) + " is not declared.");
					            System.exit(-1);
					        }
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "primary_exp"


	public static class argument_list_return extends TreeRuleReturnScope {
		public Code3a code;
		public List<Type> args;
	};


	// $ANTLR start "argument_list"
	// VSLTreeParser.g:372:1: argument_list[SymbolTable symTab] returns [Code3a code, List<Type> args] : (e= expression[symTab] )+ ;
	public final VSLTreeParser.argument_list_return argument_list(SymbolTable symTab) throws RecognitionException {
		VSLTreeParser.argument_list_return retval = new VSLTreeParser.argument_list_return();
		retval.start = input.LT(1);

		ExpAttribute e =null;


		    retval.code = new Code3a();
		    retval.args = new ArrayList<Type>(); // Le type précisé ici ne sera pas pris en compte

		try {
			// VSLTreeParser.g:378:5: ( (e= expression[symTab] )+ )
			// VSLTreeParser.g:378:5: (e= expression[symTab] )+
			{
			// VSLTreeParser.g:378:5: (e= expression[symTab] )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==DIV||LA15_0==IDENT||LA15_0==INTEGER||(LA15_0 >= MINUS && LA15_0 <= MUL)||LA15_0==PLUS||LA15_0==ARELEM||LA15_0==FCALL) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// VSLTreeParser.g:378:6: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_argument_list1093);
					e=expression(symTab);
					state._fsp--;


					        retval.args.add(Type.INT);
					        retval.code.append(e.code);
					        retval.code.append(Code3aGenerator.genArg(e.place));
					    
					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "argument_list"



	// $ANTLR start "declaration"
	// VSLTreeParser.g:387:1: declaration[SymbolTable symTab] returns [Code3a code] : ^( DECL (dl= decl_list[symTab] ) ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a dl =null;

		try {
			// VSLTreeParser.g:388:5: ( ^( DECL (dl= decl_list[symTab] ) ) )
			// VSLTreeParser.g:389:5: ^( DECL (dl= decl_list[symTab] ) )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration1128); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:389:12: (dl= decl_list[symTab] )
			// VSLTreeParser.g:389:13: dl= decl_list[symTab]
			{
			pushFollow(FOLLOW_decl_list_in_declaration1135);
			dl=decl_list(symTab);
			state._fsp--;


					code = dl;
				
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "declaration"



	// $ANTLR start "decl_list"
	// VSLTreeParser.g:395:1: decl_list[SymbolTable symTab] returns [Code3a code] : (di= decl_item[symTab] )+ ;
	public final Code3a decl_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a di =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:400:5: ( (di= decl_item[symTab] )+ )
			// VSLTreeParser.g:401:5: (di= decl_item[symTab] )+
			{
			// VSLTreeParser.g:401:5: (di= decl_item[symTab] )+
			int cnt16=0;
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==IDENT||LA16_0==ARDECL) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// VSLTreeParser.g:401:6: di= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_decl_list1174);
					di=decl_item(symTab);
					state._fsp--;


							code.append(di);
						
					}
					break;

				default :
					if ( cnt16 >= 1 ) break loop16;
					EarlyExitException eee = new EarlyExitException(16, input);
					throw eee;
				}
				cnt16++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "decl_list"



	// $ANTLR start "decl_item"
	// VSLTreeParser.g:408:1: decl_item[SymbolTable symTab] returns [Code3a code] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT11=null;
		CommonTree IDENT12=null;
		CommonTree INTEGER13=null;

		try {
			// VSLTreeParser.g:409:5: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==IDENT) ) {
				alt17=1;
			}
			else if ( (LA17_0==ARDECL) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// VSLTreeParser.g:410:5: IDENT
					{
					IDENT11=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1205); 

							Operand3a o = symTab.lookup((IDENT11!=null?IDENT11.getText():null));
							int currentScope = symTab.getScope();
							if (o != null && o.getScope() == currentScope){
								System.err.println("Error: \"" + (IDENT11!=null?IDENT11.getText():null) + "\" is already declared.");
							} else {
								VarSymbol vs = new VarSymbol(Type.INT, (IDENT11!=null?IDENT11.getText():null), symTab.getScope());
								symTab.insert((IDENT11!=null?IDENT11.getText():null), vs);
								code = Code3aGenerator.genVar(vs);
							}
						
					}
					break;
				case 2 :
					// VSLTreeParser.g:423:5: ^( ARDECL IDENT INTEGER )
					{
					match(input,ARDECL,FOLLOW_ARDECL_in_decl_item1218); 
					match(input, Token.DOWN, null); 
					IDENT12=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1220); 
					INTEGER13=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item1222); 
					match(input, Token.UP, null); 


							Operand3a o = symTab.lookup((IDENT12!=null?IDENT12.getText():null));
							int currentScope = symTab.getScope();
							if (o != null && o.getScope() == currentScope){
								System.err.println("Error: variable \"" + (IDENT12!=null?IDENT12.getText():null) + "\" is already declared.");
							} else {
								ArrayType at = new ArrayType(Type.INT, Integer.parseInt((INTEGER13!=null?INTEGER13.getText():null)));
								VarSymbol vs = new VarSymbol(at, (IDENT12!=null?IDENT12.getText():null), symTab.getScope());
								symTab.insert((IDENT12!=null?IDENT12.getText():null), vs);
								code = Code3aGenerator.genVar(vs);
							}
						
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "decl_item"



	// $ANTLR start "print_list"
	// VSLTreeParser.g:439:1: print_list[SymbolTable symTab] returns [Code3a code] : (pi= print_item[symTab] )+ ;
	public final Code3a print_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a pi =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:444:5: ( (pi= print_item[symTab] )+ )
			// VSLTreeParser.g:445:5: (pi= print_item[symTab] )+
			{
			// VSLTreeParser.g:445:5: (pi= print_item[symTab] )+
			int cnt18=0;
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==DIV||LA18_0==IDENT||LA18_0==INTEGER||(LA18_0 >= MINUS && LA18_0 <= MUL)||LA18_0==PLUS||LA18_0==TEXT||LA18_0==ARELEM||LA18_0==FCALL) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// VSLTreeParser.g:445:6: pi= print_item[symTab]
					{
					pushFollow(FOLLOW_print_item_in_print_list1257);
					pi=print_item(symTab);
					state._fsp--;


							code.append(pi);
						
					}
					break;

				default :
					if ( cnt18 >= 1 ) break loop18;
					EarlyExitException eee = new EarlyExitException(18, input);
					throw eee;
				}
				cnt18++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "print_list"



	// $ANTLR start "print_item"
	// VSLTreeParser.g:452:1: print_item[SymbolTable symTab] returns [Code3a code] : ( TEXT |e= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree TEXT14=null;
		ExpAttribute e =null;

		try {
			// VSLTreeParser.g:453:2: ( TEXT |e= expression[symTab] )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==TEXT) ) {
				alt19=1;
			}
			else if ( (LA19_0==DIV||LA19_0==IDENT||LA19_0==INTEGER||(LA19_0 >= MINUS && LA19_0 <= MUL)||LA19_0==PLUS||LA19_0==ARELEM||LA19_0==FCALL) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// VSLTreeParser.g:454:2: TEXT
					{
					TEXT14=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item1284); 

							LabelSymbol ls = SymbDistrib.builtinPrintS;
							Data3a data = new Data3a((TEXT14!=null?TEXT14.getText():null));
							code = Code3aGenerator.genArg(data.getLabel());
							code.appendData(data);
							code.append(Code3aGenerator.genCall(ls));
						
					}
					break;
				case 2 :
					// VSLTreeParser.g:463:2: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item1297);
					e=expression(symTab);
					state._fsp--;


							LabelSymbol ls = SymbDistrib.builtinPrintN;
							code = e.code;
							code.append(Code3aGenerator.genArg(e.place));
							code.append(Code3aGenerator.genCall(ls));
						
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "print_item"



	// $ANTLR start "read_list"
	// VSLTreeParser.g:472:1: read_list[SymbolTable symTab] returns [Code3a code] : (ri= read_item[symTab] )+ ;
	public final Code3a read_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a ri =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:477:5: ( (ri= read_item[symTab] )+ )
			// VSLTreeParser.g:478:5: (ri= read_item[symTab] )+
			{
			// VSLTreeParser.g:478:5: (ri= read_item[symTab] )+
			int cnt20=0;
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==IDENT) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// VSLTreeParser.g:478:6: ri= read_item[symTab]
					{
					pushFollow(FOLLOW_read_item_in_read_list1331);
					ri=read_item(symTab);
					state._fsp--;


							code.append(ri);
						
					}
					break;

				default :
					if ( cnt20 >= 1 ) break loop20;
					EarlyExitException eee = new EarlyExitException(20, input);
					throw eee;
				}
				cnt20++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "read_list"



	// $ANTLR start "read_item"
	// VSLTreeParser.g:485:1: read_item[SymbolTable symTab] returns [Code3a code] : IDENT ;
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT15=null;

		try {
			// VSLTreeParser.g:486:2: ( IDENT )
			// VSLTreeParser.g:487:2: IDENT
			{
			IDENT15=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item1358); 

					Operand3a o = symTab.lookup((IDENT15!=null?IDENT15.getText():null));
					if(o == null){
						System.err.println("Error: variable \"" + (IDENT15!=null?IDENT15.getText():null) + "\" is not declared.");
					}else {
						LabelSymbol ls = SymbDistrib.builtinRead;
						code = Code3aGenerator.genCallReturn(o, ls);
					}
				
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "read_item"

	// Delegated rules



	public static final BitSet FOLLOW_PROG_in_program68 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_unit_in_program73 = new BitSet(new long[]{0x0000000008002008L});
	public static final BitSet FOLLOW_function_in_unit110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_proto_in_unit126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_param149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_param168 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_param170 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PARAM_in_param_list201 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_param_list208 = new BitSet(new long[]{0x0000010000004008L});
	public static final BitSet FOLLOW_INT_KW_in_type231 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KW_in_type240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROTO_KW_in_proto263 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_proto267 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_proto269 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_param_list_in_proto273 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_KW_in_function301 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_function305 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_function307 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_param_list_in_function311 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_BODY_in_function326 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_function330 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement380 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement384 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement395 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_array_elem_in_statement421 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_KW_in_statement444 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement449 = new BitSet(new long[]{0x00002210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement471 = new BitSet(new long[]{0x00002210C4008028L});
	public static final BitSet FOLLOW_statement_in_statement493 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement537 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement543 = new BitSet(new long[]{0x00002210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement564 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement583 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_list_in_statement589 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_KW_in_statement600 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_list_in_statement606 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KW_in_statement636 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement642 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FCALL_S_in_statement660 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_statement662 = new BitSet(new long[]{0x0000108002C14208L});
	public static final BitSet FOLLOW_argument_list_in_statement667 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block698 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block717 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block722 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block741 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block745 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list780 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list785 = new BitSet(new long[]{0x00002210C4008028L});
	public static final BitSet FOLLOW_PLUS_in_expression822 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression828 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression835 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression853 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression859 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression866 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression884 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression890 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression897 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression915 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression921 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression928 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression950 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARELEM_in_array_elem975 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_array_elem978 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_array_elem982 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp1008 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp1023 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_elem_in_primary_exp1038 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FCALL_in_primary_exp1052 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp1054 = new BitSet(new long[]{0x0000108002C14208L});
	public static final BitSet FOLLOW_argument_list_in_primary_exp1059 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_expression_in_argument_list1093 = new BitSet(new long[]{0x0000108002C14202L});
	public static final BitSet FOLLOW_DECL_in_declaration1128 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_list_in_declaration1135 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_decl_item_in_decl_list1174 = new BitSet(new long[]{0x0000004000004002L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1205 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item1218 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1220 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item1222 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_print_item_in_print_list1257 = new BitSet(new long[]{0x0000108202C14202L});
	public static final BitSet FOLLOW_TEXT_in_print_item1284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item1297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_item_in_read_list1331 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_IDENT_in_read_item1358 = new BitSet(new long[]{0x0000000000000002L});
}
