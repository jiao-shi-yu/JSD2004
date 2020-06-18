package string.api;

public class IndexOfDemo {
	public static void main(String[] args) {
		String str = "Thinking in java!";
				   // 01234567890123456
		int i = str.indexOf("i"); 	// 2
		System.out.println(i);  	
		i = str.indexOf("X");		// -1
		System.out.println(i);  
		/**
		 * 从指定位置开始查找字符
		 */
		i = str.indexOf('i', 3);	// 5
		System.out.println(i);
		i = str.indexOf('i', 6);	// 9
		System.out.println(i);
		i = str.indexOf('i', 10);	// -1
		System.out.println(i);
		
		/**
		 * 查找字符串串
		 */
		i = str.indexOf("in");		// 9
		System.out.println(i);
		
		/**
		 * 从指定位置查找字符串
		 */
		i = str.indexOf("in", 3);	// 5
		System.out.println(i);
		
		/**
		 * 找不到，返回-1
		 */
		i = str.indexOf("OK");		// -1
		System.out.println(i);
	}
}
