/**
 * 
 */
package com.frankstar.study.servlet2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sun.media.jfxmedia.control.VideoDataBuffer;

/**
 * @author frankstar
 * otherwise标签
 */
public class OtherWiseTag extends SimpleTagSupport{
	
	public void doTag() throws JspException, IOException {
		ChooseTag parentTag = (ChooseTag) this.getParent();
		if (parentTag.isExecute() == false) {
			this.getJspBody().invoke(null);
			parentTag.setExecute(true);
		}
	}

}
