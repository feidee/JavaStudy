package org.andy.song.annotation;

/**
 * 用来测试自定义注解 ATest1
 * 
 * ATest1Test
 * 
 * @author  Andysong
 * @date    2013-11-11
 * @version
 */

@ATest1(gid = Long.class, name = "") // ElementType.TYPE 类注解
public class ATest1Test {

	@ATest1(gid = Long.class, name = "") // ElementType.FIELD 类成员注解 
	private Integer age;
	
	
	@ATest1(gid = Long.class, name = "") // ElementType.CONSTRUCTOR 构造方法注解
	public ATest1Test() {
		
	}
	
	@ATest1(gid = Long.class, name = "") // ElementType.METHOD 类方法注解
	public void a() {
		
		@ATest1(gid = Long.class, name = "") // ElementType.LOCAL_VARIABLE 局部变量注解
		String s1 = new String("123");
	}
	
	public void b(@ATest1(gid = Long.class, name = "") Integer a) { // ElementType.PARAMETER 方法参数注解
		
	}
}
