package wrapper.number;

public class NumberDemo {
	public static void main(String[] args) {
		Number num = 1;
		System.out.println(num.getClass() + ": " + num);
		int intNum = num.intValue();
		System.out.println("intNum: " + intNum);
	}
}
