/**
 * 
 */
package com.frankstar.study.servlet4;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author frankstar
 * java的事件监听机制
 * 1.三个组件：事件源、事件对象、事件监听器
 * 2.当事件源上发生某个动作时，它会调用事件监听器的一个方法，并在调用该方法时把事件对象传递进去
 * 3.开发人员在监听器中通过事件对象，就可以拿到事件源，从而对事件源进行操作
 */
public class Demo1 {
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setSize(400, 400);
		frame.setVisible(true);
		
		//注册事件监听器
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				Frame frame = (Frame) e.getSource();
				System.out.println(frame + "窗体正在关闭！");
				frame.dispose();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
