/**
 * 
 */
package com.frankstar.javaExam;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author frankstar
 * @function udpServer编程
 */
public class UdpServerA {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//创建DatagramSocket 指定端口
		DatagramSocket datagramSocket = new DatagramSocket(9999);
		//创建一个byte数组
		byte[] buff = new byte[1024];
		//创建一个数据包对象
		DatagramPacket datagramPacket = new DatagramPacket(buff, 1024);
		datagramSocket.receive(datagramPacket);
		String string = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
		System.out.println(string);
		datagramSocket.close();
	}

}
