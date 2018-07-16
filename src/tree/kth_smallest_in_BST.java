package tree;

import java.util.ArrayList;

//2 1 3 -1 -1 -1 -1

public class kth_smallest_in_BST {

	public static void main(String[] args) {
		TreeNode root = TreeNodeUse.takeInput();
		TreeNodeUse.print(root);
		int k = 2;
		System.out.println(kthsmallest(root, k));
	}
	
	public static int kthsmallest(TreeNode root, int k) {
		ArrayList<Integer> inorder = inorderTraversal(root);
		return inorder.get(k-1);
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

}
