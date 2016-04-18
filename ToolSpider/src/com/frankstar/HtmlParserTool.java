/**
 * 
 */
package com.frankstar;

import java.util.HashSet;
import java.util.Set;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.LinkRegexFilter;
import org.htmlparser.filters.LinkStringFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;

/**
 * @author frankstar
 * @function html 解析工具
 */
public class HtmlParserTool {
	//获取网页上的所有链接filter用来过滤
	public static Set<String> extracLinks(String url, LinkStringFilter filter) {
		Set<String> links = new HashSet<String>();
		
		try {
			Parser parser = new Parser(url);
			parser.setEncoding("gb2312");
			//过滤<frame>标签的filter，用来提取frame标签中src
			NodeFilter frameFilter = new NodeFilter() {
				private static final long serialVersionUID = 1L;

				@Override
				public boolean accept(Node node) {
					// TODO Auto-generated method stub
					if (node.getText().startsWith("frame src=")) {
						return true;
					} else {
						return false;
					}
				}
			};
			//OrFilter 来设置过滤<a>标签和<frame>标签
			OrFilter linkFilter = new OrFilter(new NodeClassFilter(LinkTag.class), frameFilter);
			//得到所有经过过滤的标签
			NodeList list = parser.extractAllNodesThatMatch(linkFilter);
			for(int i = 0; i < list.size(); i++) {
				Node tag = list.elementAt(i);
				if (tag instanceof LinkTag) {
					LinkTag link = (LinkTag) tag;
					String linkUrl = link.getLink();
//					if (filter.accept(arg0)) {
//						links.add(linkUrl);
//					}
				
				}
				 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return links;
		
	}
	
}