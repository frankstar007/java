/**
 * 
 */
package com.frankstar.CollectionStudy;

import java.util.HashMap;

/**
 * @author frankstar
 * @function 学习hashmap
 */
public class MapDemo1 {

	/**
	 * @param args
	 * 基于map接口实现，允许null键／值 非同步／不保证有序
	 * 容量Capacity 负载因子load factor
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		map.put("语文", 0);
		map.put("数学", 1);
		map.put("英语", 2);
		map.put("历史", 3);
		map.put("政治", 4);
		map.put("地理", 5);
		map.put("生物", 6);
		map.put("化学", 7);
		//put函数的大致思路
		
		for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
			
		}
	}

}
