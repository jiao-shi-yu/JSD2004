package demo;

public class InversePlusOneDemo {
	public static void main(String[] args) {
		/**
		 * 验证补码互补对称
		 * -n = ~n + 1
		 */
		int n = 100;
		int m = ~n + 1;
		System.out.println(m);
		
		n = -120;
		m = ~n + 1;
		System.out.println(m);
		/** 
		 * ~ 反码
		 * 
		 */
		// min 取反得到 max
		// 再加一得到自身
		int min = Integer.MIN_VALUE;
		System.out.println("min: " + min);
		System.out.println("max: " + Integer.MAX_VALUE);
		System.out.println("~min: " + ~min);
		System.out.println("~min+1: " + (~min+1));
	}
}
