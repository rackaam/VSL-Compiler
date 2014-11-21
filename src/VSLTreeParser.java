// $ANTLR 3.5.2 VSLTreeParser.g 2014-11-21 15:54:01

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
			// VSLTreeParser.g:10:5: (st= statement[symTab] )
			// VSLTreeParser.g:11:5: st= statement[symTab]
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



	// $ANTLR start "statement"
	// VSLTreeParser.g:17:1: statement[SymbolTable symTab] returns [Code3a code] : ( ^( ASSIGN_KW e= expression[symTab] IDENT ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pl= print_list[symTab] ) | ^( READ_KW rl= read_list[symTab] ) |b= block[symTab] );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT1=null;
		ExpAttribute e =null;
		Code3a s1 =null;
		Code3a s2 =null;
		Code3a st =null;
		Code3a pl =null;
		Code3a rl =null;
		Code3a b =null;

		try {
			// VSLTreeParser.g:18:5: ( ^( ASSIGN_KW e= expression[symTab] IDENT ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) | ^( PRINT_KW pl= print_list[symTab] ) | ^( READ_KW rl= read_list[symTab] ) |b= block[symTab] )
			int alt2=6;
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
			case PRINT_KW:
				{
				alt2=4;
				}
				break;
			case READ_KW:
				{
				alt2=5;
				}
				break;
			case BLOCK:
				{
				alt2=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// VSLTreeParser.g:19:5: ^( ASSIGN_KW e= expression[symTab] IDENT )
					{
					match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement94); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement98);
					e=expression(symTab);
					state._fsp--;

					IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement101); 
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
					// VSLTreeParser.g:31:5: ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement120); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement125);
					e=expression(symTab);
					state._fsp--;


					        LabelSymbol l_else = SymbDistrib.newLabel();
					        LabelSymbol l_fin = SymbDistrib.newLabel();
					        code = Code3aGenerator.genIfZ(e, l_else);
					    
					pushFollow(FOLLOW_statement_in_statement147);
					s1=statement(symTab);
					state._fsp--;


					        code.append(s1);
					        code.append(Code3aGenerator.genGoTo(l_fin));
					        code.append(Code3aGenerator.genLabel(l_else));
					    
					// VSLTreeParser.g:43:9: (s2= statement[symTab] )?
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==ASSIGN_KW||LA1_0==IF_KW||LA1_0==PRINT_KW||LA1_0==READ_KW||LA1_0==WHILE_KW||LA1_0==BLOCK) ) {
						alt1=1;
					}
					switch (alt1) {
						case 1 :
							// VSLTreeParser.g:43:10: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement169);
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
					// VSLTreeParser.g:53:5: ^( WHILE_KW e= expression[symTab] st= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement215); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement221);
					e=expression(symTab);
					state._fsp--;


					        LabelSymbol l_deb = SymbDistrib.newLabel();
					        LabelSymbol l_fin = SymbDistrib.newLabel();
					        code = (Code3aGenerator.genLabel(l_deb));
					        code.append(Code3aGenerator.genIfZ(e, l_fin));
					    
					pushFollow(FOLLOW_statement_in_statement242);
					st=statement(symTab);
					state._fsp--;


					        code.append(st);
					        code.append(Code3aGenerator.genGoTo(l_deb));
					        code.append(Code3aGenerator.genLabel(l_fin));
					    
					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// VSLTreeParser.g:68:2: ^( PRINT_KW pl= print_list[symTab] )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement261); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_print_list_in_statement267);
					pl=print_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


							code = pl;
						
					}
					break;
				case 5 :
					// VSLTreeParser.g:73:2: ^( READ_KW rl= read_list[symTab] )
					{
					match(input,READ_KW,FOLLOW_READ_KW_in_statement278); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_read_list_in_statement284);
					rl=read_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


							code = rl;
						
					}
					break;
				case 6 :
					// VSLTreeParser.g:78:5: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement299);
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
	// VSLTreeParser.g:84:1: block[SymbolTable symTab] returns [Code3a code] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a d =null;
		Code3a il =null;

		try {
			// VSLTreeParser.g:85:5: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
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
					// VSLTreeParser.g:86:5: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block328); 

					        symTab.enterScope();
					    
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block347);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block352);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        code = d;
					        code.append(il);
					        symTab.leaveScope();
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:97:5: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block371); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block375);
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
	// VSLTreeParser.g:103:1: inst_list[SymbolTable symTab] returns [Code3a code] : ^( INST (st= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a st =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:108:5: ( ^( INST (st= statement[symTab] )+ ) )
			// VSLTreeParser.g:109:5: ^( INST (st= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list410); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:109:12: (st= statement[symTab] )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==ASSIGN_KW||LA4_0==IF_KW||LA4_0==PRINT_KW||LA4_0==READ_KW||LA4_0==WHILE_KW||LA4_0==BLOCK) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// VSLTreeParser.g:109:13: st= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list415);
					st=statement(symTab);
					state._fsp--;


					        code.append(st);
					    
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
	// VSLTreeParser.g:116:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// VSLTreeParser.g:117:5: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] )
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
			case ARELEM:
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
					// VSLTreeParser.g:118:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression452); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression458);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression465);
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
					// VSLTreeParser.g:126:5: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression483); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression489);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression496);
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
					// VSLTreeParser.g:134:5: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression514); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression520);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression527);
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
					// VSLTreeParser.g:142:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression545); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression551);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression558);
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
					// VSLTreeParser.g:150:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression580);
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
	// VSLTreeParser.g:156:1: array_elem[SymbolTable symTab] returns [ExpAttribute expAtt] : ^( ARELEM IDENT e= expression[symTab] ) ;
	public final ExpAttribute array_elem(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree IDENT2=null;
		ExpAttribute e =null;

		try {
			// VSLTreeParser.g:157:2: ( ^( ARELEM IDENT e= expression[symTab] ) )
			// VSLTreeParser.g:158:2: ^( ARELEM IDENT e= expression[symTab] )
			{
			match(input,ARELEM,FOLLOW_ARELEM_in_array_elem605); 
			match(input, Token.DOWN, null); 
			IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_array_elem608); 
			pushFollow(FOLLOW_expression_in_array_elem612);
			e=expression(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


					Operand3a o = symTab.lookup((IDENT2!=null?IDENT2.getText():null));
				    if(o == null){
				       System.err.println("Error: variable \"" + (IDENT2!=null?IDENT2.getText():null) + "\" is not declared.");
				    }
				    if(!o.isArray()){
				    	System.err.println("Error: variable \"" + (IDENT2!=null?IDENT2.getText():null) + "\" is not an array");
				    }
					VarSymbol temp = SymbDistrib.newTemp();
					Code3a code = Code3aGenerator.genTabVar(temp, o, e);
				    expAtt = new ExpAttribute(o.type, code, temp);
			    
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
	// $ANTLR end "array_elem"



	// $ANTLR start "primary_exp"
	// VSLTreeParser.g:173:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT |a= array_elem[symTab] );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER3=null;
		CommonTree IDENT4=null;
		ExpAttribute a =null;

		try {
			// VSLTreeParser.g:174:5: ( INTEGER | IDENT |a= array_elem[symTab] )
			int alt6=3;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt6=1;
				}
				break;
			case IDENT:
				{
				alt6=2;
				}
				break;
			case ARELEM:
				{
				alt6=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// VSLTreeParser.g:175:5: INTEGER
					{
					INTEGER3=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp638); 

					        ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER3!=null?INTEGER3.getText():null)));
					        expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// VSLTreeParser.g:181:5: IDENT
					{
					IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp653); 

					        Operand3a o = symTab.lookup((IDENT4!=null?IDENT4.getText():null));
					        if(o == null){
					           System.err.println("Error: variable \"" + (IDENT4!=null?IDENT4.getText():null) + "\" is not declared.");
					        }
					        expAtt = new ExpAttribute(o.type, new Code3a(), symTab.lookup((IDENT4!=null?IDENT4.getText():null)));
					    
					}
					break;
				case 3 :
					// VSLTreeParser.g:190:2: a= array_elem[symTab]
					{
					pushFollow(FOLLOW_array_elem_in_primary_exp668);
					a=array_elem(symTab);
					state._fsp--;


							expAtt = a;
						
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
	// VSLTreeParser.g:196:1: declaration[SymbolTable symTab] returns [Code3a code] : ^( DECL (dl= decl_list[symTab] ) ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a dl =null;

		try {
			// VSLTreeParser.g:197:5: ( ^( DECL (dl= decl_list[symTab] ) ) )
			// VSLTreeParser.g:198:5: ^( DECL (dl= decl_list[symTab] ) )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration693); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:198:12: (dl= decl_list[symTab] )
			// VSLTreeParser.g:198:13: dl= decl_list[symTab]
			{
			pushFollow(FOLLOW_decl_list_in_declaration700);
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
	// VSLTreeParser.g:204:1: decl_list[SymbolTable symTab] returns [Code3a code] : (di= decl_item[symTab] )+ ;
	public final Code3a decl_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a di =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:209:5: ( (di= decl_item[symTab] )+ )
			// VSLTreeParser.g:210:5: (di= decl_item[symTab] )+
			{
			// VSLTreeParser.g:210:5: (di= decl_item[symTab] )+
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
					// VSLTreeParser.g:210:6: di= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_decl_list739);
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
	// VSLTreeParser.g:217:1: decl_item[SymbolTable symTab] returns [Code3a code] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT5=null;
		CommonTree IDENT6=null;
		CommonTree INTEGER7=null;

		try {
			// VSLTreeParser.g:218:5: ( IDENT | ^( ARDECL IDENT INTEGER ) )
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
					// VSLTreeParser.g:219:5: IDENT
					{
					IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item770); 

							Operand3a o = symTab.lookup((IDENT5!=null?IDENT5.getText():null));
							int currentScope = symTab.getScope();
							if (o != null && o.getScope() == currentScope){
								System.err.println("Error: \"" + (IDENT5!=null?IDENT5.getText():null) + "\" is already declared.");
							} else {
								VarSymbol vs = new VarSymbol(Type.INT, (IDENT5!=null?IDENT5.getText():null), symTab.getScope());
								symTab.insert((IDENT5!=null?IDENT5.getText():null), vs);
								code = Code3aGenerator.genVar(vs);
							}
						
					}
					break;
				case 2 :
					// VSLTreeParser.g:232:5: ^( ARDECL IDENT INTEGER )
					{
					match(input,ARDECL,FOLLOW_ARDECL_in_decl_item783); 
					match(input, Token.DOWN, null); 
					IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item785); 
					INTEGER7=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item787); 
					match(input, Token.UP, null); 


							Operand3a o = symTab.lookup((IDENT6!=null?IDENT6.getText():null));
							int currentScope = symTab.getScope();
							if (o != null && o.getScope() == currentScope){
								System.err.println("Error: variable \"" + (IDENT6!=null?IDENT6.getText():null) + "\" is already declared.");
							} else {
								ArrayType at = new ArrayType(Type.INT, Integer.parseInt((INTEGER7!=null?INTEGER7.getText():null)));
								VarSymbol vs = new VarSymbol(at, (IDENT6!=null?IDENT6.getText():null), symTab.getScope());
								symTab.insert((IDENT6!=null?IDENT6.getText():null), vs);
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
	// VSLTreeParser.g:248:1: print_list[SymbolTable symTab] returns [Code3a code] : (pi= print_item[symTab] )+ ;
	public final Code3a print_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a pi =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:253:5: ( (pi= print_item[symTab] )+ )
			// VSLTreeParser.g:254:5: (pi= print_item[symTab] )+
			{
			// VSLTreeParser.g:254:5: (pi= print_item[symTab] )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==DIV||LA9_0==IDENT||LA9_0==INTEGER||(LA9_0 >= MINUS && LA9_0 <= MUL)||LA9_0==PLUS||LA9_0==TEXT||LA9_0==ARELEM) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// VSLTreeParser.g:254:6: pi= print_item[symTab]
					{
					pushFollow(FOLLOW_print_item_in_print_list822);
					pi=print_item(symTab);
					state._fsp--;


							code.append(pi);
						
					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
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
	// VSLTreeParser.g:261:1: print_item[SymbolTable symTab] returns [Code3a code] : ( TEXT |e= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree TEXT8=null;
		ExpAttribute e =null;

		try {
			// VSLTreeParser.g:262:2: ( TEXT |e= expression[symTab] )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==TEXT) ) {
				alt10=1;
			}
			else if ( (LA10_0==DIV||LA10_0==IDENT||LA10_0==INTEGER||(LA10_0 >= MINUS && LA10_0 <= MUL)||LA10_0==PLUS||LA10_0==ARELEM) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// VSLTreeParser.g:263:2: TEXT
					{
					TEXT8=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item849); 

							LabelSymbol ls = SymbDistrib.builtinPrintS;
							Data3a data = new Data3a((TEXT8!=null?TEXT8.getText():null));
							code = Code3aGenerator.genArg(data.getLabel());
							code.appendData(data);
							code.append(Code3aGenerator.genCall(ls));
						
					}
					break;
				case 2 :
					// VSLTreeParser.g:272:2: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item862);
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
	// VSLTreeParser.g:281:1: read_list[SymbolTable symTab] returns [Code3a code] : (ri= read_item[symTab] )+ ;
	public final Code3a read_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a ri =null;


		    code = new Code3a();

		try {
			// VSLTreeParser.g:286:5: ( (ri= read_item[symTab] )+ )
			// VSLTreeParser.g:287:5: (ri= read_item[symTab] )+
			{
			// VSLTreeParser.g:287:5: (ri= read_item[symTab] )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==IDENT) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// VSLTreeParser.g:287:6: ri= read_item[symTab]
					{
					pushFollow(FOLLOW_read_item_in_read_list896);
					ri=read_item(symTab);
					state._fsp--;


							code.append(ri);
						
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
	// $ANTLR end "read_list"



	// $ANTLR start "read_item"
	// VSLTreeParser.g:294:1: read_item[SymbolTable symTab] returns [Code3a code] : IDENT ;
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT9=null;

		try {
			// VSLTreeParser.g:295:2: ( IDENT )
			// VSLTreeParser.g:296:2: IDENT
			{
			IDENT9=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item923); 

					Operand3a o = symTab.lookup((IDENT9!=null?IDENT9.getText():null));
					if(o == null){
						System.err.println("Error: variable \"" + (IDENT9!=null?IDENT9.getText():null) + "\" is not declared.");
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
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement94 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement98 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement101 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_KW_in_statement120 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement125 = new BitSet(new long[]{0x0000021044008020L});
	public static final BitSet FOLLOW_statement_in_statement147 = new BitSet(new long[]{0x0000021044008028L});
	public static final BitSet FOLLOW_statement_in_statement169 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement215 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement221 = new BitSet(new long[]{0x0000021044008020L});
	public static final BitSet FOLLOW_statement_in_statement242 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement261 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_list_in_statement267 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_KW_in_statement278 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_list_in_statement284 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_block328 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block347 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block352 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block371 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block375 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list410 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list415 = new BitSet(new long[]{0x0000021044008028L});
	public static final BitSet FOLLOW_PLUS_in_expression452 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression458 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_expression465 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression483 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression489 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_expression496 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression514 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression520 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_expression527 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression545 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression551 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_expression558 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression580 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARELEM_in_array_elem605 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_array_elem608 = new BitSet(new long[]{0x0000008002C14200L});
	public static final BitSet FOLLOW_expression_in_array_elem612 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp653 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_elem_in_primary_exp668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECL_in_declaration693 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_list_in_declaration700 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_decl_item_in_decl_list739 = new BitSet(new long[]{0x0000004000004002L});
	public static final BitSet FOLLOW_IDENT_in_decl_item770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item783 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item785 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item787 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_print_item_in_print_list822 = new BitSet(new long[]{0x0000008202C14202L});
	public static final BitSet FOLLOW_TEXT_in_print_item849 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item862 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_item_in_read_list896 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_IDENT_in_read_item923 = new BitSet(new long[]{0x0000000000000002L});
}
