package stringBuilder;
/**
 * 测试String和StringBuilder的性能
 * @author jiao_
 *
 */
public class StringStringBuilderDemo {
	public static void main(String[] args) {
		
		
		long t1 = System.nanoTime();
		String str = "ABC";
		for (int i = 0; i < 50000; i++) {
			str += "A";
		}
		long t2 = System.nanoTime();
		long t3 = System.nanoTime();
		StringBuilder strBuilder = new StringBuilder("ABC");
		for (int i = 0; i < 50000; i++) {
			strBuilder.append("A");
		}
		long t4 = System.nanoTime();
		System.out.println((t2 - t1) + " : " + (t4 - t3));
	}
}
