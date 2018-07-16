package tree;

class pair{
	int val, height;
	pair(int val, int height){
		this.val = val;
		this.height = height;
	}
}

//1 2 3 -1 -1 -1 -1
//3 2 -1 1 -1 -1 -1

public class isBalanced {

	public static void main(String[] args) {
		TreeNode root = TreeNodeUse.takeInput();
		TreeNodeUse.print(root);
		System.out.println(isBalanced(root));
	}

	public static int isBalanced(TreeNode root) {
		return check(root).val;
	}

	private static pair check(TreeNode root) {
		if(root == null) {
			return new pair(1, 0);
		}
		pair leftPair = check(root.left);
		pair rightPair = check(root.right);
		if(leftPair.val == 0 || rightPair.val == 0 || Math.abs(leftPair.height - rightPair.height) > 1)
			return new pair(0, 0);
		return new pair(1, Math.max(leftPair.height, rightPair.height) + 1);
	}

}
