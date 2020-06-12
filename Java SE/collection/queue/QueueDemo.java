package collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue接口 
 * 队列是经典的数据结构之一。存取和读取元素，遵循先入先出的原则。
 * 
 * Queue是Collection的子接口。
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
		// poll() 获取队首元素并将其从队列中删除
		String str = queue.poll();
		System.out.println(str);
		System.out.println(queue);
		
		// peek() 引用队首元素，获取后元素仍然在队列中
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
