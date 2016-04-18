/**
 * 
 */
package com.frankstar;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;



/**
 * @author frankstar
 * @function 使用工具类写一个简单爬取百度的Demo
 */
public class Spider {

	private static HttpClient httpClient = new HttpClient();
	
	public static boolean downloadPage(String path) throws Exception {
		//定义输入输出流
		InputStream input = null;
		OutputStream output = null;
		//得到Post方法
		GetMethod getMethod = new GetMethod(path);
		//执行 返回状态码
		int statusCode = httpClient.executeMethod(getMethod);
		//针对状态码返回处理信息
		if(statusCode == HttpStatus.SC_OK) {
			input = getMethod.getResponseBodyAsStream();
			//通过URL得到文件名
			String fileName = path.substring(path.lastIndexOf("/") + 1) + ".html";
			//获得文件输出流
			output = new FileOutputStream(fileName);
			//输出文件
			int tempByte = -1;
			while ((tempByte = input.read()) > 0) {
				output.write(tempByte);
			}
			//关闭输入流
			if (input != null) {
				input.close();
			}
			
			//关闭输出流
			if (output != null) {
				output.close();
			}
			
			return true;
		}
		return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			boolean flag = Spider.downloadPage("http://www.baidu.com");
			System.out.println(flag);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
