package tree;

public class DeletionOutsideRange {

	/**
	 * @param args
	 */
	
	//8 5 11 2 7 9 12 -1 -1 6 -1 -1 10 -1 13 -1 -1 -1 -1 -1 -1
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		BinaryTreeUse.print(root);
		root = deleteOutsideRange(root, 3, 9);
		BinaryTreeUse.print(root);
	}

	private static BinaryTreeNode<Integer> deleteOutsideRange(BinaryTreeNode<Integer> root, int min, int max) {
		if(root == null)
			return root;
		root.left = deleteOutsideRange(root.left, min, max);
		root.right = deleteOutsideRange(root.right, min, max);
		if(root.data < min)
			return root.right;
		else if(root.data > max)
			return root.left;
		else
			return root;
	}

}
