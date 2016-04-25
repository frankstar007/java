/**
 * 
 */
package com.frankstar.javaExam;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @author frankstar
 * @function udpClient客户端编程
 */
public class UdpClientA {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//创建DatagramSocket 指定端口
		DatagramSocket datagramSocket = new DatagramSocket(9998);
		String string = "frankstar";
		//用byte数组 创建数据包对象
		DatagramPacket datagramPacket = new DatagramPacket(string.getBytes(), 0, string.length(), InetAddress.getByName("localhost"), 9999);
		datagramSocket.send(datagramPacket);
		datagramSocket.close();
	}

}
