import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String input = "11 + 22 - 33";

	    // Create tokens and print them
	    ArrayList<Token> tokens = Lexer.lex(input);
	    for (Token token : tokens)
	      System.out.println(token);

	}
}
