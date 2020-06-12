package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import collection.Point;

public class SortDemo2 {
	public static void main(String[] args) {
		List<Point> list = new ArrayList<>();
		list.add(new Point(8, 9));
		list.add(new Point(1, 2));
		list.add(new Point(3, 7));
		list.add(new Point(2, 2));
		list.add(new Point(1, 1));
		
		/**
		 * sort()方法要求集合的元素实现一个Comparable接口
		 */
		
		/**
		 * 但是实现Comparable接口的方式，具有高侵入性
		 * 传入一个Comparator的实现类的对象
		 */
	
		// 使用Comparator实例
		System.out.println(list);
		Collections.sort(list, new PointComparator());
		System.out.println(list);
		// 使用匿名内部类
		Collections.shuffle(list);
		System.out.println(list);
		Collections.sort(list, new Comparator<Point>() {
			public int compare(Point o1, Point o2) {
				int len1 = o1.getX()*o1.getX() + o1.getY()*o1.getY();
				int len2 = o2.getX()*o2.getX() + o2.getY()*o2.getY();
				return len1 - len2;
			}
		});
		System.out.println(list);
		// 使用Lambda表达式--2行
		Collections.shuffle(list);
		System.out.println(list);
		Collections.sort(list, (o1, o2)-> {
			int len1 = o1.getX()*o1.getX() + o1.getY()*o1.getY();
			int len2 = o2.getX()*o2.getX() + o2.getY()*o2.getY();
			return len1 - len2;
		});
		System.out.println(list);
		// 使用Lambda表达式--1行
		Collections.shuffle(list);
		System.out.println(list);
		Collections.sort(list, (o1, o2)-> 
		o1.getX() * o1.getX() + o1.getY() 
		- o2.getX()*o2.getX() - o2.getY()*o2.getY()
		);
		System.out.println(list);
		
		
	}
}
class PointComparator implements Comparator<Point> {
	@Override
	public int compare(Point o1, Point o2) {
		int len1 = o1.getX()*o1.getX() + o1.getY()*o1.getY();
		int len2 = o2.getX()*o2.getX() + o2.getY()*o2.getY();
		return len1 - len2;
	}
}