package tree;

//1 2 5 3 4 -1 6 -1 -1 -1 -1 -1 -1

public class flatten_btree_to_ll {

	public static void main(String[] args) {
		TreeNode root = TreeNodeUse.takeInput();
		TreeNodeUse.print(root);
		root = flatten(root);
		TreeNodeUse.print(root);
	}
	
	public static TreeNode flatten(TreeNode root) {
		if(root == null)
			return null;
		TreeNode left = flatten(root.left);
		TreeNode right = flatten(root.right);
		if(left == null) {
			root.left = null;
			root.right = right;
			return root;
		}
		TreeNode lastOfLeft = getLast(left);
		root.right = left;
		root.left = null;
		lastOfLeft.right = right;
		return root;
    }

	private static TreeNode getLast(TreeNode root) {
		if(root.right == null)
			return root;
		return getLast(root.right);
	}

}
