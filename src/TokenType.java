
public enum TokenType {
	
	NUMBER("-?[0-9]+"),
	BINARYOP("[*|/|+|-]"),
	WHITESPACE("[ \t\f\r\n]+");

    public final String pattern;

    private TokenType(String pattern) {
      this.pattern = pattern;
    }
}
