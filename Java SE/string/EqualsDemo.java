package string;

public class EqualsDemo {
	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = "ABC";
		
		String s3 = new String(s1);
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3));
		
	}
}
