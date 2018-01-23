package tree;

public class CheckBST {

	//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
	//5 2 9 1 3 8 10 -1 -1 -1 -1 -1 -1 -1 -1
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		BinaryTreeUse.print(root);
		System.out.println(checkBST(root));
	}

	private static boolean checkBST(BinaryTreeNode<Integer> root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean checkBST(BinaryTreeNode<Integer> root, int minValue,int maxValue) {
		if(root == null)
			return true;
		if(root.data < minValue || root.data > maxValue)
			return false;
		return checkBST(root.left, minValue, root.data) && checkBST(root.right, root.data, maxValue);
	}

}
