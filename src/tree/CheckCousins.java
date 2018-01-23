package tree;

import java.util.Scanner;

public class CheckCousins {

	/**
	 * @param args
	 * 
	 */
	
	//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
	//5 2 9 1 3 8 10 -1 -1 -1 -1 -1 -1 -1 -1
	
	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeUse.takeInput();
		BinaryTreeUse.print(root);
		Scanner s = new Scanner(System.in);
		int data;
		System.out.println("Enter two nodes you want to check : ");
		data = s.nextInt();
		BinaryTreeNode node1 = new BinaryTreeNode(data);
		data = s.nextInt();
		BinaryTreeNode node2 = new BinaryTreeNode(data);
		System.out.println(checkCousins(root, node1, node2));
	}

	private static boolean checkCousins(BinaryTreeNode root,BinaryTreeNode node1, BinaryTreeNode node2) {
//		System.out.println("Height of node1 : " + depth(root, node1) + " Height of node2 : " + depth(root, node2) + " Are brothers : " + areBrothers(root, node1, node2));
		return depth(root, node1) == depth(root, node2) && !areBrothers(root, node1, node2) ? true : false;
	}
 
	private static boolean areBrothers(BinaryTreeNode root,BinaryTreeNode node1, BinaryTreeNode node2) {
		if(root == null)
			return false;
		if(root.left != null && root.right != null && (root.left.data == node1.data && root.right.data == node2.data))
			return true;
		return areBrothers(root.left, node1, node2) || areBrothers(root.right, node1, node2);
	}

	private static int depth(BinaryTreeNode root, BinaryTreeNode node) {
		if(root == null)
			return -1;
		if(root.data == node.data)
			return 0;
		int leftAns = depth(root.left, node);
		int rightAns = depth(root.right, node);
		if(leftAns == -1 && rightAns == -1)
			return -1;
		return Math.max(leftAns, rightAns) + 1; 
	}

}
