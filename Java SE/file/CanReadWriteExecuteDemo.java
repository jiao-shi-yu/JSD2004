package file;

import java.io.File;

public class CanReadWriteExecuteDemo {
	public static void main(String[] args) {
		File file = new File("./file/NewFileDemo.java");
		boolean canRead = file.canRead();
		boolean canWrite = file.canWrite();
		boolean canExecute = file.canExecute();
		
		System.out.println(canRead);
		System.out.println(canWrite);
		System.out.println(canExecute);
	}
}
