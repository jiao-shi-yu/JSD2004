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
		 * sort()����Ҫ�󼯺ϵ�Ԫ��ʵ��һ��Comparable�ӿ�
		 */
		
		/**
		 * ����ʵ��Comparable�ӿڵķ�ʽ�����и�������
		 * ����һ��Comparator��ʵ����Ķ���
		 */
	
		// ʹ��Comparatorʵ��
		System.out.println(list);
		Collections.sort(list, new PointComparator());
		System.out.println(list);
		// ʹ�������ڲ���
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
		// ʹ��Lambda���ʽ--2��
		Collections.shuffle(list);
		System.out.println(list);
		Collections.sort(list, (o1, o2)-> {
			int len1 = o1.getX()*o1.getX() + o1.getY()*o1.getY();
			int len2 = o2.getX()*o2.getX() + o2.getY()*o2.getY();
			return len1 - len2;
		});
		System.out.println(list);
		// ʹ��Lambda���ʽ--1��
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