package demo;

public class ToBinaryStringDemo {
	public static void main(String[] args) {
		int n = 32; // ���룺100 000
		// n ���ڴ�����һ��2���Ƶ����� 10 0000
		System.out.println(n); // 10 0000 ����ת��Ϊ10�����ַ�����32����
		// Java�ṩ��API��������ʾΪ�����Ƶ��ַ���
		System.out.println(Integer.toBinaryString(n));
		for (int i = 0; i < 100; i++) {
			System.out.println(Integer.toBinaryString(i));
		}
	}
}
