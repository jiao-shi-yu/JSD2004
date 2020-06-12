package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDemo3 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("����ʦ");
		list.add("����");
		list.add("С����ʦ");
		System.out.println(list);
		/**
		 * ��Ԫ�����Ͷ���ıȽϹ����������ǵ���������ʱ��
		 * �����Զ���ȽϹ���
		 */
		Collections.sort(list,
				(o1, o2)->
					o1.length()-o2.length()
				);
		System.out.println(list);
	}
}
