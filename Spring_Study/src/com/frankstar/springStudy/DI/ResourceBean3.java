package com.frankstar.springStudy.DI;

import org.springframework.core.io.Resource;

public class ResourceBean3 {
	private Resource resource;
	public Resource geResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
}
