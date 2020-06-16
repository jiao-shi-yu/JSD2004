package regex;

public class MatchesDemo {
	public static void main(String[] args) {
		/**
		 * 使用正则表达式验证电子邮箱
		 */
		String email = "fan_cq@tedu.com.cn";
		String regex = "\\w+@\\w+(\\.[a-zA-Z]+)+";
		boolean matched = email.matches(regex);
		if (matched) {
			System.out.println("是邮箱");
		} else {
			System.out.println("不是邮箱");
		}
		
	}
}
