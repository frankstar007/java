/**
 * 
 */
package com.frankstar.CollectionStudy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author frankstar
 *	hashsetDemo
 */
public class HashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("c");
		set.add("d");
		
		//使用Iterator输出集合
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		//直接输出集合
		System.out.println(set);
		//使用foreach输出集合
		for(String e:set)
		{
			System.out.print(e + " ");
		}
		System.out.println();
		//使用toString输出集合
		System.out.println(set.toString());
	}

}
