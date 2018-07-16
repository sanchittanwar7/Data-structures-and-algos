package tree;

//1 2 2 3 4 4 3 -1 -1 -1 -1 -1 -1 -1 -1
//1 2 2 -1 3 -1 3 -1 -1 -1 -1

public class IsSymmetric {

	public static void main(String[] args) {
		TreeNode root = TreeNodeUse.takeInput();
		TreeNodeUse.print(root);
		System.out.println(isSymmetric(root));
	}
	
	public static int isSymmetric(TreeNode root1) {
		TreeNode root2 = reverse(root1);
		TreeNodeUse.print(root1);
		TreeNodeUse.print(root2);
		return isSameTree(root1, root2);
    }
	
	private static TreeNode reverse(TreeNode root) {
		if(root == null)
			return null;
		TreeNode newRoot = new TreeNode(root.val);
		TreeNode left = reverse(root.left);
		TreeNode right = reverse(root.right);
		newRoot.left = right;
		newRoot.right = left;
		return newRoot;
	}

	public static int isSameTree(TreeNode root1, TreeNode root2) {
		if(root1 == null || root2 == null) {
			if(root1 == null && root2 == null)
				return 1;
			return 0;
		}
		if(root1.val != root2.val)
			return 0;
		int left = isSameTree(root1.left, root2.left);
		int right = isSameTree(root1.right, root2.right);
		return left == 1 && right == 1 ? 1 : 0;
    }

}
