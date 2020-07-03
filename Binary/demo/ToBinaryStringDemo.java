package demo;

public class ToBinaryStringDemo {
	public static void main(String[] args) {
		int n = 32; // 编译：100 000
		// n 在内存中是一个2进制的数字 10 0000
		System.out.println(n); // 10 0000 程序转换为10进制字符串“32”。
		// Java提供了API，可以显示为二进制的字符串
		System.out.println(Integer.toBinaryString(n));
		for (int i = 0; i < 100; i++) {
			System.out.println(Integer.toBinaryString(i));
		}
	}
}
