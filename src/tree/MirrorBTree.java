package tree;

public class MirrorBTree {

	/**
	 * @param args
	 */
	
	//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
	//1 2 3 4 -1 5 -1 -1 -1 -1 -1
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		mirror(root);
		PrintTree.print(root);
	}

	private static void mirror(BinaryTreeNode<Integer> root) {
		if(root == null)
			return;
		BinaryTreeNode<Integer> temp;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirror(root.left);
		mirror(root.right);
	}

}
