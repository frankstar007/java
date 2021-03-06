package com.frankstar.Spring;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;



public class Bean {
	private String id;
	private String className;
	private List<Property> propertyList;
	public Bean(String id, String className, List<Property> propertyList) {
		super();
		this.id = id;
		this.className = className;
		this.setPropertyList(propertyList);
	}
	public String getId() {
		return id; 
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public void readXML(String fileName) {
		//寻找配置文件
		URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
		Document document = null;
		Element element = null;
		List beanList = null;
		try {
			SAXBuilder sBuilder = new SAXBuilder(false);
			document = sBuilder.build(new FileInputStream(new File(xmlPath.toURI())));
			//设置命名空间
			Namespace xhtml = Namespace.getNamespace("xhtml", "http://www.springframework.org/schema/beans");  
			element = document.getRootElement();//获取根节点
			List<Element> list = element.getChildren("bean", xhtml);
			for (Element element2 : list) {
				String id = element2.getAttributeValue("id");
				String className = element2.getAttributeValue("className");
				//获得每个Bean下的属性
				List<Element> pList = element2.getChildren("property", xhtml);
				List<Property> propertyList = new ArrayList<>();
				if (pList.size() > 0) {
					for (Element propertyElement : pList) {
						String name = propertyElement.getAttributeValue("name");
						String ref = propertyElement.getAttributeValue("ref");
						Property property = new Property(name, ref);
						propertyList.add(property);
					}
				}
				
				Bean bean = new Bean(id, className, propertyList);
				beanList.add(bean);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void instanceBeans() {
		List<Bean> beanList = null;
		for (Bean bean: beanList) {
			try {
				if (bean.getClassName() != null && !"".equals(bean.getClassName().trim())) {
					Map<String, Bean> beanObject = new HashMap<String, Bean>();
					beanObject.put(bean.getId(), (Bean) Class.forName(bean.getClassName()).newInstance());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public List<Property> getPropertyList() {
		return propertyList;
	}
	public void setPropertyList(List<Property> propertyList) {
		this.propertyList = propertyList;
	}
}
