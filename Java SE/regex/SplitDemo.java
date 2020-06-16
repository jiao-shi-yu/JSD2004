package regex;

public class SplitDemo {
	public static void main(String[] args) {
		String str = "A, B, C";
		String[] letters = str.split(",\\s");
		for (String letter : letters) {
			System.out.println(letter);
		}
	}
}
