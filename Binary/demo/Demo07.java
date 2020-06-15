package demo;

public class Demo07 {
	public static void main(String[] args) {
		/**
		 * 将一个int拆分为4个byte
		 */
		int i = 0x79feadc;
		byte b1 = (byte) ((i >>> 24) & 0xff);
		byte b2 = (byte) ((i >>> 16) & 0xff);
		byte b3 = (byte) ((i >>> 8) & 0xff);
		byte b4 = (byte) ((i >>> 0) & 0xff);
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(b1));
		System.out.println(Integer.toBinaryString(b2));
		System.out.println(Integer.toBinaryString(b3));
		System.out.println(Integer.toBinaryString(b4));
	}
}
