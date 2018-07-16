package tree;

import java.util.ArrayList;

//1 2 3 -1 -1 -1 -1

public class recover_BST {

	public static void main(String[] args) {
		TreeNode root = TreeNodeUse.takeInput();
		TreeNodeUse.print(root);
		ArrayList<Integer> ans = recoverTree(root);
		System.out.println(ans);

	}



	private static ArrayList<Integer> recoverTree(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayList<Integer> inorder = inorderTraversal(root);
		int prev, next;
		for(int i = 0; i < inorder.size(); i++) {
			prev = i == 0 ? Integer.MIN_VALUE : inorder.get(i-1);
			next = i == inorder.size()-1 ? Integer.MAX_VALUE : inorder.get(i+1);
			if(inorder.get(i) > prev || inorder.get(i) < next)
				ans.add(inorder.get(i));
		}
		return ans;
	}
	
	public static ArrayList<Integer> inorderTraversal(TreeNode head) {
		if(head == null)
			return new ArrayList<>();
		ArrayList<Integer> left, right, ans = new ArrayList<>();
		left = inorderTraversal(head.left);
		right = inorderTraversal(head.right);
		for(Integer node : left)
			ans.add(node);
		ans.add(head.val);
		for(Integer node : right)
			ans.add(node);
		return ans;
    }



	//	public static ArrayList<Integer> recoverTree(TreeNode root) {
	//		ans = new ArrayList<>();
	//		recover(root, Integer.MAX_VALUE, false);
	//		return ans;
	//    }

//	private static void recover(TreeNode root, int parent, boolean isRight) {
//		if(root == null)
//			return;
//		//		if(ans.size() >= 2)
//		//			return;
//		int left = root.left == null ? Integer.MIN_VALUE : root.left.val;
//		int right = root.right == null ? Integer.MAX_VALUE : root.right.val;
//		boolean isGoodWithParent = isRight ? root.val > parent : root.val < parent;
//		if(!(root.val > left && root.val < right && isGoodWithParent))
//			ans.add(root.val);
//		recover(root.left, root.val, false);
//		recover(root.right, root.val, true);
//	}
}
