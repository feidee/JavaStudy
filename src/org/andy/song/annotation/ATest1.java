package org.andy.song.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * jdk1.5 增加了注解
 * @interface 用来声明一个注解，其中的每一个方法实际上是声明了一个配置参数。
 * 方法名称就是参数的名称，返回什类型就是参数的类型。
 * 可以通过default来声明参数的默认值。
 * 在这里可以看到@Retention和@Target这样的元注解，用来声明注解本身的行为。
 * @Retention 用来声明注解的保留策略，在CLASS, RUNTIME和SOURCE一种，
 * 分别表示注解保存在类文件，JVM运行时刻和源代码中。
 * 只有当声明为RUNTIME的时候，才能够在运行时刻通过反射API来获取到注解的信息。
 * @Target 用来声明注解可以被添加到哪些类型的元素上，如类型、方法和域等。
 * 
 * 四大元注解：
 *   @Target 表示注解用于什么地方
 *     ElemenetType.CONSTRUCTOR 构造器声明
 *     ElemenetType.FIELD 域声明（包括 enum 实例）
 *     ElemenetType.LOCAL_VARIABLE 局部变量声明
 *     ElemenetType.ANNOTATION_TYPE 作用于注解量声明
 *     ElemenetType.METHOD 方法声明
 *     ElemenetType.PACKAGE 包声明 
 *     ElemenetType.PARAMETER 参数声明 
 *     ElemenetType.TYPE 类，接口（包括注解类型）或enum声明 
 *   @Retention 表示在什么级别保存该注解信息。枚举：
 *     RetentionPolicy.SOURCE 注解将被编译器丢弃 
 *     RetentionPolicy.CLASS 注解在class文件中可用，但会被VM丢弃 
 *     RetentionPolicy.RUNTIME VM将在运行期也保留注释，因此可以通过反射机制读取注解的信息。 
 *   @Documented 将此注解包含在JAVACOD中，会被JAVADOC工具提取成文档。（相关：@see, @param）
 *   @Inherited 允许子类继承父类中的注解。
 *   元注解j Java API 提供，专门用来定义注解
 * 
 * 定义一注解，它将自动继承Annotation
 * 
 * AnnotationTest
 * 
 * @author  Andysong
 * @date    2013-11-11
 * @version
 */

@Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ATest1 {
	String name();
	int id() default 0;
	Class<Long> gid();
}
