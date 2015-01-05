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
		File sourceCode = new File("test/test1.mj");
		//log.info("Compiling source file: " + sourceCode.getAbsolutePath());
		System.out.println("Compiling source file: " + sourceCode.getAbsolutePath());
		
		br = new BufferedReader(new FileReader(sourceCode));
		Yylex lexer = new Yylex(br);
		
		Kontekst k=new Kontekst();
		MJParser p = new MJParser(lexer);
        Symbol s = p.parse();  //pocetak parsiranja
      
       
        System.out.println("Broj CHAR-ova: "+ p.dekChar);
        System.out.println("Broj Nizova: "+ p.dekGlobNizova);
        System.out.println("Broj definicija funkcija: "+ p.defFunkcijaUProgramu);
        System.out.println("Broj definicija unutrasnjih klasa: "+ p.defUnutrasnjihKlasa);
        System.out.println("Broj blokova naredbi: "+ p.blokoviNaredbi);
        System.out.println("Poziv funkcija u Mainu :" + p.pozivFunkcijaUMain);
        System.out.println("Broj NEW naredbi :" + p.brojNewNaredbi);
        System.out.println("Broj izvodjenja :" + p.brojIzvodjenja);
        System.out.println("Broj metoda unutar klase :" + p.defMetodaUnutrasnjihKlasa);
        System.out.println("Broj def atributa unutar klase :" + p.dekPoljaUnutrasnjihKlasa);
        
	} 
	finally {
		if (br != null) try { br.close(); } catch (IOException e1) 
		{/* log.error(e1.getMessage(), e1);*/System.out.println(e1.getMessage()); }
	
	}
}
}
