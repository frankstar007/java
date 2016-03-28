/**
 * 
 */
package com.frankstar.test;

/**
 * @author frankstar
 *      测试static 的区别
 */
public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Count ct = new Count();
		Count.prt("ct.c="+ct.v.c); 
		Count.prt("v1.c="+Count.v1.c+"  v2.c="+Count.v2.c); 
		Count.v1.inc(); 
		Count.prt("v1.c="+Count.v1.c+"  v2.c="+Count.v2.c); 
		Count.prt("ct.c="+ct.v.c); 
		

	}

}
class Value {
	static int c = 0;
	Value(){
		c = 15;
	}
	Value(int i) {
		c = i;
	}
	static void inc () {
		c++;
	}
}
class Count {
	public static void prt(String s) {
		System.out.println(s);
	}
	Value v = new Value(10);
	static Value v1, v2;
	static {
		prt("v1.c=" + v1.c + " v2.c=" + v2.c);
		v1 =  new Value(27);
		prt("v1.c=" + v1.c + " v2.c=" + v2.c);
		v2 = new Value(15);
		prt("v1.c=" + v1.c + " v2.c=" + v2.c);
	}
	
}
