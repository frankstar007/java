package com.frankstar;

public class CreateInnerInstance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Out.In in = new Out().new In("frankstar");
		Out.In in;
		Out out = new Out();
		in = out.new In("star");

	}

}
