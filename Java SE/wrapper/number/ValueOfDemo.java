package wrapper.number;
/**
 * ͨ���������õ�ĳ����װ���ʵ��
 * @author jiao_
 *
 */
public class ValueOfDemo {
	public static void main(String[] args) {
		// ͨ����������
		Integer a = Integer.valueOf(99);
		System.out.println(a.getClass() + ": " + a);
		// ͨ�������ַ���
		Integer b = Integer.valueOf("99");
		System.out.println(b.getClass() + ": " + b);
	}
}
