import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
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
}
