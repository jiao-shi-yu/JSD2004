package string.api;

public class IndexOfDemo {
	public static void main(String[] args) {
		String str = "Thinking in java!";
		int i = str.indexOf("i");
		System.out.println(i);
		i = str.indexOf("X");
		System.out.println(i);
		/**
		 * 从指定位置开始查找字符
		 */
		i = str.indexOf('i', 3);
		System.out.println(i);
		i = str.indexOf('i', 6);
		System.out.println(i);
		i = str.indexOf('i', 10);
		System.out.println(i);
		
		/**
		 * 查找字符串串
		 */
		i = str.indexOf("in");
		System.out.println(i);
		
		/**
		 * 从指定位置查找字符串
		 */
		i = str.indexOf("in", 3);
		System.out.println(i);
		
		/**
		 * 找不到，返回-1
		 */
		i = str.indexOf("OK");
		System.out.println(i);
	}
}
