package string.api;

public class EqualsDemo {
	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = "ABC";
		
		String s3 = new String(s1);
		
		System.out.println(s1==s2);	// true
		System.out.println(s1==s3);	// false
		System.out.println(s1.equals(s3)); //true
		
	}
}
