/**
 * 
 */
package com.frankstar.javaExam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author frankstar
 *	@function 用多线程实现tcpserver编程
 */
public class TcpServerB {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//端口号创建一个serversocket对象
		ServerSocket serverSocket = new ServerSocket(8888);
		Socket socket = null;
		while ((socket = serverSocket.accept()) != null) {
			//开始一个新线程
			new MyThread(socket).start();
		}
		serverSocket.close();
	}

}
