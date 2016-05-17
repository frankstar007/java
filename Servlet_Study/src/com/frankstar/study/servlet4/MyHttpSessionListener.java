/**
 * 
 */
package com.frankstar.study.servlet4;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author frankstar
 *
 */
public class MyHttpSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		// TODO Auto-generated method stub
		System.out.println(hse.getSession() + "创建好了！");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		// TODO Auto-generated method stub
		System.out.println(hse.getSession() + "销毁了");
	}

	

}
