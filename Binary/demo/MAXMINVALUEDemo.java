package demo;

public class MAXMINVALUEDemo {
	public static void main(String[] args) {
		// 补码的最大值
		int max = Integer.MAX_VALUE;
		System.out.println(max);
		System.out.println(Integer.toBinaryString(max));
		// 补码的最小值
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
		 * -1 的编码
		 */
		int i = -1;
		int l = -1;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Long.toBinaryString(l));
		
		int k = (int)lmin; // long 的最小值是超出了 int 的范围的
		System.out.println("k: " + Integer.toBinaryString(k));
		
		
		
		
	}
}
