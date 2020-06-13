package map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map�ӿ� ���ұ�
 * Map���ֵ�������һ���������еı��
 * �������г�ΪKey�����г�ΪValue��
 * Map���ǳɶԵı������ݣ��������Ǹ���keyȥ��ȡ��Ӧ��value.
 * ��ѯ��������Ϊkey, ��ѯ�Ľ����Ϊvalue��
 * 
 * Map�е�key�������ظ���equals�Ƚ�Ϊtrue);
 * 
 * Map������ʵ���ࣺ
 * java.util.HashMap: ɢ�б�
 * ʹ��ɢ���㷨ʵ�ֵ�Map��
 * �����ѯ�ٶ��������ݽṹ��
 * @author jiao_
 * 
 * java.util.TreeMap: ������ʵ�ֵ�Map��
 *
 */
public class MapDemo {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		/*
		 * V put(K k, V v);
		 */
		Integer value = map.put("����", 99);
		System.out.println("value:"+value);
		map.put("��ѧ", 98);
		map.put("Ӣ��", 97);
		map.put("����", 96);
		map.put("��ѧ", 99);
		System.out.println(map);
		
		value = map.put("����", 100);
		System.out.println("value:" + value);
		System.out.println(map);
		
		/**
		 * V get(Object key)
		 * ����ָ����key��ȡvalue,
		 * ���������key��Map�в����ڣ��򷵻�null
		 */
		value = map.get("��ѧ");
		System.out.println(value);
		value = map.get("����");
		System.out.println(value);
		
		int size = map.size();
		System.out.println(size);
		
		
		/**
		 * V remove(Object key)
		 */
		value = map.remove("����");
		System.out.println(map);
		System.out.println(value);
		
		/**
		 * boolean containsKey(Object key)
		 * boolean containsValue(Object value)
		 */
		boolean ck = map.containsKey("����");
		boolean cv = map.containsValue(97);
		System.out.println("containsKey: " + ck);
		System.out.println("containsValue: " + cv);
	}
	
}
