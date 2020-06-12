package collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * List 是一个接口，描述了“线性表”集合
 * “线性表”元素有先后次序，元素可以重复的集合。
 * “线性表”就是类似排队的集合
 * List的实现类不及可以存储对象数据结构，
 * 还提供操作算法，这些算法可以简化编程。
 * 
 * 数组也可以存储一组 有先后次数的数据。
 * 数组只能存储，没有计算方法。算法需要自己写。
 * 
 * List集合也可以存储有先后次序的数据。
 * 还提供了自动扩容/缩容，插入，增加删除等算法
 * 
 * 利用好List的方法，才能提升开发效率。
 * List实现了Collection接口的方法。
 * 
 * @author jiao_
 *
 */
public class ListDemo1 {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("小白");
		list.add("小蔡");
		list.add("小王");
		list.add("小饭");
		/**
		 * E get(int index);
		 * 获取元素
		 */
		String str = list.get(2);
		System.out.println(str);
		
		
		
		
		/*
		 * 按照位置在list中插入元素
		 * add(插入位置, 被插入元素)
		 * 添加元素时候，如果底层的数组等数据结构如果
		 * 满了，add方法会自动触发扩容操作。
		 */
		System.out.println(list);
		list.add(2, "熊大");
		System.out.println(list);
		/*
		 * 按照位置替换修改元素
		 * set(位置，替换元素) 返回被替换的元素
		 */
		String name = list.set(2, "熊二");
		System.out.println(name);
		System.out.println(list);
		/*
		 * 有按照位置删除么？有
		 * remove(位置) 
		 */
		name = list.remove(2);
		System.out.println(name);
		System.out.println(list);
		
		/*
		 * 查找元素出现的位置
		 * indexOf(元素) 查找元素第一次出现的位置
		 * 找不到返回 -1
		 */
		list.add(2,"小蔡"); //list中元素可以重复出现
		System.out.println(list);
		int index = list.indexOf("小蔡");
		System.out.println(index);//1
		index = list.lastIndexOf("小蔡");
		System.out.println(index);//2
		index = list.indexOf("熊二");
		System.out.println(index);//-1
		
		/*
		 * 子List方法
		 * 将List的一部分作为一个子List返回。
		 * 子List与原有List共享存储空间
		 * list.subList(开始, 结束) 包含开始，不包含结束
		 */
		System.out.println(list);
		List<String> sub = list.subList(1, 4);
		System.out.println(sub);
		//子List与原有List共享存储空间
		//修改时候，sub和list相互影响
		sub.set(1, "熊大");
		System.out.println(sub);
		System.out.println(list);
		
		/*
		 * list 提供了转换为数组的方法
		 * 
		 * 1. list.toArray() 返回 Object[] 将List集合
		 * 中的每个元素存储到Object[]数组中返回
		 * 
		 * 2. list.toArray(数组) 返回指定类型的数组
		 */
		Object[] arr = list.toArray();
		for(Object obj:arr) {
			System.out.println(obj); 
		}
		
		System.out.println();
		
		/*
		 * 1. 数组小了，会创建新数组，填充元素返回
		 * 2. 正好的时候，填充元素返回
		 * 3. 数组大了，会填充数组前面元素返回
		 * 
		 * 建议按照集合长度创建正好的数组！
		 */
		String[] arr1 = new String[list.size()]; 
		arr1 = list.toArray(arr1);
		for (String s : arr1) {
			System.out.println(s); 
		}
	}
}
