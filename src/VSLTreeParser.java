// $ANTLR 3.5.2 VSLTreeParser.g 2014-11-28 13:22:57

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



	// $ANTLR start "s"
	// VSLTreeParser.g:10:1: s[SymbolTable symTab] returns [Code3a code] : st= statement[symTab] ;
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a st =null;

		try {
			// VSLTreeParser.g:11:5: (st= statement[symTab] )
			// VSLTreeParser.g:12:5: st= statement[symTab]
			{
			pushFollow(FOLLOW_statement_in_s63);
			st=statement(symTab);
			state._fsp--;

			 
			        code = st; 
			    
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
	// $ANTLR end "s"



	// $ANTLR start "param"
	// VSLTreeParser.g:19:1: param[SymbolTable symTab] returns [VarSymbol vs] : ( IDENT | ^( ARRAY IDENT ) );
	public final VarSymbol param(SymbolTable symTab) throws RecognitionException {
		VarSymbol vs = null;


		CommonTree IDENT1=null;
		CommonTree IDENT2=null;

		try {
			// VSLTreeParser.g:20:2: ( IDENT | ^( ARRAY IDENT ) )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==IDENT) ) {
				alt1=1;
			}
			else if ( (LA1_0==ARRAY) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// VSLTreeParser.g:21:2: IDENT
					{
					IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param89); 

					        vs = TreeParserCode.newVarParam(symTab, (IDENT1!=null?IDENT1.getText():null));
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:26:5: ^( ARRAY IDENT )
					{
					match(input,ARRAY,FOLLOW_ARRAY_in_param108); 
					match(input, Token.DOWN, null); 
					IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param110); 
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
	// VSLTreeParser.g:32:1: param_list[SymbolTable symTab] returns [List<VarSymbol> list_vs] : ^( PARAM (p= param[symTab] )* ) ;
	public final List<VarSymbol> param_list(SymbolTable symTab) throws RecognitionException {
		List<VarSymbol> list_vs = null;


		VarSymbol p =null;

		 
			list_vs = new ArrayList<VarSymbol>(); 

		try {
			// VSLTreeParser.g:37:2: ( ^( PARAM (p= param[symTab] )* ) )
			// VSLTreeParser.g:38:2: ^( PARAM (p= param[symTab] )* )
			{
			match(input,PARAM,FOLLOW_PARAM_in_param_list141); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// VSLTreeParser.g:38:10: (p= param[symTab] )*
				loop2:
				while (true) {
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==IDENT||LA2_0==ARRAY) ) {
						alt2=1;
					}

					switch (alt2) {
					case 1 :
						// VSLTreeParser.g:38:11: p= param[symTab]
						{
						pushFollow(FOLLOW_param_in_param_list148);
						p=param(symTab);
						state._fsp--;

						 
							list_vs.add(p); 

						}
						break;

					default :
						break loop2;
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
	// VSLTreeParser.g:45:1: type returns [Type t] : ( INT_KW | VOID_KW );
	public final Type type() throws RecognitionException {
		Type t = null;


		try {
			// VSLTreeParser.g:46:2: ( INT_KW | VOID_KW )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==INT_KW) ) {
				alt3=1;
			}
			else if ( (LA3_0==VOID_KW) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// VSLTreeParser.g:47:2: INT_KW
					{
					match(input,INT_KW,FOLLOW_INT_KW_in_type171); 

						t = Type.INT;

					}
					break;
				case 2 :
					// VSLTreeParser.g:52:2: VOID_KW
					{
					match(input,VOID_KW,FOLLOW_VOID_KW_in_type180); 

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
	// VSLTreeParser.g:58:1: proto[SymbolTable symTab] returns [Code3a code] : ^( PROTO_KW t= type IDENT params= param_list[symTab] ) ;
	public final Code3a proto(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT3=null;
		Type t =null;
		List<VarSymbol> params =null;

		try {
			// VSLTreeParser.g:59:5: ( ^( PROTO_KW t= type IDENT params= param_list[symTab] ) )
			// VSLTreeParser.g:60:5: ^( PROTO_KW t= type IDENT params= param_list[symTab] )
			{
			match(input,PROTO_KW,FOLLOW_PROTO_KW_in_proto203); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_proto207);
			t=type();
			state._fsp--;

			IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_proto209); 
			pushFollow(FOLLOW_param_list_in_proto213);
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
	// VSLTreeParser.g:66:1: function[SymbolTable symTab] returns [Code3a code] : ^( FUNC_KW returnType= type IDENT params= param_list[symTab] ^( BODY st= statement[symTab] ) ) ;
	public final Code3a function(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT4=null;
		Type returnType =null;
		List<VarSymbol> params =null;
		Code3a st =null;

		try {
			// VSLTreeParser.g:67:5: ( ^( FUNC_KW returnType= type IDENT params= param_list[symTab] ^( BODY st= statement[symTab] ) ) )
			// VSLTreeParser.g:68:5: ^( FUNC_KW returnType= type IDENT params= param_list[symTab] ^( BODY st= statement[symTab] ) )
			{
			match(input,FUNC_KW,FOLLOW_FUNC_KW_in_function241); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_function245);
			returnType=type();
			state._fsp--;

			IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function247); 
			pushFollow(FOLLOW_param_list_in_function251);
			params=param_list(symTab);
			state._fsp--;

			match(input,BODY,FOLLOW_BODY_in_function255); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_statement_in_function259);
			st=statement(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


			        Operand3a func = symTab.lookup((IDENT4!=null?IDENT4.getText():null));
			        if(func == null){
			            // todo
			            System.err.println("pas de proto défini");
			        }else {
			            FunctionType ft = (FunctionType)func.type;

			            if(ft.prototype == false){
			                System.err.println("Fonction déjà définie");
			            }else{
			                LabelSymbol ls = new LabelSymbol((IDENT4!=null?IDENT4.getText():null));
			                FunctionType newFt = new FunctionType(returnType, false);
			                for (VarSymbol vs : params)
			                    newFt.extend(vs.type);
			                FunctionSymbol fs = new FunctionSymbol(ls, newFt);
			                func = fs;
			            }
			        }
			        code = Code3aGenerator.genLabel((LabelSymbol)func);
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

			        code.append(st);
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
	// VSLTreeParser.g:109:1: statement[SymbolTable symTab] returns [Code3a code] : ( ^( ASSIGN_KW e= expression[symTab] ( ( IDENT ) | (arrayElem= array_elem[symTab] ) ) ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pl= print_list[symTab] ) | ^( READ_KW rl= read_list[symTab] ) |b= block[symTab] );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT5=null;
		ExpAttribute e =null;
		ArrayAttribute arrayElem =null;
		Code3a s1 =null;
		Code3a s2 =null;
		Code3a st =null;
		Code3a pl =null;
		Code3a rl =null;
		Code3a b =null;

		try {
			// VSLTreeParser.g:110:5: ( ^( ASSIGN_KW e= expression[symTab] ( ( IDENT ) | (arrayElem= array_elem[symTab] ) ) ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pl= print_list[symTab] ) | ^( READ_KW rl= read_list[symTab] ) |b= block[symTab] )
			int alt6=6;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt6=1;
				}
				break;
			case IF_KW:
				{
				alt6=2;
				}
				break;
			case WHILE_KW:
				{
				alt6=3;
				}
				break;
			case PRINT_KW:
				{
				alt6=4;
				}
				break;
			case READ_KW:
				{
				alt6=5;
				}
				break;
			case BLOCK:
				{
				alt6=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// VSLTreeParser.g:111:5: ^( ASSIGN_KW e= expression[symTab] ( ( IDENT ) | (arrayElem= array_elem[symTab] ) ) )
					{
					match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement293); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement297);
					e=expression(symTab);
					state._fsp--;

					// VSLTreeParser.g:111:38: ( ( IDENT ) | (arrayElem= array_elem[symTab] ) )
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==IDENT) ) {
						alt4=1;
					}
					else if ( (LA4_0==ARELEM) ) {
						alt4=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 4, 0, input);
						throw nvae;
					}

					switch (alt4) {
						case 1 :
							// VSLTreeParser.g:112:5: ( IDENT )
							{
							// VSLTreeParser.g:112:5: ( IDENT )
							// VSLTreeParser.g:112:7: IDENT
							{
							IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement308); 

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
							// VSLTreeParser.g:125:2: (arrayElem= array_elem[symTab] )
							{
							// VSLTreeParser.g:125:2: (arrayElem= array_elem[symTab] )
							// VSLTreeParser.g:126:3: arrayElem= array_elem[symTab]
							{
							pushFollow(FOLLOW_array_elem_in_statement334);
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
					// VSLTreeParser.g:134:5: ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement357); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement362);
					e=expression(symTab);
					state._fsp--;


					        LabelSymbol l_else = SymbDistrib.newLabel();
					        LabelSymbol l_fin = SymbDistrib.newLabel();
					        code = Code3aGenerator.genIfZ(e, l_else);
					    
					pushFollow(FOLLOW_statement_in_statement384);
					s1=statement(symTab);
					state._fsp--;


					        code.append(s1);
					        code.append(Code3aGenerator.genGoTo(l_fin));
					        code.append(Code3aGenerator.genLabel(l_else));
					    
					// VSLTreeParser.g:146:9: (s2= statement[symTab] )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==ASSIGN_KW||LA5_0==IF_KW||LA5_0==PRINT_KW||LA5_0==READ_KW||LA5_0==WHILE_KW||LA5_0==BLOCK) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// VSLTreeParser.g:146:10: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement406);
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
					// VSLTreeParser.g:156:5: ^( WHILE_KW e= expression[symTab] st= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement452); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement458);
					e=expression(symTab);
					state._fsp--;


					        LabelSymbol l_deb = SymbDistrib.newLabel();
					        LabelSymbol l_fin = SymbDistrib.newLabel();
					        code = (Code3aGenerator.genLabel(l_deb));
					        code.append(Code3aGenerator.genIfZ(e, l_fin));
					    
					pushFollow(FOLLOW_statement_in_statement479);
					st=statement(symTab);
					state._fsp--;


					        code.append(st);
					        code.append(Code3aGenerator.genGoTo(l_deb));
					        code.append(Code3aGenerator.genLabel(l_fin));
					    
					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// VSLTreeParser.g:171:2: ^( PRINT_KW pl= print_list[symTab] )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement498); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_print_list_in_statement504);
					pl=print_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


							code = pl;
						
					}
					break;
				case 5 :
					// VSLTreeParser.g:176:2: ^( READ_KW rl= read_list[symTab] )
					{
					match(input,READ_KW,FOLLOW_READ_KW_in_statement515); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_read_list_in_statement521);
					rl=read_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


							code = rl;
						
					}
					break;
				case 6 :
					// VSLTreeParser.g:181:5: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement536);
					b=block(symTab);
					state._fsp--;


					        code = b;
					    
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
	// VSLTreeParser.g:187:1: block[SymbolTable symTab] returns [Code3a code] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a d =null;
		Code3a il =null;

		try {
			// VSLTreeParser.g:188:5: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==BLOCK) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==DOWN) ) {
					int LA7_2 = input.LA(3);
					if ( (LA7_2==DECL) ) {
						alt7=1;
					}
					else if ( (LA7_2==INST) ) {
						alt7=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 7, 2, input);
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
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// VSLTreeParser.g:189:5: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block565); 

					        symTab.enterScope();
					    
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block584);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block589);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        code = d;
					        code.append(il);
					        symTab.leaveScope();
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:200:5: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block608); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block612);
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
	// VSLTreeParser.g:206:1: inst_list[SymbolTable symTab] returns [Code3a code] : ^( INST (st= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a st =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:211:5: ( ^( INST (st= statement[symTab] )+ ) )
			// VSLTreeParser.g:212:5: ^( INST (st= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list647); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:212:12: (st= statement[symTab] )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==ASSIGN_KW||LA8_0==IF_KW||LA8_0==PRINT_KW||LA8_0==READ_KW||LA8_0==WHILE_KW||LA8_0==BLOCK) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// VSLTreeParser.g:212:13: st= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list652);
					st=statement(symTab);
					state._fsp--;


					        code.append(st);
					    
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
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
	// VSLTreeParser.g:219:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// VSLTreeParser.g:220:5: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt9=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt9=1;
				}
				break;
			case MINUS:
				{
				alt9=2;
				}
				break;
			case MUL:
				{
				alt9=3;
				}
				break;
			case DIV:
				{
				alt9=4;
				}
				break;
			case IDENT:
			case INTEGER:
			case ARELEM:
				{
				alt9=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// VSLTreeParser.g:221:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression689); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression695);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression702);
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
					// VSLTreeParser.g:229:5: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression720); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression726);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression733);
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
					// VSLTreeParser.g:237:5: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression751); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression757);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression764);
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
					// VSLTreeParser.g:245:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression782); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression788);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression795);
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
					// VSLTreeParser.g:253:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression817);
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
	// VSLTreeParser.g:259:1: array_elem[SymbolTable symTab] returns [ArrayAttribute arrAtt] : ^( ARELEM IDENT e= expression[symTab] ) ;
	public final ArrayAttribute array_elem(SymbolTable symTab) throws RecognitionException {
		ArrayAttribute arrAtt = null;


		CommonTree IDENT6=null;
		ExpAttribute e =null;

		try {
			// VSLTreeParser.g:260:2: ( ^( ARELEM IDENT e= expression[symTab] ) )
			// VSLTreeParser.g:261:2: ^( ARELEM IDENT e= expression[symTab] )
			{
			match(input,ARELEM,FOLLOW_ARELEM_in_array_elem842); 
			match(input, Token.DOWN, null); 
			IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_array_elem845); 
			pushFollow(FOLLOW_expression_in_array_elem849);
			e=expression(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


					arrAtt = TreeParserCode.newArrayElem(symTab, (IDENT6!=null?IDENT6.getText():null), e);
			    
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
	// VSLTreeParser.g:267:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT |a= array_elem[symTab] );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER7=null;
		CommonTree IDENT8=null;
		ArrayAttribute a =null;

		try {
			// VSLTreeParser.g:268:5: ( INTEGER | IDENT |a= array_elem[symTab] )
			int alt10=3;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt10=1;
				}
				break;
			case IDENT:
				{
				alt10=2;
				}
				break;
			case ARELEM:
				{
				alt10=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// VSLTreeParser.g:269:5: INTEGER
					{
					INTEGER7=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp875); 

					        ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER7!=null?INTEGER7.getText():null)));
					        expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:275:5: IDENT
					{
					IDENT8=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp890); 

					        Operand3a o = symTab.lookup((IDENT8!=null?IDENT8.getText():null));
					        if(o == null){
					           System.err.println("Error: variable \"" + (IDENT8!=null?IDENT8.getText():null) + "\" is not declared.");
					        }
					        expAtt = new ExpAttribute(o.type, new Code3a(), symTab.lookup((IDENT8!=null?IDENT8.getText():null)));
					    
					}
					break;
				case 3 :
					// VSLTreeParser.g:284:2: a= array_elem[symTab]
					{
					pushFollow(FOLLOW_array_elem_in_primary_exp905);
					a=array_elem(symTab);
					state._fsp--;


							expAtt = a.exp;
						
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



	// $ANTLR start "declaration"
	// VSLTreeParser.g:290:1: declaration[SymbolTable symTab] returns [Code3a code] : ^( DECL (dl= decl_list[symTab] ) ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a dl =null;

		try {
			// VSLTreeParser.g:291:5: ( ^( DECL (dl= decl_list[symTab] ) ) )
			// VSLTreeParser.g:292:5: ^( DECL (dl= decl_list[symTab] ) )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration930); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:292:12: (dl= decl_list[symTab] )
			// VSLTreeParser.g:292:13: dl= decl_list[symTab]
			{
			pushFollow(FOLLOW_decl_list_in_declaration937);
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
	// VSLTreeParser.g:298:1: decl_list[SymbolTable symTab] returns [Code3a code] : (di= decl_item[symTab] )+ ;
	public final Code3a decl_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a di =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:303:5: ( (di= decl_item[symTab] )+ )
			// VSLTreeParser.g:304:5: (di= decl_item[symTab] )+
			{
			// VSLTreeParser.g:304:5: (di= decl_item[symTab] )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==IDENT||LA11_0==ARDECL) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// VSLTreeParser.g:304:6: di= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_decl_list976);
					di=decl_item(symTab);
					state._fsp--;


							code.append(di);
						
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
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
	// VSLTreeParser.g:311:1: decl_item[SymbolTable symTab] returns [Code3a code] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT9=null;
		CommonTree IDENT10=null;
		CommonTree INTEGER11=null;

		try {
			// VSLTreeParser.g:312:5: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==IDENT) ) {
				alt12=1;
			}
			else if ( (LA12_0==ARDECL) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// VSLTreeParser.g:313:5: IDENT
					{
					IDENT9=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1007); 

							Operand3a o = symTab.lookup((IDENT9!=null?IDENT9.getText():null));
							int currentScope = symTab.getScope();
							if (o != null && o.getScope() == currentScope){
								System.err.println("Error: \"" + (IDENT9!=null?IDENT9.getText():null) + "\" is already declared.");
							} else {
								VarSymbol vs = new VarSymbol(Type.INT, (IDENT9!=null?IDENT9.getText():null), symTab.getScope());
								symTab.insert((IDENT9!=null?IDENT9.getText():null), vs);
								code = Code3aGenerator.genVar(vs);
							}
						
					}
					break;
				case 2 :
					// VSLTreeParser.g:326:5: ^( ARDECL IDENT INTEGER )
					{
					match(input,ARDECL,FOLLOW_ARDECL_in_decl_item1020); 
					match(input, Token.DOWN, null); 
					IDENT10=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1022); 
					INTEGER11=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item1024); 
					match(input, Token.UP, null); 


							Operand3a o = symTab.lookup((IDENT10!=null?IDENT10.getText():null));
							int currentScope = symTab.getScope();
							if (o != null && o.getScope() == currentScope){
								System.err.println("Error: variable \"" + (IDENT10!=null?IDENT10.getText():null) + "\" is already declared.");
							} else {
								ArrayType at = new ArrayType(Type.INT, Integer.parseInt((INTEGER11!=null?INTEGER11.getText():null)));
								VarSymbol vs = new VarSymbol(at, (IDENT10!=null?IDENT10.getText():null), symTab.getScope());
								symTab.insert((IDENT10!=null?IDENT10.getText():null), vs);
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
	// VSLTreeParser.g:342:1: print_list[SymbolTable symTab] returns [Code3a code] : (pi= print_item[symTab] )+ ;
	public final Code3a print_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a pi =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:347:5: ( (pi= print_item[symTab] )+ )
			// VSLTreeParser.g:348:5: (pi= print_item[symTab] )+
			{
			// VSLTreeParser.g:348:5: (pi= print_item[symTab] )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==DIV||LA13_0==IDENT||LA13_0==INTEGER||(LA13_0 >= MINUS && LA13_0 <= MUL)||LA13_0==PLUS||LA13_0==TEXT||LA13_0==ARELEM) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// VSLTreeParser.g:348:6: pi= print_item[symTab]
					{
					pushFollow(FOLLOW_print_item_in_print_list1059);
					pi=print_item(symTab);
					state._fsp--;


							code.append(pi);
						
					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
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
	// VSLTreeParser.g:355:1: print_item[SymbolTable symTab] returns [Code3a code] : ( TEXT |e= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree TEXT12=null;
		ExpAttribute e =null;

		try {
			// VSLTreeParser.g:356:2: ( TEXT |e= expression[symTab] )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==TEXT) ) {
				alt14=1;
			}
			else if ( (LA14_0==DIV||LA14_0==IDENT||LA14_0==INTEGER||(LA14_0 >= MINUS && LA14_0 <= MUL)||LA14_0==PLUS||LA14_0==ARELEM) ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// VSLTreeParser.g:357:2: TEXT
					{
					TEXT12=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item1086); 

							LabelSymbol ls = SymbDistrib.builtinPrintS;
							Data3a data = new Data3a((TEXT12!=null?TEXT12.getText():null));
							code = Code3aGenerator.genArg(data.getLabel());
							code.appendData(data);
							code.append(Code3aGenerator.genCall(ls));
						
					}
					break;
				case 2 :
					// VSLTreeParser.g:366:2: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item1099);
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
	// VSLTreeParser.g:375:1: read_list[SymbolTable symTab] returns [Code3a code] : (ri= read_item[symTab] )+ ;
	public final Code3a read_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a ri =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:380:5: ( (ri= read_item[symTab] )+ )
			// VSLTreeParser.g:381:5: (ri= read_item[symTab] )+
			{
			// VSLTreeParser.g:381:5: (ri= read_item[symTab] )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==IDENT) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// VSLTreeParser.g:381:6: ri= read_item[symTab]
					{
					pushFollow(FOLLOW_read_item_in_read_list1133);
					ri=read_item(symTab);
					state._fsp--;


							code.append(ri);
						
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
		return code;
	}
	// $ANTLR end "read_list"



	// $ANTLR start "read_item"
	// VSLTreeParser.g:388:1: read_item[SymbolTable symTab] returns [Code3a code] : IDENT ;
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT13=null;

		try {
			// VSLTreeParser.g:389:2: ( IDENT )
			// VSLTreeParser.g:390:2: IDENT
			{
			IDENT13=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item1160); 

					Operand3a o = symTab.lookup((IDENT13!=null?IDENT13.getText():null));
					if(o == null){
						System.err.println("Error: variable \"" + (IDENT13!=null?IDENT13.getText():null) + "\" is not declared.");
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



	public static final BitSet FOLLOW_statement_in_s63 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_param89 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_param108 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_param110 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PARAM_in_param_list141 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_param_list148 = new BitSet(new long[]{0x0000010000004008L});
	public static final BitSet FOLLOW_INT_KW_in_type171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KW_in_type180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROTO_KW_in_proto203 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_proto207 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_proto209 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_param_list_in_proto213 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_KW_in_function241 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_function245 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_function247 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_param_list_in_function251 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_BODY_in_function255 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_function259 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement293 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement297 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement308 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_array_elem_in_statement334 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_KW_in_statement357 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement362 = new BitSet(new long[]{0x0000021044008020L});
	public static final BitSet FOLLOW_statement_in_statement384 = new BitSet(new long[]{0x0000021044008028L});
	public static final BitSet FOLLOW_statement_in_statement406 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement452 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement458 = new BitSet(new long[]{0x0000021044008020L});
	public static final BitSet FOLLOW_statement_in_statement479 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement498 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_list_in_statement504 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_KW_in_statement515 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_list_in_statement521 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement536 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_block565 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block584 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block589 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block608 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block612 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list647 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list652 = new BitSet(new long[]{0x0000021044008028L});
	public static final BitSet FOLLOW_PLUS_in_expression689 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression695 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_expression702 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression720 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression726 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_expression733 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression751 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression757 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_expression764 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression782 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression788 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_expression795 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression817 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARELEM_in_array_elem842 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_array_elem845 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_array_elem849 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp875 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp890 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_elem_in_primary_exp905 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECL_in_declaration930 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_list_in_declaration937 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_decl_item_in_decl_list976 = new BitSet(new long[]{0x0000004000004002L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1007 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item1020 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1022 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item1024 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_print_item_in_print_list1059 = new BitSet(new long[]{0x0000008202C14202L});
	public static final BitSet FOLLOW_TEXT_in_print_item1086 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item1099 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_item_in_read_list1133 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_IDENT_in_read_item1160 = new BitSet(new long[]{0x0000000000000002L});
}
