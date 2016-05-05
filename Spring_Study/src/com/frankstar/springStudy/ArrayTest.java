package com.frankstar.springStudy;

import java.util.Arrays;

public class ArrayTest {
	private int[] arr;
	public void setArr(int[] arr) {
		this.arr = arr;
	}
	public int[] getArr() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("[");
		for(int i = 0; i < arr.length; i++) {
			sBuffer.append(arr[i]);
		}
		sBuffer.append("]");
		System.out.println(sBuffer.toString());
		return arr;
	}
	

}
