
public enum TokenType {

	NUMBER("-?[0-9]+"),
	BINARYOP("[*|/|+|-]"),
	WHITESPACE("[ \t\f\r\n]+"),
//	ID("[a-zA-Z][a-zA-Z0-9]*"),
	PROGRAM("PROGRAM"),
	BEGIN("BEGIN"),
	END("END"),
	VAR("VAR"),
	IF("IF"),
	THEN("THEN"),
	ELSE("ELSE"),
	WHILE("WHILE"),
	WriteLn("WriteLn"),
	Write("Write"),
	ReadLn("ReadLn"),
	abs("abs"),
	sqrt("sqrt"),
	DO("do"),
	uses("uses"),
	MOD("MOD"),
	INC("INC"),
	FOR("for"),
	to("to"),
	pc(";"),
	c(","),
	i(":"),
	INTEGER("INTEGER"),
	ii(":="),
	REAL("REAL"),
	iii("="),
	PI("("),
	PD(")");

	public final String pattern;

	private TokenType(String pattern) {
		this.pattern = pattern;
	}
}
