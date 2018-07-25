package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode{
	int val;
	int height;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	public TreeNode(int val){
		this.val = val;
		height = 1;
	}
}

public class TreeNodeUse {
	
	public static void print(TreeNode root) {
		Queue<TreeNode> pendingNodes = new LinkedList<TreeNode>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			TreeNode currentNode = pendingNodes.remove();
			System.out.print(currentNode.val +  " : ");
			if(currentNode.left != null){
				System.out.print(currentNode.left.val);
				pendingNodes.add(currentNode.left);
			}
			if(currentNode.right != null){
				System.out.print(", " + currentNode.right.val);
				pendingNodes.add(currentNode.right);
			}
			System.out.println();
		}		
	}

	public static TreeNode takeInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root val : ");
		int val = s.nextInt();
		TreeNode root = new TreeNode(val);
		Queue<TreeNode> pendingNodes = new LinkedList<TreeNode>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			TreeNode currentNode = pendingNodes.remove();
			System.out.println("Enter left child of " + currentNode.val + " : ");
			val = s.nextInt();
			if(val != -1){
				TreeNode child = new TreeNode(val);
				currentNode.left = child;
				pendingNodes.add(child);
			}
			System.out.println("Enter right child of " + currentNode.val + " : ");
			val = s.nextInt();
			if(val != -1){
				TreeNode child = new TreeNode(val);
				currentNode.right = child;
				pendingNodes.add(child);
			}
		}
		return root;
	}

}
