package demo;

public class Demo05 {
	public static void main(String[] args) {
		/**
		 * ��֤���뻥���Գ�
		 * -n = ~n + 1
		 */
		int n = 100;
		int m = ~n + 1;
		System.out.println(m);
		
		n = -120;
		m = ~n + 1;
		System.out.println(m);
		/** 
		 * ~ ����
		 * 
		 */
		// min ȡ���õ� max
		// �ټ�һ�õ�����
		int min = Integer.MIN_VALUE;
		System.out.println("min: " + min);
		System.out.println("max: " + Integer.MAX_VALUE);
		System.out.println("~min: " + ~min);
		System.out.println("~min+1: " + (~min+1));
	}
}
