package demo;

public class MaskCodeDemo {
	public static void main(String[] args) {
		int n = 0x67f415ea;
		int m = 0xff;
		int k = n & m;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(k));
	}
}
