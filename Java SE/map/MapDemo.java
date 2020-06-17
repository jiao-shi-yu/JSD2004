package map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map接口 查找表
 * Map体现的样子是一个多行两列的表格，
 * 其中左列称为Key，右列称为Value。
 * Map总是成对的保存数据，并且总是根据key去获取对应的value.
 * 查询的条件作为key, 查询的结果作为value。
 * 
 * Map中的key不允许重复（equals比较为true);
 * 
 * Map常见的实现类：
 * java.util.HashMap: 散列表
 * 使用散列算法实现的Map，
 * 当今查询速度最快的数据结构。
 * @author jiao_
 * 
 * java.util.TreeMap: 二叉树实现的Map。
 *
 */
public class MapDemo {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		/*
		 * V put(K k, V v);
		 */
		Integer value = map.put("语文", 99);
		System.out.println("value:"+value);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 99);
		System.out.println(map);
		
		value = map.put("语文", 100);
		System.out.println("value:" + value);
		System.out.println(map);
		
		/**
		 * V get(Object key)
		 * 根据指定的key获取value,
		 * 如果给定的key在Map中不存在，则返回null
		 */
		value = map.get("化学");
		System.out.println(value);
		value = map.get("体育");
		System.out.println(value);
		
		int size = map.size();
		System.out.println(size);
		
		
		/**
		 * V remove(Object key)
		 */
		value = map.remove("物理");
		System.out.println(map);
		System.out.println(value);
		
		/**
		 * boolean containsKey(Object key)
		 * boolean containsValue(Object value)
		 */
		boolean ck = map.containsKey("语文");
		boolean cv = map.containsValue(97);
		System.out.println("containsKey: " + ck);
		System.out.println("containsValue: " + cv);
	}
	
}
