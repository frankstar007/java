/**
 * 
 */
package me.frankstar.util;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author frankstar
 * 该工具类的功能就是封装客户端提交的表单数据到formbean中
 */
public class WebUtils {
	//将request对象转换成T对象
	public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			Enumeration<String> enumeration = request.getAttributeNames();
			while (enumeration.hasMoreElements()) {
				String name = (String) enumeration.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//生成UUID
	public static String makeId() {
		return UUID.randomUUID().toString();
	}
}
