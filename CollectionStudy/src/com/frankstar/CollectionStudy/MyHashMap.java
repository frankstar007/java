/**
 * 
 */
package com.frankstar.CollectionStudy;

/**
 * @author frankstar
 * MyHashMap
 */
public class MyHashMap<K, V> {
	private Entry[] table;//Entry数组表
	static final int DEFAULT_INITIAL_CAPACITY = 16;//默认数组长度
	private int size;
	
	//构造函数
	public MyHashMap()
	{
		table = new Entry[DEFAULT_INITIAL_CAPACITY];
		size = DEFAULT_INITIAL_CAPACITY;
	}
	//获取数组长度
	public int getSize() 
	{
		return size;
	}
	//求index
	static int indexFor(int h, int length)
	{
		return h % (length - 1);
	}
	//获取元素
	public V get(Object key)
	{
		if (key == null)
			return null;
		int hash = key.hashCode();
		int index = indexFor(hash, table.length);
		for (Entry<K, V> e = table[index]; e != null; e = e.next)
		{
			Object k = e.key;
			if (e.key.hashCode() == hash && (k == key || key.equals(k)))
			{
				return e.value;
			}
		}
		return null;
	}
	//添加元素
	public V put(K key, V value)
	{
		if (key == null)
		{
			return null;
		}
		int hash = key.hashCode();
		int index = indexFor(hash, table.length);
		//如果添加的元素已经存在， 那么只需要修改value值即可
		for (Entry<K, V> e = table[index]; e != null; e = e.next)
		{
			Object k = e.key;
			if (e.key.hashCode() == hash && (k == key || key.equals(k))) 
			{
				V ovalue = e.value;
				e.value = value;
				return ovalue;
			}
		}
		//如果key值不存在，添加
		  Entry<K, V> e = table[index];
		  table[index] = new Entry<K, V>(key, value, e);
		  return null;
	}

}
