/**
 * 
 */
package com.frankstar;

import java.util.HashSet;
import java.util.Set;

/**
 * @author frankstar
 * @function 自定义保存类 保存visited表和Unvisited表
 */
public class SpiderQueue {
	//已访问的url集合 Visited表
	private static Set<Object> visitedUrl = new HashSet<>();
	//添加到访问过的URL队列中
	public static void addVisitedUrl(String url) {
		visitedUrl.add(url);
	}
	//移除访问过的url
	public static void removeVisitedUrl(String url) {
		visitedUrl.remove(url);
	}
	//获得已经访问过的URL数目
	public static int getVisitedUrlNum () {
		return visitedUrl.size();
	}
	//待访问的URL集合unvisited 表
	private static Queue unVisitedUrl = new Queue();
	//获得unVisited队列
	public static Queue getUnVisitedUrl() {
		return unVisitedUrl;
	}
	//未访问的unVisitedUrl出队列
	public static Object unVisitedUrlDeQueue() {
		return unVisitedUrl.deQueue();
	}
	//保证添加url到unVisitedUrl的时候每个URL只被访问过一次
	public static void addUnvisitedUrl(String url) {
		if (url != null && !url.trim().equals("") && !visitedUrl.contains(url) && unVisitedUrl.contians(url) != null) {
			unVisitedUrl.enQueue(url);
		}
	}
	//判断未访问的url队列中是否为空
	public static boolean unVisitedUrlIsEmpty() {
		return unVisitedUrl.isEmptyQueue();
	}
}
