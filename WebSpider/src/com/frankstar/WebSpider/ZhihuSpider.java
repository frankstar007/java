/**
 * 
 */
package com.frankstar.WebSpider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author frankstar
 * @function 获取知乎的推荐页内容
 */
public class ZhihuSpider {

	public static String getZhihu(String url) {
		//定义返回内容
		String result = "";
		//定义一个缓冲输入流
		BufferedReader br = null;
		try {
			//将url转换为一个URL对象
			URL realUrl = new URL(url);
			//初始化一个URL链接
			URLConnection uc = realUrl.openConnection();
			//开始实际的链接
			uc.connect();
			//读取输入流
			br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			//单行读取
			String line;
			while ((line = br.readLine()) != null) {
				result += line;
			}
			
		} catch (Exception e) {
			System.out.println("读取失败！" + e);
			e.printStackTrace();
		} finally {
			//关闭链接
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return result;
		
	}
	public static ArrayList<String> regexString(String targetStr, String patternStr) {
		//返回数组
		ArrayList<String> results = new ArrayList<String>();
		//定义好模版
		Pattern pattern = Pattern.compile(patternStr);
		//匹配
		Matcher matcher = pattern.matcher(targetStr);
		boolean isFind = matcher.find();
		while(isFind) {
			results.add(matcher.group(1));
			isFind = matcher.find();
		}
		
		return results;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//初始化URL
		String url = "http://www.zhihu.com/explore/recommendations";
		//获取页面内容
		String result = getZhihu(url);
		//获取指定的元素
		ArrayList<String> elements = regexString(result, "question_link.*?>(.*?)<");
		System.out.println(elements);
	}

}
