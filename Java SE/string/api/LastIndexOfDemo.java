package string.api;

public class LastIndexOfDemo {
	public static void main(String[] args) {
		String str = "Thinking in Java!";
					//01234567890123456
		int i = str.lastIndexOf("in");	// -9
		System.out.println(i);
		i = str.lastIndexOf("In");    	// -1
		System.out.println(i);
		
		int a = str.lastIndexOf('a');
		System.out.println(a);			// 15
	}
}
