/**
 * 
 */
package com.frankstar.javaExam;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author frankstar
 * @function 用tcp通信模型创建一个web 服务器
 */
//线程类 HTTPThread
class HTTPThread extends Thread {
	private Socket socket;
	public HTTPThread(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			printWriter.println("<html>");
			printWriter.println("<body>");
			printWriter.println("This is my WebServer!");
			printWriter.println("</body>");
			printWriter.println("</html>");
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
public class WebServer {
	public static void main(String[] args) throws IOException {
		//用端口号创建一个ServerSocket对象
		ServerSocket serverSocket = new ServerSocket(8080);
		//开始循环 监听客户端请求
		Socket socket = null;
		while ((socket = serverSocket.accept()) != null) {
			new HTTPThread(socket).start();
		}
		
	}

}
