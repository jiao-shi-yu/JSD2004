package stringBuilder;

public class StringBuilderAPIs {
	public static void main(String[] args) {
		String string = "�ú�ѧϰJava��";
		//Ĭ�Ͽմ�
		StringBuilder builder = new StringBuilder();
		System.out.println(builder);
		builder = new StringBuilder(string);
		System.out.println(builder);
		/**
		 * ��
		 * append(String str)���������ַ���ĩβ׷������
		 * �ú�ѧϰjava��Ϊ���Ҹ��ù���!
		 * 
		 */
		builder.append("��Ϊ���Ҹ��ù���");
		System.out.println(builder);
		
		/**
		 * �滻
		 * replace(int start, int end, String str1)
		 * �滻ָ����Χ�ڵ��ַ��� 
		 */
		builder.replace(8, 17, "������Ϊ�˸ı�����!");
		System.out.println(builder);
		
		
		/**
		 * ɾ��
		 * delete(int start, int end)
		 * ɾ��ָ����Χ���ַ���
		 */
		builder.delete(0, 8);
		System.out.println(builder);
		
		/**
		 * ����
		 * insert(int start, String str1)
		 * ��ָ����Χ�����ַ���,
		 */
		builder.insert(0, "����");
		System.out.println(builder);
	}
}
