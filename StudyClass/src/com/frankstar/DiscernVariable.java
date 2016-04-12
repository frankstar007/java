/**
 * 
 */
package com.frankstar;

/**
 * @author frankstar
 * 内部类
 */
public class DiscernVariable {
	private String prop = "外部类的实例变量";
	private class InClass {
		private String prop = "内部类的实例变量";
		public void info()
		{
			String prop = "局部变量";
			System.out.println("外部类的变量: " + DiscernVariable.this.prop);
			
			System.out.println("内部类的Field变量: " + this.prop);
			
			System.out.println(prop);
		}
	}
	
	public void test(){
		InClass ic = new InClass();
		ic.info();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiscernVariable dv = new DiscernVariable();
		dv.test();

	}

}
