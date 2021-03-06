package com.frankstar.springStudy.DI;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

public class TestByteArrayResource {
	public static void dumpStream(Resource resource) {
		// TODO Auto-generated method stub
		InputStream inputStream = null;
		try {
			//获取资源
			inputStream = resource.getInputStream();
			//读取资源
			byte[] descBytes = new byte[inputStream.available()];
			inputStream.read(descBytes);
			System.out.println(new String(descBytes));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
		Resource resource = new ByteArrayResource("Hello frankstar!".getBytes());
		if(resource.exists()) {
			dumpStream(resource);
		}
	}

	
}
