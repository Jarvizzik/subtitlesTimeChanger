import java.io.FileWriter;
import java.io.IOException;

public class WriteCommand extends Command {

	@Override
	public void execute(String path) {
		writeInFile(path);
	}

	public void writeInFile(String path) {
		try (FileWriter fileWriter = new FileWriter(path)) {
			fileWriter.write(parsedContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
