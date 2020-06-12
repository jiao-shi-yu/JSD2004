package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class SortDemo1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(random.nextInt(100));
		}
		System.out.println("list orignal: " + list);
		Collections.sort(list);
		System.out.println("list sorted: " + list);
	}
}
