package com.frankstar;

public class Staticout {
	static class StaticIn
	{
		public StaticIn()
		{
			System.out.println("静态内部类的构造器");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Staticout.StaticIn in = new Staticout.StaticIn();

	}

}
