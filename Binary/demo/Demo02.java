package demo;

public class Demo02 {
	public static void main(String[] args) {
		// Java 7 ��ʼ֧��2����ֱ���� 0b
		int n = 0b110010;
		System.out.println("ʮ����n: " + n);
		System.out.println("������n�� " + Integer.toBinaryString(n));
		
		/**
		 * ��������д�߳��鷳
		 */
		n = 0b1010101001010111000;
		System.out.println(Integer.toBinaryString(n));
		
		/**
		 * int ��32λ������32λҪ��long
		 */
		long l = 0b0101_0101_0101_0101_0101_0101_0101_0101_0101_0101L;
		System.out.println(l);
		
		/**
		 * �˽�����������0��ͷ
		 */
		int m = 072;
		System.out.println(m);
	}
}
