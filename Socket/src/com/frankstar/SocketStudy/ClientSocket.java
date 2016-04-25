/**
 * 
 */
package com.frankstar.SocketStudy;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author frankstar
 *
 */
public class ClientSocket {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		Socket s = new Socket("127.0.0.1",6666);
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		Thread.sleep(3000);
		dos.writeUTF("Hello,frankstar");
		
	}

}
