 package string;

public class StringDemo1 {
	public static void main(String[] args) {
		String s1 = "Thinking";
		
		String s2 = " in java!";
		String s3 = s1 + s2;
		System.out.println(s3);
		String s4 = "Thinking";
		s4 += " in java!";
		System.out.println(s4);
		// 原字符串不改变
		s4.toUpperCase();
		System.out.println(s4);
	}
}
