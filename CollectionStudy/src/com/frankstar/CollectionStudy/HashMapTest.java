package com.frankstar.CollectionStudy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("frank", "100");
		map.put("star", "200");
		map.put("frank", "900");
		
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println("key:" + key +" value: " + value );
		}
	}

}
