import java.io.*;

public class InputManager {
	public static String readFile(String filePath) throws FileNotFoundException, IOException {
		InputStream input = new FileInputStream(filePath);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
		
		String line = buffer.readLine();
		StringBuilder builder = new StringBuilder();
		
		while(line != null) {
			builder.append(line).append("\n");
			line = buffer.readLine();
		}
		
		buffer.close();
		
		String fileContent = builder.toString();
		return fileContent;
	}
}
