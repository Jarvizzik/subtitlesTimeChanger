import java.io.File;
import java.io.IOException;

public class SubtitlesTimeChangerDemo {
	public static void main(String[] args) throws IOException {
		
		String path = "subtitlesS4E1.txt";
		Integer changeTimeInSeconds = 40;
		FileCommander fileCommander = new FileCommander();
		
		fileCommander.addCommand(new ReadCommand());
		fileCommander.addCommand(new ParserCommand(changeTimeInSeconds));
		fileCommander.addCommand(new WriteCommand());
		
		fileCommander.process(path);
		
	}
}
