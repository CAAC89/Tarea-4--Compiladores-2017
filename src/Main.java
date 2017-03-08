import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		System.out.println("ITCR");
		System.out.println("Ing en Computacion");
		System.out.println("Compiladores e Interpretes");
		System.out.println("Prof. Fabian Fallas Moya");
		System.out.println("Tarea 4");
		System.out.println("Carlos Arguello");
		System.out.println("Saul Zamora");
		System.out.println("");
		System.out.println("Inserte la direccion del archivo Pascal a tokenizar:");
		
		Scanner scanner = new Scanner(System.in);
		System.out.flush();
		String filepath = scanner.nextLine();
		scanner.close();
		
		String fileContents = InputManager.readFile(filepath);

		// Creates token list from input
		ArrayList<Token> tokens = Lexer.lex(fileContents);
		for (Token token : tokens)
			System.out.println(token);

	}
}
