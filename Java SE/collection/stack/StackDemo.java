package collection.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ջ�Ǿ�������ݽṹ֮һ��
 * ��ѭ����ȳ���ԭ��
 * һ��ʹ��ջ��ʵ�ֺ��˵Ĺ���
 * @author jiao_
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<>();
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		stack.push("five");
		System.out.println(stack);
		System.out.println(stack.pop());
		
		for (String s : stack) {
			System.out.println(s);
		}
		System.out.println("----");
		while(stack.size()>0) {
			System.out.println(stack.pop());
		}
	}
}
