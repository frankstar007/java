/**
 * 
 */
package com.frankstar;

/**
 * @author frankstar
 * 测试内部类
 */
public class Cow {
	private double weight;
	public Cow(){};
	public Cow(double weight)
	{
		this.weight = weight;
	}
	//定义一个内部非静态类
	private class CowLeg {
		private double length;
		private String color;
		public CowLeg(){};
		public CowLeg(double length, String color){
			this.length = length;
			this.color = color;
		}
		public void setLength(double length){
			this.length = length;
		}
		public void setColor(String color){
			this.color = color;
		}
		public double getLength(){
			return length;
		}
		public String getColor(){
			return color;
		}
		public void info() {
			System.out.println("cow's leg length: " + length + " color: " + color);
			System.out.println("Cow's weight: " + weight);
		}
		
		
	}
	public void test() {
		CowLeg cl = new CowLeg(1.12, "red");
		cl.info();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cow c = new Cow(456);
		c.test();

	}

}
