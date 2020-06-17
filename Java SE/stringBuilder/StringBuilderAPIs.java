package stringBuilder;

public class StringBuilderAPIs {
	public static void main(String[] args) {
		String string = "好好学习Java！";
		//默认空串
		StringBuilder builder = new StringBuilder();
		System.out.println(builder);
		builder = new StringBuilder(string);
		System.out.println(builder);
		/**
		 * 增
		 * append(String str)方法：在字符串末尾追加内容
		 * 好好学习java，为了找个好工作!
		 * 
		 */
		builder.append("，为了找个好工作");
		System.out.println(builder);
		
		/**
		 * 替换
		 * replace(int start, int end, String str1)
		 * 替换指定范围内的字符串 
		 */
		builder.replace(8, 17, "，就是为了改变世界!");
		System.out.println(builder);
		
		
		/**
		 * 删除
		 * delete(int start, int end)
		 * 删除指定范围的字符串
		 */
		builder.delete(0, 8);
		System.out.println(builder);
		
		/**
		 * 插入
		 * insert(int start, String str1)
		 * 在指定范围插入字符串,
		 */
		builder.insert(0, "活着");
		System.out.println(builder);
	}
}
