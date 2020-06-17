package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map的遍历
 * 三种方式：
 * 1. 遍历key
 * 2. 遍历value
 * 3. 遍历key-value pairs 
 * @author jiao_
 *
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("语文", 99);
		map.put("数学", 99);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 90);
		System.out.println(map);
		
		
		// 遍历key
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key);
		}
		
		// 遍历entry
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + ": " + value);
		}
		
		// 遍历键值对
		Collection<Integer> values = map.values();
		for (Integer value : values) {
			System.out.println(value);
		}
		
		
		
	}
}
