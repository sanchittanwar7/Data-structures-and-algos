package tree;

public class IsFull {

	/**
	 * @param args
	 */
	
	//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
	//5 2 9 1 3 8 10 -1 -1 -1 -1 -1 -1 -1 -1
	//5 2 9 1 3 8 10 -1 -1 11 -1 -1 -1 -1 -1 -1 -1
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		System.out.println(isFull(root));
	}

	private static boolean isFull(BinaryTreeNode<Integer> root) {
		if(root == null)
			return true;
		if((root.left == null && root.right != null)||(root.left != null && root.right == null))
			return false;
		return isFull(root.left) && isFull(root.right);
	}

}
