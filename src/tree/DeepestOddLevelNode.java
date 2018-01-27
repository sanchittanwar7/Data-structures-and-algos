package tree;

public class DeepestOddLevelNode {

	/**
	 * @param args
	 */
	
	//1 2 3 -1 -1 4 5 6 -1 -1 7 -1 8 9 -1 -1 -1 10 -1 -1 -1
	//1 2 3 4 -1 5 6 -1 -1 -1 7 -1 8 9 -1 -1 10 -1 -1 11 -1 -1 -1
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		BinaryTreeUse.print(root);
		System.out.println(getDepth(root, true));
	}

	private static int getDepth(BinaryTreeNode<Integer> root, boolean isOdd) {
		if(root == null){
			if(!isOdd)
				return 0;
			return -1;
		}
		int ans = Math.max(getDepth(root.left, !isOdd), getDepth(root.right, !isOdd));
		if(ans != -1)
			return 1 + ans;
		if(isOdd)
			return 0;
		return -1;
	}

}
