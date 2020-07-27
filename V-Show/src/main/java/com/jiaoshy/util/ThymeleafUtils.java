package com.jiaoshy.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThymeleafUtils {
	private static TemplateEngine templateEngine;
	static {
		templateEngine = new TemplateEngine();
		/**
		 *  之前是FileTemplateResolver,
		 *  现在变成了ClassLoaderTemplateResolver, 会自动查找src/main/resources目录下的模板页面。
		 */
		ClassLoaderTemplateResolver classLoaderTemplateResolver = new ClassLoaderTemplateResolver();
		// 设置模板解析器
		classLoaderTemplateResolver.setCharacterEncoding("UTF-8");
		templateEngine.setTemplateResolver(classLoaderTemplateResolver);
	}
	
	/**
	 * 处理得到页面，并响应
	 * @throws IOException response对象 获取输出流
	 */
	public static void print(String filename, Context context, HttpServletResponse response) throws IOException {
		String html = templateEngine.process(filename, context);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(html);
		pw.close();
	}
}
