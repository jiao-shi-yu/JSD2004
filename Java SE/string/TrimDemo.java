package string;

public class TrimDemo {
	public static void main(String[] args) {
		String str = "\n\t   С��  \n";
		System.out.println("str:" + str);
		str = str.trim();
		System.out.println("strTrimed:" + str);
		
		
		String name = "robin  ";
		name = name.trim();
		if (name.equals("robin")) {
			System.out.println("�û�������");
		} else {
			System.out.println("�û���������");
		}
	}
}
