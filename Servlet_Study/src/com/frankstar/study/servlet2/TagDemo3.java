/**
 * 
 */
package com.frankstar.study.servlet2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author frankstar
 * 控制jsp页面内容重复执行
 * 实现Iterationtag接口 控制doAfterBody()方法的返回值
 */
public class TagDemo3 extends TagSupport{
	
	int x = 5;
	public int doStartTag() throws JspException {
		return Tag.EVAL_BODY_INCLUDE;
	}
	
	public int doAfterBody() throws JspException {
		x--;
		if (x > 0) {
			return IterationTag.EVAL_BODY_AGAIN;
		} else {
			return IterationTag.SKIP_BODY;
		}
	}
}
