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
			} else if (matcher.group(TokenType.PROGRAM.name()) != null) {
				tokens.add(new Token(TokenType.PROGRAM, matcher.group(TokenType.PROGRAM.name())));
				continue;
			} else if (matcher.group(TokenType.BEGIN.name()) != null) {
				tokens.add(new Token(TokenType.BEGIN, matcher.group(TokenType.BEGIN.name())));
				continue;
			} else if (matcher.group(TokenType.END.name()) != null) {
				tokens.add(new Token(TokenType.END, matcher.group(TokenType.END.name())));
				continue;
			} else if (matcher.group(TokenType.VAR.name()) != null) {
				tokens.add(new Token(TokenType.VAR, matcher.group(TokenType.VAR.name())));
				continue;
			} else if (matcher.group(TokenType.IF.name()) != null) {
				tokens.add(new Token(TokenType.IF, matcher.group(TokenType.IF.name())));
				continue;
			} else if (matcher.group(TokenType.THEN.name()) != null) {
				tokens.add(new Token(TokenType.THEN, matcher.group(TokenType.THEN.name())));
				continue;
			} else if (matcher.group(TokenType.ELSE.name()) != null) {
				tokens.add(new Token(TokenType.ELSE, matcher.group(TokenType.ELSE.name())));
				continue;
			} else if (matcher.group(TokenType.WHILE.name()) != null) {
				tokens.add(new Token(TokenType.WHILE, matcher.group(TokenType.WHILE.name())));
				continue;
			} else if (matcher.group(TokenType.WriteLn.name()) != null) {
				tokens.add(new Token(TokenType.WriteLn, matcher.group(TokenType.WriteLn.name())));
				continue;
			} else if (matcher.group(TokenType.Write.name()) != null) {
				tokens.add(new Token(TokenType.Write, matcher.group(TokenType.Write.name())));
				continue;
			} else if (matcher.group(TokenType.ReadLn.name()) != null) {
				tokens.add(new Token(TokenType.ReadLn, matcher.group(TokenType.ReadLn.name())));
				continue;
			} else if (matcher.group(TokenType.abs.name()) != null) {
				tokens.add(new Token(TokenType.abs, matcher.group(TokenType.abs.name())));
				continue;
			} else if (matcher.group(TokenType.sqrt.name()) != null) {
				tokens.add(new Token(TokenType.sqrt, matcher.group(TokenType.sqrt.name())));
				continue;
			} else if (matcher.group(TokenType.DO.name()) != null) {
				tokens.add(new Token(TokenType.DO, matcher.group(TokenType.DO.name())));
				continue;
			} else if (matcher.group(TokenType.uses.name()) != null) {
				tokens.add(new Token(TokenType.uses, matcher.group(TokenType.uses.name())));
				continue;
			} else if (matcher.group(TokenType.MOD.name()) != null) {
				tokens.add(new Token(TokenType.MOD, matcher.group(TokenType.MOD.name())));
				continue;
			} else if (matcher.group(TokenType.INC.name()) != null) {
				tokens.add(new Token(TokenType.INC, matcher.group(TokenType.INC.name())));
				continue;
			} else if (matcher.group(TokenType.FOR.name()) != null) {
				tokens.add(new Token(TokenType.FOR, matcher.group(TokenType.FOR.name())));
				continue;
			} else if (matcher.group(TokenType.to.name()) != null) {
				tokens.add(new Token(TokenType.to, matcher.group(TokenType.to.name())));
				continue;
			} else if (matcher.group(TokenType.pc.name()) != null) {
				tokens.add(new Token(TokenType.pc, matcher.group(TokenType.pc.name())));
				continue;
			} else if (matcher.group(TokenType.c.name()) != null) {
				tokens.add(new Token(TokenType.c, matcher.group(TokenType.c.name())));
				continue;
			} else if (matcher.group(TokenType.i.name()) != null) {
				tokens.add(new Token(TokenType.i, matcher.group(TokenType.i.name())));
				continue;
			} else if (matcher.group(TokenType.INTEGER.name()) != null) {
				tokens.add(new Token(TokenType.INTEGER, matcher.group(TokenType.INTEGER.name())));
				continue;
			} else if (matcher.group(TokenType.ii.name()) != null) {
				tokens.add(new Token(TokenType.ii, matcher.group(TokenType.ii.name())));
				continue;
			} else if (matcher.group(TokenType.REAL.name()) != null) {
				tokens.add(new Token(TokenType.REAL, matcher.group(TokenType.REAL.name())));
				continue;
			} else if (matcher.group(TokenType.iii.name()) != null) {
				tokens.add(new Token(TokenType.iii, matcher.group(TokenType.iii.name())));
				continue;
			} else if (matcher.group(TokenType.ID.name()) != null) {
				tokens.add(new Token(TokenType.ID, matcher.group(TokenType.ID.name())));
				continue;
			} else if (matcher.group(TokenType.STRING.name()) != null) {
				tokens.add(new Token(TokenType.STRING, matcher.group(TokenType.STRING.name())));
				continue;
			} else if (matcher.group(TokenType.COMMENT.name()) != null) {
				tokens.add(new Token(TokenType.COMMENT, matcher.group(TokenType.COMMENT.name())));
				continue;
			}

			else if (matcher.group(TokenType.WHITESPACE.name()) != null)
				continue;
		}

		return tokens;
	}
}
