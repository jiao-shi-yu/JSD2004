package wrapper.number;
/**
 * 通过参数，得到某个包装类的实例
 * @author jiao_
 *
 */
public class ValueOfDemo {
	public static void main(String[] args) {
		// 通过基本类型
		Integer a = Integer.valueOf(99);
		System.out.println(a.getClass() + ": " + a);
		// 通过数字字符串
		Integer b = Integer.valueOf("99");
		System.out.println(b.getClass() + ": " + b);
	}
}
