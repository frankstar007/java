package com.frankstar.springStudy.DI;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;


public class TestClasspathResource {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Resource resource = new ClassPathResource("test1.properties");
		if(resource.exists()) {
			TestByteArrayResource.dumpStream(resource);
		}
		System.out.println("path:" + resource.getFile().getAbsolutePath());
		Assert.class.equals(resource.isOpen());
		
		
	}

}