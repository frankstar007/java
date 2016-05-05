package com.frankstar.springStudy.DI;

import java.io.IOException;

public class DependentBean {
	ResourceBean resourceBean;
	public void write(String ss) throws IOException {
		System.out.println("DependentBean:====写资源");
		resourceBean.getFoStream().write(ss.getBytes());
	}
	//初始化方法
	public void init() throws IOException {
		System.out.println("DependentBean:====初始化");
		resourceBean.getFoStream().write("DependentBean:====初始化".getBytes());
	}
	//销毁方法
	public void destory() throws IOException {
		System.out.println("DependentBean:====销毁");
		resourceBean.getFoStream().write("DependentBean:====销毁".getBytes());
	}
	public void setResourceBean(ResourceBean resourceBean) {
		this.resourceBean = resourceBean;
	}
}
