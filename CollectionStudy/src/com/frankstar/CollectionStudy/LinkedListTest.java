/**
 * 
 */
package com.frankstar.CollectionStudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author frankstar
 * 
 */
public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(list);
		
		List<String> b = new ArrayList<String>();
		b.add("d");
		b.add("e");
		b.add("f");
		b.add("g");
		System.out.println(b);
		
		//ListIterator在Iterator基础上添加了add(),previous()和hasPrevious()方法
		ListIterator<String> li = list.listIterator();
		//普通的Iterator只有三个方法，hasNext()，next()和remove()
		Iterator<String> bi = b.iterator();
		//b归并到list中，间隔交叉b的元素
		while(bi.hasNext())
		{
			if(li.hasNext())
			{
				li.next();
			}
			li.add(bi.next());
		}
		System.out.println(list);
		
		//b中每隔2个元素删除一个
		while(bi.hasNext())
		{
			bi.next();
			if(bi.hasNext())
			{
				bi.next();
				bi.remove();
			}
		}
		
		System.out.println(b);
		
		//删除a中所有的b中的元素
		list.removeAll(b);
		System.out.println(list);
	}

}
