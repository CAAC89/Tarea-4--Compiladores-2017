import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
	
	public static enum TokenType {
	    // Token types cannot have underscores
	    NUMBER("-?[0-9]+"), BINARYOP("[*|/|+|-]"), WHITESPACE("[ \t\f\r\n]+"),PROGRAM("PROGRAM"),
	    BEGIN("BEGIN"),END("END"),VAR("VAR"),IF("IF"),THEN("THEN"),ELSE("ELSE"),WHILE("WHILE"),
	    WriteLn("WriteLn"),Write("Write"),ReadLn("ReadLn"),abs("abs"),sqrt("sqrt"),DO("do"),
	    uses("uses"),MOD("MOD"),INC("INC"),FOR("for"),to("to"),LeftParent("("),RightParent(")"),
	    pc(";"),c(","),i(":"),INTEGER("INTEGER"),ii(":="),REAL("REAL"),iii("=");

	    public final String pattern;

	    private TokenType(String pattern) {
	      this.pattern = pattern;
	    }
	  }

	  public static class Token {
	    public TokenType type;
	    public String data;

	    public Token(TokenType type, String data) {
	      this.type = type;
	      this.data = data;
	    }

	    @Override
	    public String toString() {
	      return String.format("(%s %s)", type.name(), data);
	    }
	  }
	  
	  public static ArrayList<Token> lex(String input) {
		    // The tokens to return
		    ArrayList<Token> tokens = new ArrayList<Token>();

		    // Lexer logic begins here
		    StringBuffer tokenPatternsBuffer = new StringBuffer();
		    for (TokenType tokenType : TokenType.values())
		      tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
		    Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));

		    // Begin matching tokens
		    Matcher matcher = tokenPatterns.matcher(input);
		    while (matcher.find()) {
		      if (matcher.group(TokenType.NUMBER.name()) != null) {
		        tokens.add(new Token(TokenType.NUMBER, matcher.group(TokenType.NUMBER.name())));
		        continue;
		      } else if (matcher.group(TokenType.BINARYOP.name()) != null) {
		        tokens.add(new Token(TokenType.BINARYOP, matcher.group(TokenType.BINARYOP.name())));
		        continue;
		      } else if(matcher.group(TokenType.PROGRAM.name()) != null){
		    	  tokens.add(new Token(TokenType.PROGRAM,matcher.group(TokenType.PROGRAM.name())));
		      } else if(matcher.group(TokenType.BEGIN.name()) != null){
		    	  tokens.add(new Token(TokenType.BEGIN,matcher.group(TokenType.BEGIN.name())));
		      } else if(matcher.group(TokenType.END.name()) != null){
		    	  tokens.add(new Token(TokenType.END,matcher.group(TokenType.END.name())));
		      } else if(matcher.group(TokenType.VAR.name()) != null){
		    	  tokens.add(new Token(TokenType.VAR,matcher.group(TokenType.VAR.name())));
		      } else if(matcher.group(TokenType.IF.name()) != null){
		    	  tokens.add(new Token(TokenType.IF,matcher.group(TokenType.IF.name())));
		      } else if(matcher.group(TokenType.THEN.name()) != null){
		    	  tokens.add(new Token(TokenType.THEN,matcher.group(TokenType.THEN.name())));
		      }  else if(matcher.group(TokenType.ELSE.name()) != null){
		    	  tokens.add(new Token(TokenType.ELSE,matcher.group(TokenType.ELSE.name())));
		      }  else if(matcher.group(TokenType.WHILE.name()) != null){
		    	  tokens.add(new Token(TokenType.WHILE,matcher.group(TokenType.WHILE.name())));
		      } else if(matcher.group(TokenType.WriteLn.name()) != null){
		    	  tokens.add(new Token(TokenType.WriteLn,matcher.group(TokenType.WriteLn.name())));
		      } else if(matcher.group(TokenType.Write.name()) != null){
		    	  tokens.add(new Token(TokenType.Write,matcher.group(TokenType.Write.name())));
		      } else if(matcher.group(TokenType.ReadLn.name()) != null){
		    	  tokens.add(new Token(TokenType.ReadLn,matcher.group(TokenType.ReadLn.name())));
		      } else if(matcher.group(TokenType.abs.name()) != null){
		    	  tokens.add(new Token(TokenType.abs,matcher.group(TokenType.abs.name())));
		      } else if(matcher.group(TokenType.sqrt.name()) != null){
		    	  tokens.add(new Token(TokenType.sqrt,matcher.group(TokenType.sqrt.name())));
		      } else if(matcher.group(TokenType.DO.name()) != null){
		    	  tokens.add(new Token(TokenType.DO,matcher.group(TokenType.DO.name())));
		      } else if(matcher.group(TokenType.uses.name()) != null){
		    	  tokens.add(new Token(TokenType.uses,matcher.group(TokenType.uses.name())));
		      } else if(matcher.group(TokenType.MOD.name()) != null){
		    	  tokens.add(new Token(TokenType.MOD,matcher.group(TokenType.MOD.name())));
		      } else if(matcher.group(TokenType.INC.name()) != null){
		    	  tokens.add(new Token(TokenType.INC,matcher.group(TokenType.INC.name())));
		      } else if(matcher.group(TokenType.FOR.name()) != null){
		    	  tokens.add(new Token(TokenType.FOR,matcher.group(TokenType.FOR.name())));
		      } else if(matcher.group(TokenType.to.name()) != null){
		    	  tokens.add(new Token(TokenType.to,matcher.group(TokenType.to.name())));
		      } else if(matcher.group(TokenType.LeftParent.name()) != null){
		    	  tokens.add(new Token(TokenType.LeftParent,matcher.group(TokenType.LeftParent.name())));
		      } else if(matcher.group(TokenType.RightParent.name()) != null){
		    	  tokens.add(new Token(TokenType.RightParent,matcher.group(TokenType.RightParent.name())));
		      } else if(matcher.group(TokenType.pc.name()) != null){
		    	  tokens.add(new Token(TokenType.pc,matcher.group(TokenType.pc.name())));
		      } else if(matcher.group(TokenType.c.name()) != null){
		    	  tokens.add(new Token(TokenType.c,matcher.group(TokenType.c.name())));
		      } else if(matcher.group(TokenType.i.name()) != null){
		    	  tokens.add(new Token(TokenType.i,matcher.group(TokenType.i.name())));
		      } else if(matcher.group(TokenType.INTEGER.name()) != null){
		    	  tokens.add(new Token(TokenType.INTEGER,matcher.group(TokenType.INTEGER.name())));
		      } else if(matcher.group(TokenType.ii.name()) != null){
		    	  tokens.add(new Token(TokenType.ii,matcher.group(TokenType.ii.name())));
		      } else if(matcher.group(TokenType.REAL.name()) != null){
		    	  tokens.add(new Token(TokenType.REAL,matcher.group(TokenType.REAL.name())));
		      } else if(matcher.group(TokenType.iii.name()) != null){
		    	  tokens.add(new Token(TokenType.iii,matcher.group(TokenType.iii.name())));
		      } 
		      
		      else if (matcher.group(TokenType.WHITESPACE.name()) != null)
		      continue;
		    }

		    return tokens;
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "11 + 22 - 33";

	    // Create tokens and print tyhem
	    ArrayList<Token> tokens = lex(input);
	    for (Token token : tokens)
	      System.out.println(token);
	    
	}

}
