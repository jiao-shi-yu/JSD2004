package regex;

public class MatchesDemo {
	public static void main(String[] args) {
		/**
		 * ʹ��������ʽ��֤��������
		 */
		String email = "fan_cq@tedu.com.cn";
		String regex = "\\w+@\\w+(\\.[a-zA-Z]+)+";
		boolean matched = email.matches(regex);
		if (matched) {
			System.out.println("������");
		} else {
			System.out.println("��������");
		}
		
	}
}
