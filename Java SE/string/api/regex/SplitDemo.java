package string.api.regex;

public class SplitDemo {
	public static void main(String[] args) {
		String string = "three two one ready~ go!";
		String[] strings = string.split("\\s");
		for (String str : strings) {
			System.out.println(str);
		}
		System.out.println("--------");
		String[] strings2 = string.split("\\s", 4);
		for (String str2 : strings2) {
			System.out.println(str2);
		}
	}
}
