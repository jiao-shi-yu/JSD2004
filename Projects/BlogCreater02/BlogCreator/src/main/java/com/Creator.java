package com;

import java.io.File;

public class Creator {
	public static void main(String[] args) {
		File file = new File("./datasource/it_科技/wwdc.md");
		Article article = new Article(file);
	}
}
