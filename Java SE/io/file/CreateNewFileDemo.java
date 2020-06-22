package io.file;

import java.io.File;
import java.io.IOException;

public class CreateNewFileDemo {
	public static void main(String[] args) {
		File file = new File("./myfile.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
