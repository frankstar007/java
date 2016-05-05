/**
 * 
 */
package com.frankstar.springStudy;

/**
 * @author frankstar
 * @function静态工厂方法
 */
public class HelloApiStaticFactory {
	public static HelloApi newInstance(String message) {
		return new HelloImpl2(message);
	}
}
