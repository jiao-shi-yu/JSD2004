package collection.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * java.util.Deque接口，双端队列。
 * 两侧都可以出入队。
 * @author jiao_
 *
 */
public class DequeDemo {
	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<>();
		deque.offer("one");
		System.out.println(deque);
		
		deque.offerLast("two");
		System.out.println(deque);
	
		deque.offerFirst("three");
		System.out.println(deque);
		
		
		String str = deque.pollFirst();
		System.out.println(str);
		str = deque.pollLast();
		System.out.println(str);
		str = deque.poll();
		System.out.println(str);
		System.out.println(deque);
		deque.offer("one");
		deque.offer("two");
		deque.offer("three");
		System.out.println(deque);
		str = deque.peekFirst();
		System.out.println(str);
		
	}
}
