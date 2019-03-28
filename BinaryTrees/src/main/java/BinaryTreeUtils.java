package main.java;
import java.util.*;

public class BinaryTreeUtils {

	private static TreeNode add1(TreeNode root, int data) {
		if (root == null)
			return new TreeNode(data);
		TreeNode current = root, parent = null;
		Random r = new Random();
		while (current != null) {
			parent = current;
			if (r.nextInt(2) == 0) {
				if (current.left == null) {
					parent.left = new TreeNode(data);
					break;
				}
				current = current.left;
			} else {
				if (current.right == null) {
					parent.right = new TreeNode(data);
					break;
				}
				current = current.right;
			}
		}
		return root;
	}
	
	private static TreeNode addCompleteBinaryTree(TreeNode root, int data) {
		if (root == null)
			return new TreeNode(data);
		 Queue<TreeNode> q = new LinkedList<>();
		 q.add(root);
		 int size = 0;
		 while(!q.isEmpty()) {
			 size  = q.size();
			 while(size > 0) {
				 TreeNode cur = q.poll();
				 
				 if(cur.left == null) {
					 cur.left = new TreeNode(data);
					 return root;
				 }else {
					 q.add(cur.left);
				 }
				 
				 if(cur.right == null) {
					 cur.right = new TreeNode(data);
					 return root;
				 }else {
					 q.add(cur.right);
				 }
			 }
		 }
	
		return root;
	}


	//it is generating biased binary trees not the random binary tree
	public static TreeNode createBinaryTree(int n) {
		Random r = new Random();
		TreeNode root = null;
		for (int i = 0; i < n; ++i) {
			int data = r.nextInt(n) + 1;
			root = add1(root, data);
		}
		return root;
	}
	
	public static TreeNode createCompleteBinaryTree(int n) {
		Random r = new Random();
		TreeNode root = null;
		for (int i = 0; i < n; ++i) {
			int data = r.nextInt(n) + 1;
			root = addCompleteBinaryTree(root, data);
		}
		return root;
	}
	
	
	
	public static TreeNode createUniqueBinaryTree(int n) {
		TreeNode root = null;
		for (int i = 0; i < n; ++i) 
			root = add1(root, i+1);
		return root;
	}

	public static TreeNode createOneSidedBinaryTree(int n) {
		Random r = new Random();
		TreeNode root = null;
		for (int i = 0; i < n; ++i) {
			int data = r.nextInt(n) + 1;
			TreeNode tmp = new TreeNode(data);
			if (root != null) {
				tmp.left = root;
			} 
			root = tmp;
		}
		return root;
	}

	
	public static void displayTree(TreeNode root) {
		auxDisplay(root, 0, "Root");
	}

	private static void auxDisplay(TreeNode root, int nspaces, String type) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println(root.val + "(" + type + ")");
		auxDisplay(root.left, nspaces + 4, "L");
		auxDisplay(root.right, nspaces + 4, "R");
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);

	}
}