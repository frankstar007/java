/**
 * 
 */
package com.frankstar.SocketStudy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author frankstar
 *
 */
public class SocketTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(6666);
		//创建一个ServerSocket对象时指定一个端口号
		//服务器接受客户端的请求是不间断的，故服务器端的编程一般都是死循环
		while (true) {
			Socket s = ss.accept();
			//在服务器端调用accept()方法接受客户端的连接对象，accept()方法是
			//一个阻塞式方法，一直在傻傻地等待着是否有客户端申请连接上来
			//然后服务器端的Socket插座就和客户端的Socket插座建立了连接了
			System.out.println("A client connected");
			//使用InputStream接受从客户端发送过来的信息，使用DataInputStream数据流处理接收到的信息
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = dis.readUTF();
			System.out.println(str);
		}

	}

}
