/**
 * 
 */
package com.frankstar;

import java.util.Stack;

/**
 * @author frankstar
 * 构造二叉树
 */
public class BTree {
	private TreeNode root = null;
	//构造函数
	public BTree() {
		root = new TreeNode(0, "A");
	}
	public void createBTree(TreeNode root) {
		TreeNode BNode = new TreeNode(1, "B");
		TreeNode CNode = new TreeNode(2, "C");
		TreeNode DNode = new TreeNode(3, "D");
		TreeNode ENode = new TreeNode(4, "E");
		TreeNode FNode = new TreeNode(5, "F");
		TreeNode GNode = new TreeNode(6, "G");
		
		root.left = BNode;
		root.right = CNode;
		
		root.left.left = DNode;
		root.left.right = ENode;
		root.right.left = FNode;
		root.right.right = GNode;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	//树的高度
	public int height() {
		return height(root);
	}
	
	private int height(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int lheight = height(node.left);
			int rheight = height(node.right);
			
			return lheight > rheight ? lheight + 1 : rheight + 1;
		}

	}
	//节点的个数
	public int size() {
		return size(root);
	}

	private int size(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + size(node.left) + size(node.right);
		}
	}
	//返回双亲节点
	public TreeNode parent (TreeNode node) {
		if (node == null || node == root) {
			return null;
		} else {
			return parent(root, node);
		}
	}
	private TreeNode parent(TreeNode root2, TreeNode node) {
		if (root2 == null) {
			return null;
		}
		if (root2.left == node || root2.right == node) {
			return root2;
		} 
		TreeNode temp;
		//左子树中查找
		if ((temp = parent(root2.left, node)) != null) {
			return temp;
		} else {
			//右子树查找
			return parent(root2.right, node);
		}
	}
	//获取左节点
	public TreeNode getLbTreeNode (TreeNode node) {
		if (node == null) {
			return null;
		}
		return node.left;
	}
	//获取右节点
	public TreeNode getRbTreeNode (TreeNode node) {
		if (node == null) {
			return null;
		}
		return node.right;
	}
	//获取根基
	public TreeNode getRoot() {
		return root;
	}
	//删除节点
	public void deleteNode(TreeNode node) {
		if (node != null) {
			deleteNode(node.left);
			deleteNode(node.right);
			node = null;
		}
	}
	//
	public void traverse(TreeNode node) {
		System.out.println("key:" + node.key + "--name:" + node.data);
		traverse(node.left);
		traverse(node.right);
	}
	public void visited(TreeNode node) {
		node.visited = true;
		System.out.println("key:" + node.key + "--name:" + node.data);
	}
	//前序遍历 递归实现
	public void preOrder(TreeNode node) {
		if (node != null) {
			visited(node);
			preOrder(node.left);
			preOrder(node.right);	
		}
	}
	//中序遍历 递归实现
	public void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.left);
			visited(node);
			inOrder(node.right);
		}
	}
	//后序遍历
	public void postOrder(TreeNode node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			visited(node);
		}
	}
	//前序遍历的非递归实现
	public void noRecPreOrder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = node;
		while(temp != null ||stack.size() > 0) {
			while (temp != null) {
				visited(temp);
				stack.push(temp);
				node = node.left;	
			}
			while(stack.size() > 0) {
				temp = stack.pop();
				temp = temp.right;
			}
		}
	}
	// 中序遍历
	public void noRecInORder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = node;
		while (temp != null || stack.size() > 0) {
			//存在左子树
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			//栈非空
			while (stack.size() > 0) {
				temp = stack.pop();
				visited(temp);
				temp = temp.right;
			}
		}
	}
	//后序遍历的非递归实现
	public void noRecPostOrder (TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = node;
		while (node != null) {
			//左子树
			for (; node.left != null; node = node.left) {
				stack.push(node);
			}
			//当前节点无右子树或者右子树已经输出
			while (node != null && (node.right == null || node.right == temp)) {
				visited(node);
				//记录上一个已输出的节点
				temp = node;
				if (stack.empty()) {
					return;
				}
				node = stack.pop();
			}
		}
	}
	//节点结构
	class TreeNode {
		private int key = 0;
		private String data = null;
	    private boolean visited = false;
	    private TreeNode left = null;
	    private TreeNode right = null;
	    
	    public TreeNode(){}
	    
	    public TreeNode(int key, String data) {
	    	this.key = key;
	    	this.data = data;
	    	this.left = null;
	    	this.right = null;
	    }
		
	}
	
	public static void main(String[] args) {
		BTree bt = new BTree();
		bt.createBTree(bt.root);
		System.out.println("前序遍历(递归)：");
		bt.preOrder(bt.root);
		System.out.println("中序遍历(递归)：");
		bt.inOrder(bt.root);
		System.out.println("后序遍历(递归)：");
		bt.postOrder(bt.root);
		System.out.println("前序遍历(非递归)：");
		bt.preOrder(bt.root);
	}
}
