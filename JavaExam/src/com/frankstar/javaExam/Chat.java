/**
 * 
 */
package com.frankstar.javaExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author frankstar
 * @function 使用udp实现聊天室
 */
//接受消息的进程
class ReceiveThread extends Thread {
	private DatagramSocket datagramSocket;
	
	public ReceiveThread(int port) {
		super();
		try {
			this.datagramSocket = new DatagramSocket(port);
		} catch (SocketException sException) {
			sException.printStackTrace();
		}
	}
	
	public void run () {
		try {
			byte[] buff = new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(buff, 1024);
			while (true) {
				datagramSocket.receive(datagramPacket);
				String string = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
				System.out.println("receive:" + string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//发送线程
class SendThread extends Thread {
	private DatagramSocket datagramSocket;
	private int sendPort;
	
	public SendThread(int port, int sendPort) {
		super();
		this.sendPort = sendPort;
		try {
			this.datagramSocket = new DatagramSocket(port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String string = null;
			while ((string = bufferedReader.readLine()) != null) {
				DatagramPacket datagramPacket = new DatagramPacket(string.getBytes(), 0, string.length(), InetAddress.getLocalHost(), sendPort);
				datagramSocket.send(datagramPacket);
				System.out.println("send:" + string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			datagramSocket.close();
		}
	}
}
public class Chat {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//args 接收端口号 发送端口 对方接受端口
		System.out.println("frankstar");
		new ReceiveThread(Integer.parseInt(args[0])).start();
		new SendThread(Integer.parseInt(args[1]), Integer.parseInt(args[2])).start();;
	}

}
