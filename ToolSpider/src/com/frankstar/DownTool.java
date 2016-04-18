/**
 * 
 */
package com.frankstar;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.ws.http.HTTPException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * @author frankstar
 * @function下载网页的工具类
 */
public class DownTool {
	//根据URL和网页类型生成需要保存的网页的文件名，去除URL中的非文件名字符
	private String getFileNameByUrl(String url, String contentType) {
		//移除http://字符
		url = url.substring(7);
		//确认抓取到的页面类型为text/html类型
		if (contentType.indexOf("html") != -1) {
			//把所有的URL中的特殊字符转换为下划线
			url = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
			
		} else {
			url = url.replaceAll("[\\?/:*|<>\"]", "_") + contentType.substring(contentType.lastIndexOf("/") + 1);
		}
		return url;
	}
	//保存网页字节数组到本地文件filepath为要保存的文件路径
	private void saveToLocal (byte[] data, String filepath) {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(filepath)));
			for (int i = 0; i < data.length; i++) {
				out.write(data[i]);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//下载URL指向的网页
	public String downloadFile(String url) {
		String filepath = null;
		//1.生成httpclient对象并设置对象
		HttpClient httpClient = new HttpClient();
		//设置http链接超时5秒
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		//2.生成GetMethod对象并设置参数
		GetMethod getMethod = new GetMethod(url);
		//3.设置get请求的超时5秒
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
		//设置请求重试处理
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
		//4.执行get 请求
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			//判断状态码信息
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed! </n>" + getMethod.getStatusLine());
				filepath = null;
			}
			//5.处理相应内容
			byte[] responseBody = getMethod.getResponseBody();
			//根据网页URL生成保存时的文件名
			filepath = "/Users/frankstar/Desktop" 
					+ getFileNameByUrl(url, getMethod.getResponseHeader("content-type").getValue());
			
			saveToLocal(responseBody, filepath);
			
		} catch (HTTPException e) {
			System.out.println("检查http地址是否有误！");
			e.printStackTrace();
		} catch (IOException e2) {
			//网络异常
			e2.printStackTrace();
		} finally {
			//释放链接
			getMethod.releaseConnection();
				
		}
		
		return filepath;
		
	}
}
