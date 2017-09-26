package com.liang.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class TreeNode{
	public int value;
	public TreeNode left;
	public TreeNode right;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public TreeNode(int value, TreeNode left, TreeNode right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}
	@Override
	public String toString() {
		return "TreeNode [value=" + value + ", left=" + left + ", right=" + right + "]";
	}
	
}
public class InderOrderTraversal {
	public List<Integer>inorderTraversal(TreeNode root){
		List<Integer>res=new ArrayList<>();
		Stack<TreeNode>stack=new Stack<>();
		TreeNode cur=root;
		while(cur!=null || !stack.isEmpty()){
			while(cur!=null){
				stack.push(cur);
				cur=cur.left;
			}
			cur=stack.pop();
			res.add(cur.value);
			cur=cur.right;
		}
		return res;
	}
}
