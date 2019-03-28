package main.java;
import java.util.*;

/*
 * 655. Print Binary Tree
Medium

Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
Example 3:
Input:
      1
     / \
    2   5
   / 
  3 
 / 
4 
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 
 */
public class PrintBinaryTree {
	    public static List<List<String>> printTree(TreeNode root) {
			int m = heightOfTheTree(root);
			int n = (int)Math.pow(2,m)-1;
			String [][] res = new String[m][n];
			//System.out.println("e"+res[0][1]+"y");
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					res[i][j] = "";
				}
			}
			helper(root,res,0,n,0);
			
			return twoDArrayToList(res);
	        
	    }
		
		public  static  List<List<String>> twoDArrayToList(String[][] a) {
			List<List<String>>  list = new ArrayList<>(a.length);
		    for(int i=0;i<a.length;i++) {
		    	list.add(Arrays.asList(a[i]));
		    }
		    return list;
		}
		
		public  static void helper(TreeNode root,String [][] res,int s,int e,int row) {
			if(root != null) {
			    int mid = (s+e)/2;
				res[row][(s+e)/2] = root.val + "";
				if(mid>s) {
					helper(root.left,res,s,mid-1,row+1);
				}
				if(mid<e) {
					helper(root.right,res,mid+1,e,row+1);
				}
				
			}
		}
		
		public static  int heightOfTheTree(TreeNode root) {
			if(root == null) {
				return 0;
			}
			
			return 1+Math.max(heightOfTheTree(root.left),heightOfTheTree(root.right)) ;
			
		}
	public static void main(String[] args) {

		TreeNode root = BinaryTreeUtils.createBinaryTree(10);
		 List<List<String>> res = printTree(root);
		 
		BinaryTreeUtils.displayTree(root);
	}

}
