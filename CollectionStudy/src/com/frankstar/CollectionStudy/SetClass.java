/**
 * 
 */
package com.frankstar.CollectionStudy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author frankstar
 * SetTest
 */
public class SetClass {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Set<String> words = new HashSet<String>();
		
		//通过输入流代开文献
		//1.不需要抛出异常
		InputStream inStream = SetClass.class.getResourceAsStream("frank.txt");
		
		//2.需要抛出异常
		//InputStream is = new FileInputStream("/User/frankstar/Desktop/star.txt");
		Scanner in = new Scanner(inStream);
		while(in.hasNext()) 
		{
			words.add(in.next());
		}
		
		Iterator<String> iter = words.iterator();
		
		for(int i = 0; i < 7; i++)
		{
			if(iter.hasNext())
			{
				System.out.println(iter.next());
			}
		}
		
		System.out.println(words.size());
	}

}
