package org.andy.song.annotation;

import java.lang.annotation.Annotation;

public class ATest1PackageTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 这里可以通过I/O操作或者配置项获得包名
		String pkgName = "org.andy.song.annotation";
		Package pkg = Package.getPackage(pkgName);
		
		//获取包上的注解
		Annotation[] annotations = pkg.getAnnotations();
		
		// 遍历注解数组
		for(Annotation an : annotations) {
			if (an instanceof ATest1) {
				// 运行时环境才有用
				System.out.println("I'm the ATest1, be in file package-info.java!");
				System.out.println(an.toString());
				/*
				 * 注解操作
				 * ATest1 atest1 = (ATest1)an;
				 * atest1.*
				 * 可以操作该注解包下的所有类，比如初始化，检查等等
				 * 类似Struts的@Namespace，可以放到包名上，标明一个包的namespace路径
				 */
			}
		}
	}

}
