package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 生成一个放10个整数（100以内）的List集合，
 * 按照从大到小的规则排序
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
		// JDK8之后，List也提供了成员方法sort()
		list.sort((i1, i2) -> (i1 - i2));
		System.out.println(list);
	}
}
