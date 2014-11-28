// $ANTLR 3.5.2 VSLTreeParser.g 2014-11-28 22:08:36

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

			match(input,BODY,FOLLOW_BODY_in_function315); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_statement_in_function319);
			st=statement(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


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
	// VSLTreeParser.g:125:1: statement[SymbolTable symTab] returns [Code3a code] : ( ^( ASSIGN_KW e= expression[symTab] ( ( IDENT ) | (arrayElem= array_elem[symTab] ) ) ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pl= print_list[symTab] ) | ^( READ_KW rl= read_list[symTab] ) |b= block[symTab] );
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
			// VSLTreeParser.g:126:5: ( ^( ASSIGN_KW e= expression[symTab] ( ( IDENT ) | (arrayElem= array_elem[symTab] ) ) ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pl= print_list[symTab] ) | ^( READ_KW rl= read_list[symTab] ) |b= block[symTab] )
			int alt8=6;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt8=1;
				}
				break;
			case IF_KW:
				{
				alt8=2;
				}
				break;
			case WHILE_KW:
				{
				alt8=3;
				}
				break;
			case PRINT_KW:
				{
				alt8=4;
				}
				break;
			case READ_KW:
				{
				alt8=5;
				}
				break;
			case BLOCK:
				{
				alt8=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// VSLTreeParser.g:127:5: ^( ASSIGN_KW e= expression[symTab] ( ( IDENT ) | (arrayElem= array_elem[symTab] ) ) )
					{
					match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement353); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement357);
					e=expression(symTab);
					state._fsp--;

					// VSLTreeParser.g:127:38: ( ( IDENT ) | (arrayElem= array_elem[symTab] ) )
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
							// VSLTreeParser.g:128:5: ( IDENT )
							{
							// VSLTreeParser.g:128:5: ( IDENT )
							// VSLTreeParser.g:128:7: IDENT
							{
							IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement368); 

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
							// VSLTreeParser.g:141:2: (arrayElem= array_elem[symTab] )
							{
							// VSLTreeParser.g:141:2: (arrayElem= array_elem[symTab] )
							// VSLTreeParser.g:142:3: arrayElem= array_elem[symTab]
							{
							pushFollow(FOLLOW_array_elem_in_statement394);
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
					// VSLTreeParser.g:150:5: ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement417); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement422);
					e=expression(symTab);
					state._fsp--;


					        LabelSymbol l_else = SymbDistrib.newLabel();
					        LabelSymbol l_fin = SymbDistrib.newLabel();
					        code = Code3aGenerator.genIfZ(e, l_else);
					    
					pushFollow(FOLLOW_statement_in_statement444);
					s1=statement(symTab);
					state._fsp--;


					        code.append(s1);
					        code.append(Code3aGenerator.genGoTo(l_fin));
					        code.append(Code3aGenerator.genLabel(l_else));
					    
					// VSLTreeParser.g:162:9: (s2= statement[symTab] )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==ASSIGN_KW||LA7_0==IF_KW||LA7_0==PRINT_KW||LA7_0==READ_KW||LA7_0==WHILE_KW||LA7_0==BLOCK) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// VSLTreeParser.g:162:10: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement466);
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
					// VSLTreeParser.g:172:5: ^( WHILE_KW e= expression[symTab] st= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement510); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement516);
					e=expression(symTab);
					state._fsp--;


					        LabelSymbol l_deb = SymbDistrib.newLabel();
					        LabelSymbol l_fin = SymbDistrib.newLabel();
					        code = (Code3aGenerator.genLabel(l_deb));
					        code.append(Code3aGenerator.genIfZ(e, l_fin));
					    
					pushFollow(FOLLOW_statement_in_statement537);
					st=statement(symTab);
					state._fsp--;


					        code.append(st);
					        code.append(Code3aGenerator.genGoTo(l_deb));
					        code.append(Code3aGenerator.genLabel(l_fin));
					    
					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// VSLTreeParser.g:187:2: ^( PRINT_KW pl= print_list[symTab] )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement556); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_print_list_in_statement562);
					pl=print_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


							code = pl;
						
					}
					break;
				case 5 :
					// VSLTreeParser.g:192:2: ^( READ_KW rl= read_list[symTab] )
					{
					match(input,READ_KW,FOLLOW_READ_KW_in_statement573); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_read_list_in_statement579);
					rl=read_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


							code = rl;
						
					}
					break;
				case 6 :
					// VSLTreeParser.g:197:5: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement594);
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
	// VSLTreeParser.g:203:1: block[SymbolTable symTab] returns [Code3a code] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a d =null;
		Code3a il =null;

		try {
			// VSLTreeParser.g:204:5: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==BLOCK) ) {
				int LA9_1 = input.LA(2);
				if ( (LA9_1==DOWN) ) {
					int LA9_2 = input.LA(3);
					if ( (LA9_2==DECL) ) {
						alt9=1;
					}
					else if ( (LA9_2==INST) ) {
						alt9=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 9, 2, input);
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
							new NoViableAltException("", 9, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// VSLTreeParser.g:205:5: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block623); 

					        symTab.enterScope();
					    
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block642);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block647);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        code = d;
					        code.append(il);
					        symTab.leaveScope();
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:216:5: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block666); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block670);
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
	// VSLTreeParser.g:222:1: inst_list[SymbolTable symTab] returns [Code3a code] : ^( INST (st= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a st =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:227:5: ( ^( INST (st= statement[symTab] )+ ) )
			// VSLTreeParser.g:228:5: ^( INST (st= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list705); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:228:12: (st= statement[symTab] )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==ASSIGN_KW||LA10_0==IF_KW||LA10_0==PRINT_KW||LA10_0==READ_KW||LA10_0==WHILE_KW||LA10_0==BLOCK) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// VSLTreeParser.g:228:13: st= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list710);
					st=statement(symTab);
					state._fsp--;


					        code.append(st);
					    
					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
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
	// VSLTreeParser.g:235:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// VSLTreeParser.g:236:5: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt11=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt11=1;
				}
				break;
			case MINUS:
				{
				alt11=2;
				}
				break;
			case MUL:
				{
				alt11=3;
				}
				break;
			case DIV:
				{
				alt11=4;
				}
				break;
			case IDENT:
			case INTEGER:
			case ARELEM:
				{
				alt11=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// VSLTreeParser.g:237:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression747); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression753);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression760);
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
					// VSLTreeParser.g:245:5: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression778); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression784);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression791);
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
					// VSLTreeParser.g:253:5: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression809); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression815);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression822);
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
					// VSLTreeParser.g:261:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression840); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression846);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression853);
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
					// VSLTreeParser.g:269:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression875);
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
	// VSLTreeParser.g:275:1: array_elem[SymbolTable symTab] returns [ArrayAttribute arrAtt] : ^( ARELEM IDENT e= expression[symTab] ) ;
	public final ArrayAttribute array_elem(SymbolTable symTab) throws RecognitionException {
		ArrayAttribute arrAtt = null;


		CommonTree IDENT6=null;
		ExpAttribute e =null;

		try {
			// VSLTreeParser.g:276:2: ( ^( ARELEM IDENT e= expression[symTab] ) )
			// VSLTreeParser.g:277:2: ^( ARELEM IDENT e= expression[symTab] )
			{
			match(input,ARELEM,FOLLOW_ARELEM_in_array_elem900); 
			match(input, Token.DOWN, null); 
			IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_array_elem903); 
			pushFollow(FOLLOW_expression_in_array_elem907);
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
	// VSLTreeParser.g:283:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT |a= array_elem[symTab] );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER7=null;
		CommonTree IDENT8=null;
		ArrayAttribute a =null;

		try {
			// VSLTreeParser.g:284:5: ( INTEGER | IDENT |a= array_elem[symTab] )
			int alt12=3;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt12=1;
				}
				break;
			case IDENT:
				{
				alt12=2;
				}
				break;
			case ARELEM:
				{
				alt12=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// VSLTreeParser.g:285:5: INTEGER
					{
					INTEGER7=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp933); 

					        ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER7!=null?INTEGER7.getText():null)));
					        expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:291:5: IDENT
					{
					IDENT8=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp948); 

					        Operand3a o = symTab.lookup((IDENT8!=null?IDENT8.getText():null));
					        if(o == null){
					           System.err.println("Error: variable \"" + (IDENT8!=null?IDENT8.getText():null) + "\" is not declared.");
					        }
					        expAtt = new ExpAttribute(o.type, new Code3a(), symTab.lookup((IDENT8!=null?IDENT8.getText():null)));
					    
					}
					break;
				case 3 :
					// VSLTreeParser.g:300:2: a= array_elem[symTab]
					{
					pushFollow(FOLLOW_array_elem_in_primary_exp963);
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


	public static class argument_list_return extends TreeRuleReturnScope {
		public Code3a code;
		public FunctionType ft;
	};


	// $ANTLR start "argument_list"
	// VSLTreeParser.g:306:1: argument_list[SymbolTable symTab] returns [Code3a code, FunctionType ft] : (e= expression[symTab] )+ ;
	public final VSLTreeParser.argument_list_return argument_list(SymbolTable symTab) throws RecognitionException {
		VSLTreeParser.argument_list_return retval = new VSLTreeParser.argument_list_return();
		retval.start = input.LT(1);

		ExpAttribute e =null;


		    retval.code = new Code3a();
		    retval.ft = new FunctionType(Type.INT, false);

		try {
			// VSLTreeParser.g:312:5: ( (e= expression[symTab] )+ )
			// VSLTreeParser.g:312:5: (e= expression[symTab] )+
			{
			// VSLTreeParser.g:312:5: (e= expression[symTab] )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==DIV||LA13_0==IDENT||LA13_0==INTEGER||(LA13_0 >= MINUS && LA13_0 <= MUL)||LA13_0==PLUS||LA13_0==ARELEM) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// VSLTreeParser.g:312:6: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_argument_list991);
					e=expression(symTab);
					state._fsp--;


					        retval.ft.extend(Type.INT);
					        retval.code.append(e.code);
					        retval.code.append(Code3aGenerator.genArg(e.place));
					    
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
		return retval;
	}
	// $ANTLR end "argument_list"



	// $ANTLR start "declaration"
	// VSLTreeParser.g:321:1: declaration[SymbolTable symTab] returns [Code3a code] : ^( DECL (dl= decl_list[symTab] ) ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a dl =null;

		try {
			// VSLTreeParser.g:322:5: ( ^( DECL (dl= decl_list[symTab] ) ) )
			// VSLTreeParser.g:323:5: ^( DECL (dl= decl_list[symTab] ) )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration1026); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:323:12: (dl= decl_list[symTab] )
			// VSLTreeParser.g:323:13: dl= decl_list[symTab]
			{
			pushFollow(FOLLOW_decl_list_in_declaration1033);
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
	// VSLTreeParser.g:329:1: decl_list[SymbolTable symTab] returns [Code3a code] : (di= decl_item[symTab] )+ ;
	public final Code3a decl_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a di =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:334:5: ( (di= decl_item[symTab] )+ )
			// VSLTreeParser.g:335:5: (di= decl_item[symTab] )+
			{
			// VSLTreeParser.g:335:5: (di= decl_item[symTab] )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==IDENT||LA14_0==ARDECL) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// VSLTreeParser.g:335:6: di= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_decl_list1072);
					di=decl_item(symTab);
					state._fsp--;


							code.append(di);
						
					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
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
	// VSLTreeParser.g:342:1: decl_item[SymbolTable symTab] returns [Code3a code] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT9=null;
		CommonTree IDENT10=null;
		CommonTree INTEGER11=null;

		try {
			// VSLTreeParser.g:343:5: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==IDENT) ) {
				alt15=1;
			}
			else if ( (LA15_0==ARDECL) ) {
				alt15=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// VSLTreeParser.g:344:5: IDENT
					{
					IDENT9=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1103); 

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
					// VSLTreeParser.g:357:5: ^( ARDECL IDENT INTEGER )
					{
					match(input,ARDECL,FOLLOW_ARDECL_in_decl_item1116); 
					match(input, Token.DOWN, null); 
					IDENT10=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1118); 
					INTEGER11=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item1120); 
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
	// VSLTreeParser.g:373:1: print_list[SymbolTable symTab] returns [Code3a code] : (pi= print_item[symTab] )+ ;
	public final Code3a print_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a pi =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:378:5: ( (pi= print_item[symTab] )+ )
			// VSLTreeParser.g:379:5: (pi= print_item[symTab] )+
			{
			// VSLTreeParser.g:379:5: (pi= print_item[symTab] )+
			int cnt16=0;
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==DIV||LA16_0==IDENT||LA16_0==INTEGER||(LA16_0 >= MINUS && LA16_0 <= MUL)||LA16_0==PLUS||LA16_0==TEXT||LA16_0==ARELEM) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// VSLTreeParser.g:379:6: pi= print_item[symTab]
					{
					pushFollow(FOLLOW_print_item_in_print_list1155);
					pi=print_item(symTab);
					state._fsp--;


							code.append(pi);
						
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
	// $ANTLR end "print_list"



	// $ANTLR start "print_item"
	// VSLTreeParser.g:386:1: print_item[SymbolTable symTab] returns [Code3a code] : ( TEXT |e= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree TEXT12=null;
		ExpAttribute e =null;

		try {
			// VSLTreeParser.g:387:2: ( TEXT |e= expression[symTab] )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==TEXT) ) {
				alt17=1;
			}
			else if ( (LA17_0==DIV||LA17_0==IDENT||LA17_0==INTEGER||(LA17_0 >= MINUS && LA17_0 <= MUL)||LA17_0==PLUS||LA17_0==ARELEM) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// VSLTreeParser.g:388:2: TEXT
					{
					TEXT12=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item1182); 

							LabelSymbol ls = SymbDistrib.builtinPrintS;
							Data3a data = new Data3a((TEXT12!=null?TEXT12.getText():null));
							code = Code3aGenerator.genArg(data.getLabel());
							code.appendData(data);
							code.append(Code3aGenerator.genCall(ls));
						
					}
					break;
				case 2 :
					// VSLTreeParser.g:397:2: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item1195);
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
	// VSLTreeParser.g:406:1: read_list[SymbolTable symTab] returns [Code3a code] : (ri= read_item[symTab] )+ ;
	public final Code3a read_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a ri =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:411:5: ( (ri= read_item[symTab] )+ )
			// VSLTreeParser.g:412:5: (ri= read_item[symTab] )+
			{
			// VSLTreeParser.g:412:5: (ri= read_item[symTab] )+
			int cnt18=0;
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==IDENT) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// VSLTreeParser.g:412:6: ri= read_item[symTab]
					{
					pushFollow(FOLLOW_read_item_in_read_list1229);
					ri=read_item(symTab);
					state._fsp--;


							code.append(ri);
						
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
	// $ANTLR end "read_list"



	// $ANTLR start "read_item"
	// VSLTreeParser.g:419:1: read_item[SymbolTable symTab] returns [Code3a code] : IDENT ;
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT13=null;

		try {
			// VSLTreeParser.g:420:2: ( IDENT )
			// VSLTreeParser.g:421:2: IDENT
			{
			IDENT13=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item1256); 

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
	public static final BitSet FOLLOW_BODY_in_function315 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_function319 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement353 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement357 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement368 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_array_elem_in_statement394 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_KW_in_statement417 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement422 = new BitSet(new long[]{0x0000021044008020L});
	public static final BitSet FOLLOW_statement_in_statement444 = new BitSet(new long[]{0x0000021044008028L});
	public static final BitSet FOLLOW_statement_in_statement466 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement510 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement516 = new BitSet(new long[]{0x0000021044008020L});
	public static final BitSet FOLLOW_statement_in_statement537 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement556 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_list_in_statement562 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_KW_in_statement573 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_list_in_statement579 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_block623 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block642 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block647 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block666 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block670 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list705 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list710 = new BitSet(new long[]{0x0000021044008028L});
	public static final BitSet FOLLOW_PLUS_in_expression747 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression753 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_expression760 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression778 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression784 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_expression791 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression809 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression815 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_expression822 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression840 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression846 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_expression853 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression875 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARELEM_in_array_elem900 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_array_elem903 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_array_elem907 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp933 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp948 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_elem_in_primary_exp963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_argument_list991 = new BitSet(new long[]{0x0000008002C14202L});
	public static final BitSet FOLLOW_DECL_in_declaration1026 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_list_in_declaration1033 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_decl_item_in_decl_list1072 = new BitSet(new long[]{0x0000004000004002L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item1116 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1118 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item1120 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_print_item_in_print_list1155 = new BitSet(new long[]{0x0000008202C14202L});
	public static final BitSet FOLLOW_TEXT_in_print_item1182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item1195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_item_in_read_list1229 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_IDENT_in_read_item1256 = new BitSet(new long[]{0x0000000000000002L});
}
