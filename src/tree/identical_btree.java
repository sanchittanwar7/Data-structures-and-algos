package tree;

public class identical_btree {

	public static void main(String[] args) {
		TreeNode root1 = TreeNodeUse.takeInput();
		TreeNodeUse.print(root1);
		TreeNode root2 = TreeNodeUse.takeInput();
		TreeNodeUse.print(root2);
		System.out.println(isSameTree(root1, root2));
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
