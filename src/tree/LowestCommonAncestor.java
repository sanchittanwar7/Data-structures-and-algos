package tree;

public class LowestCommonAncestor {

	/**
	 * @param args
	 */
	
	//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		int n1 = 4, n2 = 2;
		System.out.println(LCA(root, n1, n2).data);
	}

	private static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> root, int n1, int n2) {
		if(root == null)
			return null;
		if(root.data == n1 || root.data == n2)
			return root;
		BinaryTreeNode<Integer> left_lca = LCA(root.left, n1, n2);
		BinaryTreeNode<Integer> right_lca = LCA(root.right, n1, n2);
		if(left_lca != null && right_lca != null)
			return root;
		return left_lca != null ? left_lca : right_lca;
	}

}
