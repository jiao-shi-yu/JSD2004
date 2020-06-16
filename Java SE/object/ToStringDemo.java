package object;

public class ToStringDemo {
	public static void main(String[] args) {
		Point p = new Point(5,6);
		System.out.println(p);
		System.out.println("p:" + p);
	}
}
class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}