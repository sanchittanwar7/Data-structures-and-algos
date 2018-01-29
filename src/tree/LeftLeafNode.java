package tree;

public class LeftLeafNode {

	/**
	 * @param args
	 */
	
	//1 2 3 4 5 6 7 -1 8 -1 -1 -1 -1 -1 -1 9 -1 -1 -1
	
	static int sum = 0;
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		calculateSum(root);
		System.out.println(sum);
	}

	private static void calculateSum(BinaryTreeNode<Integer> root) {
		if(root == null)
			return;
		if(root.left != null){
			if(root.left.right == null && root.left.left == null)
				sum += root.left.data;
		}
		calculateSum(root.left);
		calculateSum(root.right);
	}

}
