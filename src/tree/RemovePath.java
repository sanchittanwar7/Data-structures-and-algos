package tree;

public class RemovePath {

	/**
	 * @param args
	 */
	
	//1 2 3 -1 -1 4 5 6 -1 -1 7 -1 8 9 -1 -1 -1 10 -1 -1 -1
	//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
	//5 2 9 1 3 8 10 -1 -1 -1 -1 -1 -1 -1 -1
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		BinaryTreeUse.print(root);
		removePath(root, 23);
		BinaryTreeUse.print(root);
	}

	private static BinaryTreeNode<Integer> removePath(BinaryTreeNode<Integer> root, int sum) {
		if(root == null)
			return null;
		root.right = removePath(root.right, sum - root.data);
		root.left = removePath(root.left, sum - root.data);
		if(root.left == null && root.right == null && root.data < sum)
			return null;
		return root;
		
	}

}
