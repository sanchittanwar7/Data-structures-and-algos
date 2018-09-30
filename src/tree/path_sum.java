package tree;

//5 4 8 11 -1 13 4 7 2 -1 -1 -1 1 -1 -1 -1 -1 -1 -1
//1000 200 -1 -1 -1

public class path_sum {

	public static void main(String[] args) {
		TreeNode root = TreeNodeUse.takeInput();
		TreeNodeUse.print(root);
		int sum = 22;
		int ans = hasPathSum(root, sum);
		System.out.println(ans);
	}
	
	public static int hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			if(sum == 0)
				return 1;
			return 0;
		}
		int leftAns = hasPathSum(root.left, sum - root.val);
		int rightAns = hasPathSum(root.right, sum - root.val);
		return leftAns == 1 || rightAns == 1 ? 1 : 0;
    }

}
