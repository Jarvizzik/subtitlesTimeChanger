import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserCommand extends Command {

	private Integer changeTimeInSeconds;

	public ParserCommand(Integer changeTimeInSeconds) {
		this.changeTimeInSeconds = changeTimeInSeconds;
	}

	public Integer getChangeTimeInSeconds() {
		return changeTimeInSeconds;
	}

	@Override
	public void execute(String path) throws IOException {

		String regex = "\\d{2}:\\d{2}:\\d{2}";
		parse(regex, this.getChangeTimeInSeconds());

	}

	public void parse(String regex, Integer changeTimeInSeconds) throws IOException {
		Pattern pattern = Pattern.compile(regex);
		
		while ((content = reader.readLine()) != null) {
			Matcher matcher = pattern.matcher(content);
			
			while (matcher.find()) {
				String time = matcher.group();
				content = content.replace(time, changeTime(time, changeTimeInSeconds));
			}
			parsedContent += content + System.lineSeparator();
		}
	}

	public String changeTime(String time, int changer) {
		String[] timeUnits = time.split(":");
		int hours = Integer.valueOf(timeUnits[0]);
		int minutes = Integer.valueOf(timeUnits[1]);
		int seconds = Integer.valueOf(timeUnits[2]);

		if (seconds + changer >= 60) {

			if (minutes + 1 >= 60) {
				hours++;
				minutes = 0;
				seconds = changer - (60 - seconds);
			} else {
				minutes++;
				seconds = changer - (60 - seconds);
			}
		} else {
			seconds += changer;
		}
		String newTime = interpretToString(hours, minutes, seconds);
		return newTime;
	}

	public String interpretToString(int hours, int minutes, int seconds) {
		String hoursString = "0" + hours;
		String minutesString = "" + ((minutes >= 10) ? minutes : ("0" + minutes));
		String secondsString = "" + ((seconds >= 10) ? seconds : ("0" + seconds));
		return hoursString + ":" + minutesString + ":" + secondsString;
	}
}
