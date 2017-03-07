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
		      } else if (matcher.group(TokenType.WHITESPACE.name()) != null)
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
