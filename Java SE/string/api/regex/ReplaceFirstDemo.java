package string.api.regex;

public class ReplaceFirstDemo {
	public static void main(String[] args) {
		String line = "我去上学，我去吃饭，我去看电影";
		String regex = "我[去]";
		line = line.replaceFirst(regex, "**");
		System.out.println(line); 
		// **上学，我去吃饭，我去看电影

	}
}
