package string;

public class CharAtDemo {
	public static void main(String[] args) {
		String str = "Thinking in Java";
		char c = str.charAt(12);
		System.out.println(c);
		/**
		 * ���ָ�����±���󣬻���������±�Խ���쳣
		 */
//		c = str.charAt(99);
		/**
		 * ������ͳ��һ��str���м���i�ַ���
		 */
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i)=='i') {
				count ++;
			}
		}
		System.out.println(str+"����"+count+"��i�ַ�");
	}
}
