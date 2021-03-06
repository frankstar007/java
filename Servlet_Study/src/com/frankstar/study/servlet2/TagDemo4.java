/**
 * 
 */
package com.frankstar.study.servlet2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

/**
 * @author frankstar
 * 该类实现BodyTag接口，控制doStartTag()方法返回EVAL_BODY_BUFFERED，则web服务器会创建BodyContent对象捕捉标签体
 * 然后在doEndTag()方法体内，得到代表标签体的BodyContent对象，从而可以对标签体进行修改操作
 * BodyTag接口提供了一个默认的实现类BodyTagSupport因此只要继承该类 根据需要重写相关的方法即可
 */
public class TagDemo4 extends BodyTagSupport{
	public int doStartTag() throws JspException {
		return BodyTag.EVAL_BODY_BUFFERED;
	}
	public int doEndTag() throws JspException {
		BodyContent bodyContent = this.getBodyContent();
		String content = bodyContent.getString();
		String result = content.toUpperCase();
		try {
			this.pageContext.getOut().write(result);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return Tag.EVAL_PAGE;
	}

}
