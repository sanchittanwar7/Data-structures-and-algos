package tree;

public class CheckSymmetry {

	/**
	 * @param args
	 */
	//1 2 2 3 4 4 3 -1 -1 -1 -1 -1 -1 -1 -1
	//1 2 3 4 5 6 7 -1 8 9 -1 -1 10 -1 11 -1 -1 -1 -1 -1 -1 -1 -1

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		System.out.println(isSymmetric(root));
	}

	private static boolean isSymmetric(BinaryTreeNode<Integer> root) {
		return areMirror(root, root);
	}

	private static boolean areMirror(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> root2) {
		if(root == null && root2 == null)
			return true;
		if(root != null && root2 != null && root.data == root2.data)
			return areMirror(root.left, root2.right);
		return false;
	}

}
