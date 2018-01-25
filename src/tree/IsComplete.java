package tree;

public class IsComplete {

	/**
	 * @param args
	 */
	
	//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
	//5 2 9 1 3 8 10 -1 -1 11 -1 -1 -1 -1 -1 -1 -1
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		System.out.println(isComplete(root));
	}

	private static boolean isComplete(BinaryTreeNode<Integer> root) {
	
	}
}
