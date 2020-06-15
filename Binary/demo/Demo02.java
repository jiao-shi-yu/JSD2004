package demo;

public class Demo02 {
	public static void main(String[] args) {
		// Java 7 开始支持2进制直接量 0b
		int n = 0b110010;
		System.out.println("十进制n: " + n);
		System.out.println("二进制n： " + Integer.toBinaryString(n));
		
		/**
		 * 二进制书写冗长麻烦
		 */
		n = 0b1010101001010111000;
		System.out.println(Integer.toBinaryString(n));
		
		/**
		 * int 是32位，超过32位要用long
		 */
		long l = 0b0101_0101_0101_0101_0101_0101_0101_0101_0101_0101L;
		System.out.println(l);
		
		/**
		 * 八进制字面量以0开头
		 */
		int m = 072;
		System.out.println(m);
	}
}
