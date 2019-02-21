import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadCommand extends Command {

	@Override
	public void execute(String path) throws FileNotFoundException {
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
	}
}
