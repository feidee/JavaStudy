/**
 * Reference: http://blog.csdn.net/yixiaogang109/article/details/7328466
 * 1、为标注在包上Annotation提供便利；
 * 2、声明友好类和包常量；
 * 3、提供包的整体注释说明。
 */

@ATest1 // 包注解
(gid = Long.class, name = "")
package org.andy.song.annotation;

// 包类，默认访问权限为包访问权限，不能带有public, private 访问权限
class PkgClass {
	
	static final String PACKAGE_CONST = "ABC";
	
	public void method() {
		
	}
}

