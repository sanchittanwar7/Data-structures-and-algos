package tree;

public class LowestDepth {

	/**
	 * @param args
	 */
	
	//1 2 3 4 5 6 7 -1 8 -1 9 -1 -1 -1 10 11 -1 -1 -1 -1 -1 -1 -1
	//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		System.out.println(minDepth(root));
	}

	private static int minDepth(BinaryTreeNode<Integer> root) {
		if(root == null)
			return 0;
		int left_min = minDepth(root.left);
		int right_min = minDepth(root.right);
		return 1 + Math.min(left_min, right_min);
	}

}
