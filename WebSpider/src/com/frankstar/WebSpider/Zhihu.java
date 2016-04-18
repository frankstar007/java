/**
 * 
 */
package com.frankstar.WebSpider;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author frankstar
 * @ 知乎类
 */
public class Zhihu {
	public String question;
	public String qDescription;
	public String qLink;
	public ArrayList<String> answers;
	
	//构造方法初始化数据
	public Zhihu(String url) {
		question = "";
		qDescription = "";
		qLink = "";
		answers = new ArrayList<String>();
		//判断url 是否合法
		if(getRealURl(url)) {
			System.out.println("正在抓取： " + qLink);
			//根据url获取该回答的内容
			String content = Spider.getResults(qLink);
			Pattern pattern;
			Matcher matcher;
			//匹配标题
			pattern = Pattern.compile("zm-editable-content\">(.*?)</h2>");
			matcher = pattern.matcher(content);
			if (matcher.find()) {
				question = matcher.group(1);
			}
			//匹配描述
			pattern = Pattern.compile("zm-editable-content\">(.*?)</div>");
			matcher = pattern.matcher(content);
			if (matcher.find()) {
				qDescription = matcher.group(1);
			}
			//匹配答案
			pattern = Pattern.compile("zm-editable-content clearfix\">(.*?)</div>");
			matcher = pattern.matcher(content);
			boolean isFind = matcher.find();
			while (isFind) {
				answers.add(matcher.group(1));
				isFind = matcher.find();			
			}
			
		}
	}
	
	private boolean getRealURl(String url) {
		// TODO Auto-generated method stub
		//转换http://www.zhihu.com/question/22355264/answer/21102139  
        // 转化成http://www.zhihu.com/question/22355264
		Pattern pattern = Pattern.compile("question/(.*?)/");
		Matcher matcher = pattern.matcher(url);
		if(matcher.find()) {
			qLink = "http://www.zhihu.com/question/" + matcher.group(1);
		} else {
			return false;
		}
		
		return true;
	}
	
	public String writeString() {
		String result = "";
		result += "问题：" + question + "\r\n";
		result += "描述：" + qDescription + "\r\n";
		result += "链接：" + qLink + "\r\n";
		for (int i = 0; i < answers.size(); i++){
			result += "回答" + i + ":" + answers.get(i);
		}
		result += "\r\n\r\n\r\n\r\n";
		//将其中的html标签进行筛选
		result = result.replaceAll("<br>", "\r\n");
		result = result.replaceAll("<.*?>", "");
		return result;
	}

//	public String toString() {
//		return "问题： " + question + 
//				"\n描述：" + qDescription +
//				"\n链接：" + qLink + 
//				"\n回答：" + answers + "\n";
//	}
	
	

}
