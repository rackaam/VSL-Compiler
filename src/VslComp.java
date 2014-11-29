import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

/**
 * Entry point of the compiler, containing the <code>main</code> function.
 * 
 * By default, the compiler uses the first argument as the filename of the VSL+
 * file to be compiled.
 * 
 * An optional '-debug' flag can be given as second argument. In this case, some
 * extra debugging messages will be printed during compilation.
 * 
 * @author MLB
 * 
 */
public class VslComp {

	public static void main(String[] args) {

		// Check if user supplied a filename
		/*if (args.length < 1) {
			System.err.println("USAGE: java VslComp <fichier.vsl>");
			System.exit(1);
		}*/

		// Initialize logger and debugging facilities.
		// Useful for printing error messages and debugging.
		//Util.init(args[0], args.length > 1 && args[1].equals("-debug"));

		// We encapsulate the code in a generic try block in order to catch any
		// exception that may be raised.
		try {
			// We give the file as input for ANTLR, which produces a character
			// stream.
			//ANTLRFileStream input = new ANTLRFileStream("/home/matthias/ISTIC/COMP/vsl_comp/tests/testlevel4/level4testfact.vsl");
			ANTLRFileStream input = new ANTLRFileStream("/home/matthias/ISTIC/COMP/vsl_comp/test.vsl");
			// Then, we run the lexer...
			VSLLexer lexer = new VSLLexer(input);
			// To obtain a token stream.
			CommonTokenStream token_stream = new CommonTokenStream(lexer);
			// This token stream is fed to the parser (which will not yet start
			// the parsing).
			VSLParser parser = new VSLParser(token_stream);
			// Here, we start parsing with the top-level rule of the grammar,
			// currently 'expression'.
			// *** NOTE: the following line must be changed whenever the main
			// rule in VSLTreeParser.g is modified. ***
			VSLParser.program_return r = parser.program();
			// The parser produces an AST.
			CommonTree t = (CommonTree) r.getTree();
			// If debugging is on, this prints the resulting tree in LISP
			// notation
			Util.log.fine(t.toStringTree());
			// From the AST, we create a node stream.
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
			// This node stream is fed to the tree parser.
			VSLTreeParser tparser = new VSLTreeParser(nodes);
			try {
				// The tree parser starts in the rule defined by the next line.
				// *** NOTE: the following line must be changed whenever the
				// top-level rule is modified. ***
				Code3a code = tparser.program(new SymbolTable());
				code.print();

				// We prepare the MIPS code generator, which will compile
				// the three-address code into MIPS assembly.
				MIPSCodeGenerator cg = new MIPSCodeGenerator(System.out);

				// NOTE: This call to addStubMain adds the header and
				// footer for the main function.
				// This allows the program to be run using the NachOS
				// emulator.
				// This function must not be present in the final version.
				code = cg.addStubMain(code);

				// Generates the actual MIPS code, printing it to the
				// stream chosen previously (by default, System.out).
				//cg.genCode(code);
				// The rest of the main function are standard error handlers.
			} catch (Exception e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		} catch (FileNotFoundException fnf) {
			System.err.println("exception: " + fnf);
		} catch (RecognitionException re) {
			// This usually indicates the program is syntactically incorrect.
			System.err.println("Recognition exception: " + re);
		} catch (IOException exc) {
			System.out.println("IO exception");
		}
	}

}
