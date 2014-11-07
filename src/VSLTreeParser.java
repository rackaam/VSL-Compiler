// $ANTLR 3.5.2 VSLTreeParser.g 2014-11-07 12:01:26

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
	// VSLTreeParser.g:13:1: statement[SymbolTable symTab] returns [Code3a cod] : ( ^( ASSIGN_KW e= expression[symTab] IDENT ) |b= block[symTab] );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		CommonTree IDENT1=null;
		ExpAttribute e =null;
		Code3a b =null;

		try {
			// VSLTreeParser.g:14:2: ( ^( ASSIGN_KW e= expression[symTab] IDENT ) |b= block[symTab] )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==ASSIGN_KW) ) {
				alt1=1;
			}
			else if ( (LA1_0==BLOCK) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
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
								cod = e.code;
								cod.append(new Code3a(new Inst3a(Inst3a.TAC.COPY, id, e.place, null)));
							}
							else {
								System.err.println("Errot: variable \"" + (IDENT1!=null?IDENT1.getText():null) + "\" is not declared.");
							}
						
					}
					break;
				case 2 :
					// VSLTreeParser.g:24:4: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement101);
					b=block(symTab);
					state._fsp--;


					        cod = b;
					    
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
		return cod;
	}
	// $ANTLR end "statement"



	// $ANTLR start "block"
	// VSLTreeParser.g:29:1: block[SymbolTable symTab] returns [Code3a cod] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a d =null;
		Code3a il =null;

		try {
			// VSLTreeParser.g:30:2: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==BLOCK) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==DOWN) ) {
					int LA2_2 = input.LA(3);
					if ( (LA2_2==DECL) ) {
						alt2=1;
					}
					else if ( (LA2_2==INST) ) {
						alt2=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 2, input);
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
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// VSLTreeParser.g:30:4: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block122); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block126);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block131);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


							symTab.enterScope();
							cod = d;
							cod.append(il);
							symTab.leaveScope();
						
					}
					break;
				case 2 :
					// VSLTreeParser.g:37:4: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block142); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block146);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


							cod = il;
						
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
		return cod;
	}
	// $ANTLR end "block"



	// $ANTLR start "inst_list"
	// VSLTreeParser.g:43:1: inst_list[SymbolTable symTab] returns [Code3a cod] : ^( INST (st= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a st =null;


				cod = new Code3a();
			
		try {
			// VSLTreeParser.g:47:2: ( ^( INST (st= statement[symTab] )+ ) )
			// VSLTreeParser.g:47:4: ^( INST (st= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list175); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:47:11: (st= statement[symTab] )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==ASSIGN_KW||LA3_0==BLOCK) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// VSLTreeParser.g:47:12: st= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list180);
					st=statement(symTab);
					state._fsp--;


							cod.append(st) ;
						
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
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
		return cod;
	}
	// $ANTLR end "inst_list"



	// $ANTLR start "expression"
	// VSLTreeParser.g:52:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// VSLTreeParser.g:53:3: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt4=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt4=1;
				}
				break;
			case MINUS:
				{
				alt4=2;
				}
				break;
			case MUL:
				{
				alt4=3;
				}
				break;
			case DIV:
				{
				alt4=4;
				}
				break;
			case IDENT:
			case INTEGER:
				{
				alt4=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// VSLTreeParser.g:53:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression204); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression208);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression213);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, e1, e2, temp);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:61:5: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression233); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression237);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression242);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, e1, e2, temp);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 3 :
					// VSLTreeParser.g:69:4: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression261); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression265);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression270);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, e1, e2, temp);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 4 :
					// VSLTreeParser.g:77:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression290); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression294);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression299);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, e1, e2, temp);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 5 :
					// VSLTreeParser.g:85:6: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression322);
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
	// VSLTreeParser.g:89:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER2=null;
		CommonTree IDENT3=null;

		try {
			// VSLTreeParser.g:90:3: ( INTEGER | IDENT )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==INTEGER) ) {
				alt5=1;
			}
			else if ( (LA5_0==IDENT) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// VSLTreeParser.g:90:5: INTEGER
					{
					INTEGER2=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp350); 

					      ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER2!=null?INTEGER2.getText():null)));
					      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:95:5: IDENT
					{
					IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp362); 

					      Operand3a id = symTab.lookup((IDENT3!=null?IDENT3.getText():null));
					      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT3!=null?IDENT3.getText():null)));
					    
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
	// VSLTreeParser.g:102:1: declaration[SymbolTable symTab] returns [Code3a cod] : ^( DECL (dl= decl_list[symTab] ) ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a dl =null;

		try {
			// VSLTreeParser.g:103:2: ( ^( DECL (dl= decl_list[symTab] ) ) )
			// VSLTreeParser.g:103:4: ^( DECL (dl= decl_list[symTab] ) )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration387); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:103:11: (dl= decl_list[symTab] )
			// VSLTreeParser.g:103:12: dl= decl_list[symTab]
			{
			pushFollow(FOLLOW_decl_list_in_declaration392);
			dl=decl_list(symTab);
			state._fsp--;


					cod = dl ;
				
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
		return cod;
	}
	// $ANTLR end "declaration"



	// $ANTLR start "decl_list"
	// VSLTreeParser.g:108:1: decl_list[SymbolTable symTab] returns [Code3a cod] : (di= decl_item[symTab] )+ ;
	public final Code3a decl_list(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a di =null;


				cod = new Code3a();
			
		try {
			// VSLTreeParser.g:112:2: ( (di= decl_item[symTab] )+ )
			// VSLTreeParser.g:112:4: (di= decl_item[symTab] )+
			{
			// VSLTreeParser.g:112:4: (di= decl_item[symTab] )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==IDENT||LA6_0==ARDECL) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// VSLTreeParser.g:112:5: di= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_decl_list423);
					di=decl_item(symTab);
					state._fsp--;


							cod.append(di);
						
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
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
		return cod;
	}
	// $ANTLR end "decl_list"



	// $ANTLR start "decl_item"
	// VSLTreeParser.g:117:1: decl_item[SymbolTable symTab] returns [Code3a cod] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		CommonTree IDENT4=null;
		CommonTree IDENT5=null;
		CommonTree INTEGER6=null;

		try {
			// VSLTreeParser.g:118:2: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==IDENT) ) {
				alt7=1;
			}
			else if ( (LA7_0==ARDECL) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// VSLTreeParser.g:118:4: IDENT
					{
					IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item444); 

							Operand3a id = symTab.lookup((IDENT4!=null?IDENT4.getText():null));
							if (id == null){
								VarSymbol vs = new VarSymbol(Type.INT, (IDENT4!=null?IDENT4.getText():null), symTab.getScope());
								symTab.insert((IDENT4!=null?IDENT4.getText():null), vs);
								cod = Code3aGenerator.genVar(vs);
							}
							else {
								System.err.println("Error: \"" + (IDENT4!=null?IDENT4.getText():null) + "\" is already declared.");
							}
						
					}
					break;
				case 2 :
					// VSLTreeParser.g:130:4: ^( ARDECL IDENT INTEGER )
					{
					match(input,ARDECL,FOLLOW_ARDECL_in_decl_item453); 
					match(input, Token.DOWN, null); 
					IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item455); 
					INTEGER6=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item457); 
					match(input, Token.UP, null); 


							Operand3a id = symTab.lookup((IDENT5!=null?IDENT5.getText():null));
							if (id == null){
								ArrayType aty = new ArrayType(Type.INT, Integer.parseInt((INTEGER6!=null?INTEGER6.getText():null)));
								VarSymbol vs = new VarSymbol(aty, (IDENT5!=null?IDENT5.getText():null), symTab.getScope());
								symTab.insert((IDENT5!=null?IDENT5.getText():null), vs);
								cod = Code3aGenerator.genVar(vs);
							}
							else {
								System.err.println("Error: variable \"" + (IDENT5!=null?IDENT5.getText():null) + "\" is already declared.");
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
		return cod;
	}
	// $ANTLR end "decl_item"

	// Delegated rules



	public static final BitSet FOLLOW_statement_in_s60 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement84 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement88 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement91 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_block122 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block126 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block131 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block142 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block146 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list175 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list180 = new BitSet(new long[]{0x0000020000000028L});
	public static final BitSet FOLLOW_PLUS_in_expression204 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression208 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression213 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression233 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression237 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression242 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression261 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression265 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression270 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression290 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression294 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression299 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp350 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp362 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECL_in_declaration387 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_list_in_declaration392 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_decl_item_in_decl_list423 = new BitSet(new long[]{0x0000004000004002L});
	public static final BitSet FOLLOW_IDENT_in_decl_item444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item453 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item455 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item457 = new BitSet(new long[]{0x0000000000000008L});
}
