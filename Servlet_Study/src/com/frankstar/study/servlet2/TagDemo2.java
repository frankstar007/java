/**
 * 
 */
package com.frankstar.study.servlet2;

import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import netscape.javascript.JSException;

/**
 * @author frankstar
 * 继承TagSupport重写
 */
public class TagDemo2 extends TagSupport{
	public int doEndTag() throws JSException {
		return Tag.SKIP_PAGE;
	}
}
