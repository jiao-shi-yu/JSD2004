package regx;

import java.util.Scanner;

public class ReplaceAllDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������:");
		String line = scan.nextLine();
		line = line.replaceAll("��[ȥ�ٲ���]", "**");
		line = line.replaceAll("��[��]", "**");
		System.out.println(line);
	}
}
