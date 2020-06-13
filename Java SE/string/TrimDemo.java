package string;

public class TrimDemo {
	public static void main(String[] args) {
		String str = "\n\t   小猪  \n";
		System.out.println("str:" + str);
		str = str.trim();
		System.out.println("strTrimed:" + str);
		
		
		String name = "robin  ";
		name = name.trim();
		if (name.equals("robin")) {
			System.out.println("用户名存在");
		} else {
			System.out.println("用户名不存在");
		}
	}
}
