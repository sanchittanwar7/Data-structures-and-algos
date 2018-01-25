package tree;

public class CheckBalanced {

	/**
	 * @param args
	 */
	
	//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
	//0 1 2 3 4 5 -1 -1 1 -1 -1 -1 -1 -1 4 -1 -1
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		if(checkBalanced(root) == -1)
			System.out.println("false");
		else 
			System.out.println("true");
	}

	private static int checkBalanced(BinaryTreeNode<Integer> root) {
		if(root == null)
			return 0;
		int leftHeight = checkBalanced(root.left);
		int rightHeight = checkBalanced(root.right);
		if(Math.abs(rightHeight - leftHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}

}
