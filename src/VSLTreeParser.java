// $ANTLR 3.5.2 VSLTreeParser.g 2014-11-08 18:06:40

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
	// VSLTreeParser.g:9:1: s[SymbolTable symTab] returns [Code3a code] : st= statement[symTab] ;
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a st =null;

		try {
			// VSLTreeParser.g:10:3: (st= statement[symTab] )
			// VSLTreeParser.g:10:5: st= statement[symTab]
			{
			pushFollow(FOLLOW_statement_in_s60);
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



	// $ANTLR start "statement"
	// VSLTreeParser.g:13:1: statement[SymbolTable symTab] returns [Code3a code] : ( ^( ASSIGN_KW e= expression[symTab] IDENT ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) |b= block[symTab] );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT1=null;
		ExpAttribute e =null;
		Code3a s1 =null;
		Code3a s2 =null;
		Code3a st =null;
		Code3a b =null;

		try {
			// VSLTreeParser.g:14:2: ( ^( ASSIGN_KW e= expression[symTab] IDENT ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) |b= block[symTab] )
			int alt2=4;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt2=1;
				}
				break;
			case IF_KW:
				{
				alt2=2;
				}
				break;
			case WHILE_KW:
				{
				alt2=3;
				}
				break;
			case BLOCK:
				{
				alt2=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// VSLTreeParser.g:14:4: ^( ASSIGN_KW e= expression[symTab] IDENT )
					{
					match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement84); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement88);
					e=expression(symTab);
					state._fsp--;

					IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement91); 
					match(input, Token.UP, null); 


							Operand3a id = symTab.lookup((IDENT1!=null?IDENT1.getText():null));
							if (id != null) {
								code = e.code;
								code.append(new Code3a(new Inst3a(Inst3a.TAC.COPY, id, e.place, null)));
							}
							else {
								System.err.println("Error: variable \"" + (IDENT1!=null?IDENT1.getText():null) + "\" is not declared.");
							}
						
					}
					break;
				case 2 :
					// VSLTreeParser.g:24:3: ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement100); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement105);
					e=expression(symTab);
					state._fsp--;


					        LabelSymbol l_else = SymbDistrib.newLabel();
					        LabelSymbol l_fin = SymbDistrib.newLabel();
					        code = Code3aGenerator.genIfZ(e, l_else);
					    
					pushFollow(FOLLOW_statement_in_statement124);
					s1=statement(symTab);
					state._fsp--;


					        code.append(s1);
					        code.append(Code3aGenerator.genGoTo(l_fin));
					        code.append(Code3aGenerator.genLabel(l_else));
					    
					// VSLTreeParser.g:36:9: (s2= statement[symTab] )?
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==ASSIGN_KW||LA1_0==IF_KW||LA1_0==WHILE_KW||LA1_0==BLOCK) ) {
						alt1=1;
					}
					switch (alt1) {
						case 1 :
							// VSLTreeParser.g:36:11: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement147);
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
					// VSLTreeParser.g:46:2: ^( WHILE_KW e= expression[symTab] st= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement191); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement197);
					e=expression(symTab);
					state._fsp--;


					        LabelSymbol l_deb = SymbDistrib.newLabel();
					        LabelSymbol l_fin = SymbDistrib.newLabel();

					        code = (Code3aGenerator.genLabel(l_deb));
					        code.append(Code3aGenerator.genIfZ(e, l_fin));
					    
					pushFollow(FOLLOW_statement_in_statement218);
					st=statement(symTab);
					state._fsp--;


					        code.append(st);
					        code.append(Code3aGenerator.genGoTo(l_deb));
					        code.append(Code3aGenerator.genLabel(l_fin));
					    
					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// VSLTreeParser.g:62:5: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement245);
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
	// VSLTreeParser.g:67:1: block[SymbolTable symTab] returns [Code3a code] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a d =null;
		Code3a il =null;

		try {
			// VSLTreeParser.g:68:2: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==BLOCK) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==DOWN) ) {
					int LA3_2 = input.LA(3);
					if ( (LA3_2==DECL) ) {
						alt3=1;
					}
					else if ( (LA3_2==INST) ) {
						alt3=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 3, 2, input);
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
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// VSLTreeParser.g:68:4: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block266); 

								symTab.enterScope();
							
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block277);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block282);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


								code = d;
								code.append(il);
								symTab.leaveScope();
							
					}
					break;
				case 2 :
					// VSLTreeParser.g:78:4: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block295); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block299);
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
	// VSLTreeParser.g:83:1: inst_list[SymbolTable symTab] returns [Code3a code] : ^( INST (st= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a st =null;


				code = new Code3a();
			
		try {
			// VSLTreeParser.g:87:2: ( ^( INST (st= statement[symTab] )+ ) )
			// VSLTreeParser.g:87:4: ^( INST (st= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list327); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:87:11: (st= statement[symTab] )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==ASSIGN_KW||LA4_0==IF_KW||LA4_0==WHILE_KW||LA4_0==BLOCK) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// VSLTreeParser.g:87:12: st= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list332);
					st=statement(symTab);
					state._fsp--;


							code.append(st) ;
						
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
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
	// VSLTreeParser.g:92:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// VSLTreeParser.g:93:3: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt5=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt5=1;
				}
				break;
			case MINUS:
				{
				alt5=2;
				}
				break;
			case MUL:
				{
				alt5=3;
				}
				break;
			case DIV:
				{
				alt5=4;
				}
				break;
			case IDENT:
			case INTEGER:
				{
				alt5=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// VSLTreeParser.g:93:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression356); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression360);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression365);
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
					// VSLTreeParser.g:101:5: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression385); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression389);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression394);
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
					// VSLTreeParser.g:109:4: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression413); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression417);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression422);
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
					// VSLTreeParser.g:117:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression442); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression446);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression451);
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
					// VSLTreeParser.g:125:6: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression474);
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



	// $ANTLR start "primary_exp"
	// VSLTreeParser.g:129:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER2=null;
		CommonTree IDENT3=null;

		try {
			// VSLTreeParser.g:130:3: ( INTEGER | IDENT )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==INTEGER) ) {
				alt6=1;
			}
			else if ( (LA6_0==IDENT) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// VSLTreeParser.g:130:5: INTEGER
					{
					INTEGER2=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp502); 

					      ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER2!=null?INTEGER2.getText():null)));
					      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:135:5: IDENT
					{
					IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp514); 

					      Operand3a o = symTab.lookup((IDENT3!=null?IDENT3.getText():null));
					      if(o == null){
					      	System.err.println("Error: variable \"" + (IDENT3!=null?IDENT3.getText():null) + "\" is not declared.");
					      }
					      expAtt = new ExpAttribute(o.type, new Code3a(), symTab.lookup((IDENT3!=null?IDENT3.getText():null)));
					    
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
	// VSLTreeParser.g:145:1: declaration[SymbolTable symTab] returns [Code3a code] : ^( DECL (dl= decl_list[symTab] ) ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a dl =null;

		try {
			// VSLTreeParser.g:146:2: ( ^( DECL (dl= decl_list[symTab] ) ) )
			// VSLTreeParser.g:146:4: ^( DECL (dl= decl_list[symTab] ) )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration539); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:146:11: (dl= decl_list[symTab] )
			// VSLTreeParser.g:146:12: dl= decl_list[symTab]
			{
			pushFollow(FOLLOW_decl_list_in_declaration544);
			dl=decl_list(symTab);
			state._fsp--;


					code = dl ;
				
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
	// VSLTreeParser.g:151:1: decl_list[SymbolTable symTab] returns [Code3a code] : (di= decl_item[symTab] )+ ;
	public final Code3a decl_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a di =null;


				code = new Code3a();
			
		try {
			// VSLTreeParser.g:155:2: ( (di= decl_item[symTab] )+ )
			// VSLTreeParser.g:155:4: (di= decl_item[symTab] )+
			{
			// VSLTreeParser.g:155:4: (di= decl_item[symTab] )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==IDENT||LA7_0==ARDECL) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// VSLTreeParser.g:155:5: di= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_decl_list575);
					di=decl_item(symTab);
					state._fsp--;


							code.append(di);
						
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
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
	// VSLTreeParser.g:160:1: decl_item[SymbolTable symTab] returns [Code3a code] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT4=null;
		CommonTree IDENT5=null;
		CommonTree INTEGER6=null;

		try {
			// VSLTreeParser.g:161:2: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==IDENT) ) {
				alt8=1;
			}
			else if ( (LA8_0==ARDECL) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// VSLTreeParser.g:161:4: IDENT
					{
					IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item596); 

							Operand3a o = symTab.lookup((IDENT4!=null?IDENT4.getText():null));
							int currentScope = symTab.getScope();
							if (o != null && o.getScope() == currentScope){
								System.err.println("Error: \"" + (IDENT4!=null?IDENT4.getText():null) + "\" is already declared.");
							} else {
								VarSymbol vs = new VarSymbol(Type.INT, (IDENT4!=null?IDENT4.getText():null), symTab.getScope());
								symTab.insert((IDENT4!=null?IDENT4.getText():null), vs);
								code = Code3aGenerator.genVar(vs);
							}
						
					}
					break;
				case 2 :
					// VSLTreeParser.g:173:4: ^( ARDECL IDENT INTEGER )
					{
					match(input,ARDECL,FOLLOW_ARDECL_in_decl_item605); 
					match(input, Token.DOWN, null); 
					IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item607); 
					INTEGER6=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item609); 
					match(input, Token.UP, null); 


							Operand3a o = symTab.lookup((IDENT5!=null?IDENT5.getText():null));
							int currentScope = symTab.getScope();
							if (o != null && o.getScope() == currentScope){
								System.err.println("Error: variable \"" + (IDENT5!=null?IDENT5.getText():null) + "\" is already declared.");
							} else {
								ArrayType aty = new ArrayType(Type.INT, Integer.parseInt((INTEGER6!=null?INTEGER6.getText():null)));
								VarSymbol vs = new VarSymbol(aty, (IDENT5!=null?IDENT5.getText():null), symTab.getScope());
								symTab.insert((IDENT5!=null?IDENT5.getText():null), vs);
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

	// Delegated rules



	public static final BitSet FOLLOW_statement_in_s60 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement84 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement88 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement91 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_KW_in_statement100 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement105 = new BitSet(new long[]{0x0000021000008020L});
	public static final BitSet FOLLOW_statement_in_statement124 = new BitSet(new long[]{0x0000021000008028L});
	public static final BitSet FOLLOW_statement_in_statement147 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement191 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement197 = new BitSet(new long[]{0x0000021000008020L});
	public static final BitSet FOLLOW_statement_in_statement218 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_block266 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block277 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block282 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block295 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block299 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list327 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list332 = new BitSet(new long[]{0x0000021000008028L});
	public static final BitSet FOLLOW_PLUS_in_expression356 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression360 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression365 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression385 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression389 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression394 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression413 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression417 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression422 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression442 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression446 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression451 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp502 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECL_in_declaration539 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_list_in_declaration544 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_decl_item_in_decl_list575 = new BitSet(new long[]{0x0000004000004002L});
	public static final BitSet FOLLOW_IDENT_in_decl_item596 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item605 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item607 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item609 = new BitSet(new long[]{0x0000000000000008L});
}
