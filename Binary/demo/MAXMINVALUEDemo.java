package demo;

public class MAXMINVALUEDemo {
	public static void main(String[] args) {
		// ��������ֵ
		int max = Integer.MAX_VALUE;
		System.out.println(max);
		System.out.println(Integer.toBinaryString(max));
		// �������Сֵ
		int min = Integer.MIN_VALUE;
		System.out.println(min);
		System.out.println(Integer.toBinaryString(min));
		// max + 1 == min
		System.out.println(Integer.toBinaryString(max+1));
		
		
		long lmin = Long.MIN_VALUE;
		long lmax = Long.MAX_VALUE;
		
		System.out.println("lmin: " + Long.toBinaryString(lmin));
		System.out.println(Long.toBinaryString(lmax));
		
		/**
		 * -1 �ı���
		 */
		int i = -1;
		int l = -1;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Long.toBinaryString(l));
		
		int k = (int)lmin; // long ����Сֵ�ǳ����� int �ķ�Χ��
		System.out.println("k: " + Integer.toBinaryString(k));
		
		
		
		
	}
}
