package tree;

public class LeftViewOfBinaryTree {

	/**
	 * @param args
	 */
	static int maxLevel;
	
	//1 2 3 4 5 6 -1 -1 8 -1 -1 -1 9 -1 10 -1 -1 -1 -1
	//4 5 2 -1 -1 3 1 6 7 -1 -1 -1 -1 -1 -1
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		printLeftView(root, 1);
	}

	private static void printLeftView(BinaryTreeNode<Integer> root, int level) {
		if(root == null)
			return;
		if(level > maxLevel){
			System.out.println(root.data);
			maxLevel = level;
		}
		printLeftView(root.left, level + 1);
		printLeftView(root.right, level + 1);
	}

}
