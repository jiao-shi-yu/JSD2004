package string.api;

public class ContainsDemo {
	public static void main(String[] args) {
		String line = "I love you!";
		boolean containsLove = line.contains("love");
		System.out.println("contains love: " + containsLove);
	}
}
