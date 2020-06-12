package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * ����һ����10��������100���ڣ���List���ϣ�
 * ���մӴ�С�Ĺ�������
 * @author jiao_
 *
 */
public class Test {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int num = random.nextInt(100);
			list.add(num);
		}
		Collections.sort(list, (i1, i2) -> i2 - i1);
		System.out.println(list);
		// JDK8֮��ListҲ�ṩ�˳�Ա����sort()
		list.sort((i1, i2) -> (i1 - i2));
		System.out.println(list);
	}
}
