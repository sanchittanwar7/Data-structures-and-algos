package tree;

import java.util.ArrayList;

//10 9 20 -1 -1 -1 -1

public class two_sum_BST {

	public static void main(String[] args) {
		TreeNode root = TreeNodeUse.takeInput();
		TreeNodeUse.print(root);
		int k = 19;
		System.out.println(t2Sum(root, k));
	}
	
	public static int t2Sum(TreeNode root, int k) {
		ArrayList<Integer> inorder = inorderTraversal(root);
		int start = 0, end = inorder.size()-1;
		System.out.println(inorder);
		while(start < end) {
			if(inorder.get(start) + inorder.get(end) == k)
				return 1;
			if(inorder.get(start) + inorder.get(end) < k)
				start++;
			else
				end--;
		}
		return 0;
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
