/**
 * 
 */
package com.frankstar.Nlp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author frankstar
 *
 */
public class MatrixDemo<T> {
	//定义每一个节点
	public Node node;
	//可能组成的词集
	public Set<String> s = new HashSet<String>();
	
	//定义一个root
	public Node root = new Node("年", null, null, null, null, 0, 0);
	
	//提供汉字矩阵
	public void createMatrix(Node node) {
		
		
		
		
	}
	
	class Node {
		public String data;
		public Node left;//int left
		public Node right;
		public Node up;
		public Node down;
		public int row;
		public int col;
		
		
		public Node(){}
		
		public Node(String data, Node l, Node r, Node u, Node d, int row, int col){
			this.data = data;
			this.down = d;
			this.left = l;
			this.up = u;
			this.right = r;	
			this.row = row;
			this.col = col;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
