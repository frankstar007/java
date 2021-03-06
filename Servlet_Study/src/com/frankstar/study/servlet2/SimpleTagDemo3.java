/**
 * 
 */
package com.frankstar.study.servlet2;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author frankstar
 * 重写doTag方法 调用invoke 方法时，让执行结果写一个自定义的缓冲即可，然后开发人员取出缓冲区的数据修改输出
 */
public class SimpleTagDemo3 extends SimpleTagSupport{
	public void doTag() throws JspException, IOException {
		JspFragment jspFragment = this.getJspBody();
		StringWriter sWriter = new StringWriter();
		//将标签体中的内容写到sWriter中
		jspFragment.invoke(sWriter);
		String content = sWriter.getBuffer().toString();
		content = content.toUpperCase();
		PageContext context = (PageContext) this.getJspContext();
		context.getOut().write(content);
	}
}
