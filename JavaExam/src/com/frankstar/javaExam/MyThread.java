package com.frankstar.javaExam;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class MyThread extends Thread{
	private Socket socket;
	
	public MyThread(Socket socket) {
		this.socket = socket;
	}
	//线程方法
	public void run() {
		try {
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			printWriter.println(Thread.currentThread() + " now time :" + new Date());
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
