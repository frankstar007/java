package com.frankstar.springStudy;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class NavigationB {
	private NavigationC naviagtionC;
	private List<NavigationC> list;
	private Properties properties;
	private NavigationC[] array = new NavigationC[1];
	private Map<String, NavigationC> map;
	public NavigationC getNaviagtionC() {
		return naviagtionC;
	}
	public void setNaviagtionC(NavigationC naviagtionC) {
		this.naviagtionC = naviagtionC;
	}
	public List<NavigationC> getList() {
		return list;
	}
	public void setList(List<NavigationC> list) {
		this.list = list;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public NavigationC[] getArray() {
		return array;
	}
	public void setArray(NavigationC[] array) {
		this.array = array;
	}
	public Map<String, NavigationC> getMap() {
		return map;
	}
	public void setMap(Map<String, NavigationC> map) {
		this.map = map;
	}
	
	

}
