package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

"program"   { return new_symbol(sym.PROGRAM, yytext()); }
"break" 	{ return new_symbol(sym.BREAK, yytext()); }
"class" 	{ return new_symbol(sym.CLASS, yytext()); }
"else" 	{ return new_symbol(sym.ELSE, yytext()); }
"const" 	{ return new_symbol(sym.CONST, yytext()); }
"if" 	{ return new_symbol(sym.IF, yytext()); }
"new" 	{ return new_symbol(sym.NEW, yytext()); }
"print" 	{ return new_symbol(sym.PRINT, yytext()); }
"read" 	{ return new_symbol(sym.READ, yytext()); }
"return" 	{ return new_symbol(sym.RETURN, yytext()); }
"void" 	{ return new_symbol(sym.VOID, yytext()); }
"while" 	{ return new_symbol(sym.WHILE, yytext()); }
"extends" 	{ return new_symbol(sym.EXTENDS, yytext()); }

"+" 	{ return new_symbol(sym.PLUS, yytext()); }
"-" 	{ return new_symbol(sym.MINUS, yytext()); }
"*" 	{ return new_symbol(sym.PUTA, yytext()); }
"/" 	{ return new_symbol(sym.PODELJENO, yytext()); }
"%" 	{ return new_symbol(sym.PROCENAT, yytext()); }
"==" 	{ return new_symbol(sym.JEDNAKO_JEDNAKO, yytext()); }
"!=" 	{ return new_symbol(sym.UZVICNIK_JEDNAKO, yytext()); }
">" 	{ return new_symbol(sym.VECE, yytext()); }
">=" 	{ return new_symbol(sym.VECE_JEDNAKO, yytext()); }
"<" 	{ return new_symbol(sym.MANJE, yytext()); }
"<=" 	{ return new_symbol(sym.MANJE_JEDNAKO, yytext()); }
"&&" 	{ return new_symbol(sym.I, yytext()); }
"||" 	{ return new_symbol(sym.ILI, yytext()); }
"=" 	{ return new_symbol(sym.JEDNAKO, yytext()); }
"++" 	{ return new_symbol(sym.PLUS_PLUS, yytext()); }
"--" 	{ return new_symbol(sym.MINUS_MINUS, yytext()); }
";" 	{ return new_symbol(sym.TACKA_ZAREZ, yytext()); }
"," 	{ return new_symbol(sym.ZAREZ, yytext()); }
"." 	{ return new_symbol(sym.TACKA, yytext()); }
"(" 	{ return new_symbol(sym.O_ZAG, yytext()); }
")" 	{ return new_symbol(sym.Z_ZAG, yytext()); }
"[" 	{ return new_symbol(sym.O_UGL_ZAG, yytext()); }
"]" 	{ return new_symbol(sym.Z_UGL_ZAG, yytext()); }
"{" 	{ return new_symbol(sym.O_VIT_ZAG, yytext()); }
"}" 	{ return new_symbol(sym.Z_VIT_ZAG, yytext()); }


("true"|"false") 	            { return new_symbol(sym.BOOL_CONST, yytext()); }
"'"[\040-\176]"'"               { return new_symbol (sym.CHAR_CONST, new Character (yytext().charAt(1)));}
"\"".*"\""                      { return new_symbol (sym.STR_CONST, new String (yytext()));}
"//" 		     { yybegin(COMMENT); }
<COMMENT> .      { yybegin(COMMENT); }
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

[0-9]+  { return new_symbol(sym.NUMBER, new Integer (yytext())); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	{return new_symbol (sym.IDENT, yytext()); }

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }






