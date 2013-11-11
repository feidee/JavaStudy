package org.andy.song.annotation;
 
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
 
public class ParseAnnotation {
 
	/**
	 * 简单打印出ATest1Test 类中所使用到的类注解
	 * 该方法只打印了 Type 类型的注解
	 * @throws ClassNotFoundException
	 */
	public static void parseTypeAnnotation() throws ClassNotFoundException {  
        Class<?> clazz = Class.forName("com.tmser.annotation.ATest1Test"); 
        
        Annotation[] annotations = clazz.getAnnotations();  
        for (Annotation annotation : annotations) {  
        	ATest1 ATest1 = (ATest1)annotation;
            System.out.println("id= \""+ATest1.id()+"\"; name= \""+ATest1.name()+"\"; gid = "+ATest1.gid());  
        }  
    } 
	
	/**
	 * 简单打印出ATest1Test 类中所使用到的方法注解
	 * 该方法只打印了 Method 类型的注解
	 * @throws ClassNotFoundException
	 */
	public static void parseMethodAnnotation(){
		Method[] methods = ATest1Test.class.getDeclaredMethods();  
        for (Method method : methods) {  
            /* 
             * 判断方法中是否有指定注解类型的注解 
             */  
            boolean hasAnnotation = method.isAnnotationPresent(ATest1.class);  
            if (hasAnnotation) {  
                /* 
                 * 根据注解类型返回方法的指定类型注解 
                 */  
            	ATest1 annotation = method.getAnnotation(ATest1.class);  
                System.out.println("method = " + method.getName()  
                        + " ; id = " + annotation.id() + " ; description = "  
                        + annotation.name() + "; gid= "+annotation.gid());  
            }  
        }  
	}
	
	/**
	 * 简单打印出ATest1Test 类中所使用到的方法注解
	 * 该方法只打印了 Method 类型的注解
	 * @throws ClassNotFoundException
	 */
	public static void parseConstructAnnotation(){
		Constructor[] constructors = ATest1Test.class.getConstructors();  
        for (Constructor constructor : constructors) { 
        	/* 
             * 判断构造方法中是否有指定注解类型的注解 
             */  
            boolean hasAnnotation = constructor.isAnnotationPresent(ATest1.class);  
            if (hasAnnotation) {  
                /* 
                 * 根据注解类型返回方法的指定类型注解 
                 */  
            	ATest1 annotation =(ATest1) constructor.getAnnotation(ATest1.class);  
                System.out.println("constructor = " + constructor.getName()  
                        + " ; id = " + annotation.id() + " ; description = "  
                        + annotation.name() + "; gid= "+annotation.gid());  
            }  
        }  
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		parseTypeAnnotation();
		parseMethodAnnotation();
		parseConstructAnnotation();
	}
}