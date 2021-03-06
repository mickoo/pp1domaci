package rs.ac.bg.etf.pp1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Writer;
import java.util.Scanner;

import java_cup.runtime.Symbol;

public class MJTest {
	
	
	
	public static void main(String[] args) throws IOException {
		
		Reader br = null;
		Writer wr=null;
		
		System.out.println("1.Ispis u konzolu\n");
		System.out.println("2.Ispis u fajl(izlaz.txt)\n");

		int izbor = 1;
		Scanner ut=new Scanner(System.in);
		izbor=ut.nextInt();
		
		
		try {
			
			File sourceCode = new File("test/program.mj");	
			File output=new File("test/izlaz.txt");
			
			br = new BufferedReader(new FileReader(sourceCode));
			wr=new BufferedWriter(new FileWriter(output));
			
			Yylex lexer = new Yylex(br);
			Symbol currToken = null;
			while ((currToken = lexer.next_token()).sym != sym.EOF) {
				if (currToken != null && currToken.value != null)
				{
					if(izbor!=2)System.out.println(currToken.toString() + " " + currToken.value.toString());
					if(izbor!=1)
						{
							wr.write(currToken.toString() + " " + currToken.value.toString());
							wr.append(System.lineSeparator());
						}
					
				}
			}
			
			
		} 
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) {System.out.println("Greska"); }
			if (wr != null) try { wr.close(); } catch (IOException e1) {System.out.println("Greska"); }
		}
	}

}
