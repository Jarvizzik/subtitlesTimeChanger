import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCommander {

	private List<Command> commands;
	
	public FileCommander() {
		commands = new ArrayList<>();
	}

	public void addCommand(Command command) {
		commands.add(command);
	}

	public void process(String path) throws IOException {

		for (Command command : commands) {
			command.execute(path);
		}
	}

}
