package collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue�ӿ� 
 * �����Ǿ�������ݽṹ֮һ����ȡ�Ͷ�ȡԪ�أ���ѭ�����ȳ���ԭ��
 * 
 * Queue��Collection���ӽӿڡ�
 * @author jiao_
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		// offer() 
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		queue.offer("five");
		System.out.println(queue);
		int size = queue.size();
		System.out.println("size:" + size);
		// poll() ��ȡ����Ԫ�ز�����Ӷ�����ɾ��
		String str = queue.poll();
		System.out.println(str);
		System.out.println(queue);
		
		// peek() ���ö���Ԫ�أ���ȡ��Ԫ����Ȼ�ڶ�����
		String str2 = queue.peek();
		System.out.println(str2);
		System.out.println(queue);
		
		for(String s : queue) {
			System.out.println(s);
		}
		
		while (queue.size()>0) {
			System.out.println(queue.poll());
		}
		System.out.println(queue);
	}
}
