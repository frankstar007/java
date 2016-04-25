/**
 * 
 */
package com.frankstar.javaExam;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.net.ssl.SSLContext;

/**
 * @author frankstar
 * @function 服务器端Tcp编程
 */
public class TcpServerA {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = new ServerSocket(8888);
		Socket socket = serverSocket.accept();
		OutputStream oStream = socket.getOutputStream();
		PrintWriter pWriter = new PrintWriter(oStream);
		pWriter.println("now time:" + new Date());
		pWriter.flush();
		pWriter.close();
		socket.close();
		serverSocket.close();

	}

}
