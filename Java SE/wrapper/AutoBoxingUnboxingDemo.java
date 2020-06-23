package wrapper;

public class AutoBoxingUnboxingDemo {
	public static void main(String[] args) {
		Integer integer = 1; // 自动装箱
		double d = integer;  // 自动拆箱
		
		Integer integer2 = Integer.valueOf(2);
		double d2 = integer2.intValue();
		
		Double d3 = 3.0;
//		int i3 = (int)d3;
		
		Double d4 = 4.0;
		int i4 = (int)(d4.doubleValue());
		
		System.out.println(i4);
		
		
	}
}
