package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {

	/**
	 * @param args
	 */

	//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
	//5 2 9 1 3 8 10 -1 -1 -1 -1 -1 -1 -1 -1
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		print(root);
	}

	private static void print(BinaryTreeNode<Integer> root) {
		int spaceLeft, spaceRight, num = 0, count = 1;
		int depth = depth(root);
		spaceLeft = (int) (5*Math.pow(2, depth-3));
		spaceRight = spaceLeft + 1;
		int i;
		for(i = 0; i < spaceLeft; i++)
			System.out.print(" ");
		BinaryTreeNode<Integer> currentNode = root;
		System.out.print(currentNode.data);
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
		pendingNodes.add(root);
		for(i = 0; i < spaceRight; i++)
			System.out.print(" ");
		while(!pendingNodes.isEmpty()){
			currentNode = pendingNodes.remove();
			if(count == Math.pow(2, num)){
				count = 0;
				System.out.println();
				num++;
				spaceLeft /= 2;
				spaceRight /= 2;
			}

			for(i = 0; i < spaceLeft; i++)
				System.out.print(" ");
			if(currentNode.left != null){
				System.out.print(currentNode.left.data);
				pendingNodes.add(currentNode.left);
				count++;
			}
			else{
				System.out.print(" ");
				count++;
			}
			for(i = 0; i < spaceRight; i++)
				System.out.print(" ");
			for(i = 0; i < spaceLeft; i++)
				System.out.print(" ");
			if(currentNode.right != null){
				System.out.print(currentNode.right.data);
				pendingNodes.add(currentNode.right);
				count++;
			}
			else{
				System.out.print(" ");
				count++;
			}

			for(i = 0; i < spaceRight; i++)
				System.out.print(" ");
		}
	}


	private static int depth(BinaryTreeNode root) {
		if(root == null)
			return 0;
		int leftAns = depth(root.left);
		int rightAns = depth(root.right);
		return Math.max(leftAns, rightAns) + 1; 
	}
}
