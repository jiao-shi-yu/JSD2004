package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为集合
 * 使用数组的工具类Arrays的静态方法asList，
 * 可以将一个数组转换为一个List集合。
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
		 * 对集合元素的改动，就是对原数组的改动
		 */
		list.set(1, "2");
		System.out.println("list: " + list);
		System.out.println("array: " + Arrays.toString(array));
		/**
		 * 由于数组是定长的，所以数组转化得来的集合不能增删元素
		 */
//		list.add("five");
//		list.remove(0);
		
		/**
		 * 若想增删元素，自行创建一个新的集合。
		 * 使用addAll()方法把数组转换而来的集合中的元素添加到新集合中
		 */
		List<String> list2 = new ArrayList<>();
		list2.addAll(list);
		list2.add("five");
		System.out.println(list2);
		/**
		 * 其实不用addAll(),直接使用集合重载的构造方法即可
		 */
		List<String> list3 = new ArrayList<>(Arrays.asList(array));
		System.out.println("list3:" + list3);
	}
}
