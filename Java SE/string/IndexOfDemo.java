package string;

public class IndexOfDemo {
	public static void main(String[] args) {
		String str = "Thinking in java!";
		int i = str.indexOf("i");
		System.out.println(i);
		i = str.indexOf("X");
		System.out.println(i);
		/**
		 * ��ָ��λ�ÿ�ʼ�����ַ�
		 */
		i = str.indexOf('i', 3);
		System.out.println(i);
		i = str.indexOf('i', 6);
		System.out.println(i);
		i = str.indexOf('i', 10);
		System.out.println(i);
		
		/**
		 * �����ַ�����
		 */
		i = str.indexOf("in");
		System.out.println(i);
		
		/**
		 * ��ָ��λ�ò����ַ���
		 */
		i = str.indexOf("in", 3);
		System.out.println(i);
		
		/**
		 * �Ҳ���������-1
		 */
		i = str.indexOf("OK");
		System.out.println(i);
	}
}
