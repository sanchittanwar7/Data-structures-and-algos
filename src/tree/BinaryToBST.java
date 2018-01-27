package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class BinaryToBST {

	/**
	 * @param args
	 */
	static int index = 0;
	//0 1 2 3 4 5 -1 -1 6 -1 -1 -1 7 -1 8 -1 -1 -1 -1
	
	static ArrayList<Integer> inorder = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		BinaryTreeUse.print(root);
		convert(root);
		BinaryTreeUse.print(root);
	}

	private static void convert(BinaryTreeNode<Integer> root) {
		inorderTraverse(root);
		Collections.sort(inorder);
		System.out.println(inorder);
		change(root);
	}

	private static void change(BinaryTreeNode<Integer> root) {
		if(root == null)
			return;
		change(root.left);
		root.data = inorder.get(index);
		index++;
		change(root.right);
	}

	private static void inorderTraverse(BinaryTreeNode<Integer> root) {
		if(root == null)
			return;
		inorderTraverse(root.left);
		inorder.add(root.data);
		inorderTraverse(root.right);
		
	}

}
