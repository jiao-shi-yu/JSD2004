package collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * List ��һ���ӿڣ������ˡ����Ա�����
 * �����Ա�Ԫ�����Ⱥ����Ԫ�ؿ����ظ��ļ��ϡ�
 * �����Ա����������Ŷӵļ���
 * List��ʵ���಻�����Դ洢�������ݽṹ��
 * ���ṩ�����㷨����Щ�㷨���Լ򻯱�̡�
 * 
 * ����Ҳ���Դ洢һ�� ���Ⱥ���������ݡ�
 * ����ֻ�ܴ洢��û�м��㷽�����㷨��Ҫ�Լ�д��
 * 
 * List����Ҳ���Դ洢���Ⱥ��������ݡ�
 * ���ṩ���Զ�����/���ݣ����룬����ɾ�����㷨
 * 
 * ���ú�List�ķ�����������������Ч�ʡ�
 * Listʵ����Collection�ӿڵķ�����
 * 
 * @author jiao_
 *
 */
public class ListDemo1 {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("С��");
		list.add("С��");
		list.add("С��");
		list.add("С��");
		/**
		 * E get(int index);
		 * ��ȡԪ��
		 */
		String str = list.get(2);
		System.out.println(str);
		
		
		
		
		/*
		 * ����λ����list�в���Ԫ��
		 * add(����λ��, ������Ԫ��)
		 * ���Ԫ��ʱ������ײ����������ݽṹ���
		 * ���ˣ�add�������Զ��������ݲ�����
		 */
		System.out.println(list);
		list.add(2, "�ܴ�");
		System.out.println(list);
		/*
		 * ����λ���滻�޸�Ԫ��
		 * set(λ�ã��滻Ԫ��) ���ر��滻��Ԫ��
		 */
		String name = list.set(2, "�ܶ�");
		System.out.println(name);
		System.out.println(list);
		/*
		 * �а���λ��ɾ��ô����
		 * remove(λ��) 
		 */
		name = list.remove(2);
		System.out.println(name);
		System.out.println(list);
		
		/*
		 * ����Ԫ�س��ֵ�λ��
		 * indexOf(Ԫ��) ����Ԫ�ص�һ�γ��ֵ�λ��
		 * �Ҳ������� -1
		 */
		list.add(2,"С��"); //list��Ԫ�ؿ����ظ�����
		System.out.println(list);
		int index = list.indexOf("С��");
		System.out.println(index);//1
		index = list.lastIndexOf("С��");
		System.out.println(index);//2
		index = list.indexOf("�ܶ�");
		System.out.println(index);//-1
		
		/*
		 * ��List����
		 * ��List��һ������Ϊһ����List���ء�
		 * ��List��ԭ��List����洢�ռ�
		 * list.subList(��ʼ, ����) ������ʼ������������
		 */
		System.out.println(list);
		List<String> sub = list.subList(1, 4);
		System.out.println(sub);
		//��List��ԭ��List����洢�ռ�
		//�޸�ʱ��sub��list�໥Ӱ��
		sub.set(1, "�ܴ�");
		System.out.println(sub);
		System.out.println(list);
		
		/*
		 * list �ṩ��ת��Ϊ����ķ���
		 * 
		 * 1. list.toArray() ���� Object[] ��List����
		 * �е�ÿ��Ԫ�ش洢��Object[]�����з���
		 * 
		 * 2. list.toArray(����) ����ָ�����͵�����
		 */
		Object[] arr = list.toArray();
		for(Object obj:arr) {
			System.out.println(obj); 
		}
		
		System.out.println();
		
		/*
		 * 1. ����С�ˣ��ᴴ�������飬���Ԫ�ط���
		 * 2. ���õ�ʱ�����Ԫ�ط���
		 * 3. ������ˣ����������ǰ��Ԫ�ط���
		 * 
		 * ���鰴�ռ��ϳ��ȴ������õ����飡
		 */
		String[] arr1 = new String[list.size()]; 
		arr1 = list.toArray(arr1);
		for (String s : arr1) {
			System.out.println(s); 
		}
	}
}
