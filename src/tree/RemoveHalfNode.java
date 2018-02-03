package tree;

public class RemoveHalfNode {

	/**
	 * @param args
	 */
	
	//0 1 2 3 4 5 -1 -1 6 -1 -1 -1 7 -1 8 -1 -1 -1 -1
	//2 7 5 -1 6 -1 9 1 11 4 -1 -1 -1 -1 -1 -1 -1
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		BinaryTreeUse.print(root);
		root = removeHalfNodes(root);
		BinaryTreeUse.print(root);
	}

	private static BinaryTreeNode<Integer> removeHalfNodes(BinaryTreeNode<Integer> root) {
		if(root == null)
			return null;
		root.left = removeHalfNodes(root.left);
		root.right = removeHalfNodes(root.right);
		if(isComplete(root))
			return root;
		return root.left == null ? root.right : root.left; 
	}

	private static boolean isComplete(BinaryTreeNode<Integer> root) {
		if(root.left == null || root.right == null){
			if(root.right == null && root.left == null)
				return true;
			return false;
		}
		return true;
	}

}
