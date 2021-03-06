/**
 * 
 */
package com.frankstar.study.servlet2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.sound.midi.VoiceStatus;

/**
 * @author frankstar
 *
 */
public class WhenTag extends SimpleTagSupport {
	private boolean test;
	public void setTest(boolean test) {
		this.test = test;
	}
	public void doTag() throws JspException, IOException {
		//获取父标签
		ChooseTag parentTag = (ChooseTag) this.getParent();
		if (test == true && parentTag.isExecute() == false) {
			this.getJspBody().invoke(null);
			parentTag.setExecute(true);
		}
	}
}
