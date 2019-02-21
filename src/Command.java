import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Command {
	
	public static BufferedReader reader;
	public static String content;
	public static String parsedContent = "";
	
	abstract void execute(String path) throws IOException;
	
}
