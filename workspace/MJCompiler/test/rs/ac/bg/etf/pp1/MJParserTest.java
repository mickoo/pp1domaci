package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Logger;

import java_cup.runtime.Symbol;

public class MJParserTest {
	
public static void main(String[] argv) throws Exception{
	//Logger log = Logger.getLogger(MJParserTest.class);
	
	Reader br = null;
	try {
		File sourceCode = new File("test/program.mj");
		//log.info("Compiling source file: " + sourceCode.getAbsolutePath());
		System.out.println("Compiling source file: " + sourceCode.getAbsolutePath());
		
		br = new BufferedReader(new FileReader(sourceCode));
		Yylex lexer = new Yylex(br);
		
		MJParser p = new MJParser(lexer);
        Symbol s = p.parse();  //pocetak parsiranja
        
      //  log.info("Print calls = " + p.printCallCount);
        System.out.println("Broj poziva funkcije PRINT: "+ p.printCallCount);
        
	} 
	finally {
		if (br != null) try { br.close(); } catch (IOException e1) 
		{/* log.error(e1.getMessage(), e1);*/System.out.println(e1.getMessage()); }
	
	}
}
}
