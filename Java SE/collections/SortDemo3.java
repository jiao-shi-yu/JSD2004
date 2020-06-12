package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDemo3 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("苍老师");
		list.add("传奇");
		list.add("小泽老师");
		System.out.println(list);
		/**
		 * 当元素类型定义的比较规则不满做我们的排序需求时，
		 * 可以自定义比较规则。
		 */
		Collections.sort(list,
				(o1, o2)->
					o1.length()-o2.length()
				);
		System.out.println(list);
	}
}
