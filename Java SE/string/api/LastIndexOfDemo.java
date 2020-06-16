package string.api;

public class LastIndexOfDemo {
	public static void main(String[] args) {
		String str = "Thinking in Java!";
		int i = str.lastIndexOf("in");
		System.out.println(i);
		i = str.lastIndexOf("In");
		System.out.println(i);
	}
}
