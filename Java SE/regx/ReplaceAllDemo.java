package regx;

import java.util.Scanner;

public class ReplaceAllDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入:");
		String line = scan.nextLine();
		line = line.replaceAll("我[去操草日]", "**");
		line = line.replaceAll("你[妈]", "**");
		System.out.println(line);
	}
}
