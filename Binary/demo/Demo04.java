package demo;

public class Demo04 {
	public static void main(String[] args) {
		int n = -9;
		System.out.println(Integer.toBinaryString(n));
		for (int i = -1; i > -100; i--) {
			System.out.println(i + ": " + Integer.toBinaryString(i));
		}
	}
}
