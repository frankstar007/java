/**
 * 
 */
package com.frankstar;

/**
 * @author frankstar
 *
 */
public class Outer {
	private int outProp = 5;
	class Inner{
		private int inProp = 4;
		public void accessOuterProp(){
			System.out.println("OutProp : " + outProp);
		}
	}
	
	public void accessInnerProp(){
		System.out.println("Inner Prop : " + new Inner().inProp);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer o = new Outer();
		o.accessInnerProp();

	}

}
