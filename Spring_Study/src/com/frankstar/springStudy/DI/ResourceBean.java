package com.frankstar.springStudy.DI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResourceBean {
	private FileOutputStream foStream;
	private File file;
	//初始化方法
	public void init() {
		System.out.println("ResourceBean:====初始化");
		//加载资源
		System.out.println("ResourceBean:====加载资源");
		try {
			this.foStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//销毁资源方法
	public void destory() {
		System.out.println("ResourceBean:====销毁");
		//释放资源
		System.out.println("ResourceBean:====释放资源");
		try {
			foStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public FileOutputStream getFoStream() {
		return foStream;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
}
