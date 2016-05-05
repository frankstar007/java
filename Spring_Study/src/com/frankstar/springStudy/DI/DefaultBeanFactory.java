package com.frankstar.springStudy.DI;

import javax.management.RuntimeErrorException;

public class DefaultBeanFactory {
	// Bean定义注册表
	private BeanDifinitionRegister DEFINITIONS = new BeanDifinitionRegister();
	//单例注册表
	private final SingletonBeanRegister SINGLETONS = new SingletonBeanRegister();
	public Object getBean(String beanName) {
		//验证Bean定义是否存在
		if(!DEFINITIONS.containsBeanDefinition(beanName)) {
			throw new RuntimeException("不存在［" + beanName + "]Bean定义");
		}
		//获取Bean定义
		BeanDefinition beanDefinition = DEFINITIONS.getBeanDefinition(beanName);
		//是否该Bean定义是单例作用域
		if (beanDefinition.getScope() == BeanDefinition.SCOPE_SINGLETON) {
			//如果单例注册表包含Bean则直接返回
			if (SINGLETONS.containsSingleton(beanName)) {
				return SINGLETONS.getSingleton(beanName);
			}
			//如果不存在就创建并注册单例注册表缓存
			SINGLETONS.registerSingleton(beanName, createBean(beanDefinition));
			return SINGLETONS.getSingleton(beanName);
		}
		if (beanDefinition.getScope() == beanDefinition.SCOPE_PROTOTYPE) {
			return createBean(beanDefinition);
		}
		//请他情况错误定义
		 throw new RuntimeException("错误的Bean定义");
	}
	public void registerBeanDefinition(BeanDefinition beanDefinition) {
		DEFINITIONS.registerBeanDefinition(beanDefinition.getId(), beanDefinition);
	}
	private Object createBean(BeanDefinition beanDefinition) {
		// TODO Auto-generated method stub
		//根据Bean定义创建Bean
		try {
			Class clazz = Class.forName(beanDefinition.getClazz());
			//通过反射使用无参数构造器创建Bean
			return clazz.getConstructor().newInstance();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("没有找到Bean[" + beanDefinition.getId() + "]类");
		} catch (Exception e) {
			throw new RuntimeException("创建Bean[" + beanDefinition.getId() + "]失败");
		}
	}

}
