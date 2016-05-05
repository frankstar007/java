package com.frankstar.springStudy.DI;

import java.util.HashMap;
import java.util.Map;

public class BeanDifinitionRegister {
	//bean定义缓存，此处不考虑并发
	 private final Map<String, BeanDefinition> DEFINITIONS = new HashMap<String, BeanDefinition>();
	 public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		//1 本实现不允许覆盖 Bean定义
		 if (DEFINITIONS.containsKey(beanDefinition.getId())) {
			 throw new RuntimeException("[" + beanName + "] 已存在，本实现不允许覆盖！");
		 }
		 // 2 将bean定义放入Bean定义缓存池中
		 DEFINITIONS.put(beanDefinition.getId(), beanDefinition);
	 }
	 public BeanDefinition getBeanDefinition(String beanName) {
		 return DEFINITIONS.get(beanName);
	 }
	 public boolean containsBeanDefinition(String beanName) {
		 return DEFINITIONS.containsKey(beanName);
	 }
}
