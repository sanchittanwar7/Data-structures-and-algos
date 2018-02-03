package tree;

public class NodesWithoutSiblings {

	/**
	 * @param args
	 */
	
	//0 1 2 3 4 5 -1 -1 6 -1 -1 -1 7 -1 8 -1 -1 -1 -1
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		BinaryTreeUse.print(root);
		printNodesWithoutSiblings(root);
	}

	private static void printNodesWithoutSiblings(BinaryTreeNode<Integer> root) {
		if(root == null)
			return;
		if(root.left == null && root.right != null)
			System.out.println(root.right.data);
		if(root.right == null && root.left != null)
			System.out.println(root.left.data);
		printNodesWithoutSiblings(root.left);
		printNodesWithoutSiblings(root.right);
	}

}
