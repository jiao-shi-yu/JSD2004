package string.api;

public class ReplaceDemo {
	public static void main(String[] args) {
		String string = "I love you!";
		char oldChar = 'o';
		char newChar = 'e';
		string = string.replace(oldChar, newChar);
		System.out.println(string);
		// I leve yeu!	
	}
}
