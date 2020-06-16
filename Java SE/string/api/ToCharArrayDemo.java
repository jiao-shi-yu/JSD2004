package string.api;

public class ToCharArrayDemo {
	public static void main(String[] args) {
		String string = "Hello, Thank you!";
		char[] charArray = string.toCharArray();
		for (char c : charArray) {
			System.out.println(c);
		}
	}
}
