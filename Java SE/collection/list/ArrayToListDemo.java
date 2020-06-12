package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����ת��Ϊ����
 * ʹ������Ĺ�����Arrays�ľ�̬����asList��
 * ���Խ�һ������ת��Ϊһ��List���ϡ�
 * @author jiao_
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array = {"one", "two", "three", "four"};
		System.out.println("array: " + Arrays.toString(array));
		
		List<String> list = Arrays.asList(array);
		System.out.println("list: " + list);
		
		/**
		 * �Լ���Ԫ�صĸĶ������Ƕ�ԭ����ĸĶ�
		 */
		list.set(1, "2");
		System.out.println("list: " + list);
		System.out.println("array: " + Arrays.toString(array));
		/**
		 * ���������Ƕ����ģ���������ת�������ļ��ϲ�����ɾԪ��
		 */
//		list.add("five");
//		list.remove(0);
		
		/**
		 * ������ɾԪ�أ����д���һ���µļ��ϡ�
		 * ʹ��addAll()����������ת�������ļ����е�Ԫ����ӵ��¼�����
		 */
		List<String> list2 = new ArrayList<>();
		list2.addAll(list);
		list2.add("five");
		System.out.println(list2);
		/**
		 * ��ʵ����addAll(),ֱ��ʹ�ü������صĹ��췽������
		 */
		List<String> list3 = new ArrayList<>(Arrays.asList(array));
		System.out.println("list3:" + list3);
	}
}
