/**
 * 
 */
package com.frankstar.javaExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author frankstar
 * @function 客户端Tcp编程
 */
public class TcpClientA {

	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Socket socket = new Socket("127.0.0.1", 8888);
		//获得输入流
		InputStream iStream = socket.getInputStream();
		//创建bufferreader对象
		InputStreamReader iStreamReader = new InputStreamReader(iStream);
		BufferedReader bufferedReader = new BufferedReader(iStreamReader);
		String string = bufferedReader.readLine();
		System.out.println(string);
				
	}

}
