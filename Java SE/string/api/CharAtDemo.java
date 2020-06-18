package string.api;

public class CharAtDemo {
	public static void main(String[] args) {
		String str = "Thinking in Java";
		//            01234567890123456
		char c = str.charAt(12);	// J
		System.out.println(c);
		/**
		 * 如果指定的下标过大，会出现数组下标越界异常
		 */
//		c = str.charAt(99);
		/**
		 * 案例：统计一下str中有几个i字符？
		 */
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i)=='i') {
				count ++;
			}
		}
		// Thinking in Java中有3个i字符
		System.out.println(str+"中有"+count+"个i字符");
	}
}
