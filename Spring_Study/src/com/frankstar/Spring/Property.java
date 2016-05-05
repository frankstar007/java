package com.frankstar.Spring;

public class Property {
	private String name;
	private String ref;
	
	public Property(String name, String ref) {
		super();
		this.setName(name);
		this.setRef(ref);
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
