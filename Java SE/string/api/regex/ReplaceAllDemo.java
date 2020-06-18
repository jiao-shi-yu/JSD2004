package string.api.regex;

public class ReplaceAllDemo {
	public static void main(String[] args) {
		String line = "我去上学，我去吃饭，我去看电影";
		String regex = "我[去]";
		line = line.replaceAll(regex, "**");
		System.out.println(line);  
		// **上学，**吃饭，**看电影
	}
}
