package string;

public class SubstringDemo {
	public static void main(String[] args) {
		String str = "Thinking in Java!";
		//            01234567890123456
		
		// begin index
		String subStr = str.substring(1);
		System.out.println(subStr);
		// begin index, end index
		subStr = str.substring(1, 2);
		System.out.println(subStr);
		// begin index, begin index + n
		subStr = str.substring(0, 0+5);
		System.out.println(subStr);
		
		/**
		 * ����:���һ��ͼƬ�Ƿ�Ϊ.png
		 */
		String file = "demo.png";
		String suffix = file.substring(file.length()-4);
		if (!suffix.equals(".png")) {
			System.out.println("file����ͼƬ");
		} else {
			System.out.println("file��ͼƬ");
		}
		
	}
}
