package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map�ı���
 * ���ַ�ʽ��
 * 1. ����key
 * 2. ����value
 * 3. ����key-value pairs 
 * @author jiao_
 *
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("����", 99);
		map.put("��ѧ", 99);
		map.put("Ӣ��", 97);
		map.put("����", 96);
		map.put("��ѧ", 90);
		System.out.println(map);
		
		
		// ����key
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key);
		}
		
		// ����entry
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + ": " + value);
		}
		
		// ������ֵ��
		Collection<Integer> values = map.values();
		for (Integer value : values) {
			System.out.println(value);
		}
		
		
		
	}
}
