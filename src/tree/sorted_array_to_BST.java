package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sorted_array_to_BST {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		TreeNode root = sortedArrayToBST(arr);
		arr = inorderTraversal(root);
		System.out.println(arr);
	}
	
	public static TreeNode sortedArrayToBST(final List<Integer> a) {
		return helper(a, 0, a.size()-1);
    }
	
	private static TreeNode helper(List<Integer> a, int start, int end) {
		if(end < start)
			return null;
		int mid = (start + end)/2;
		TreeNode root = new TreeNode(a.get(mid));
		TreeNode left = helper(a, start, mid-1);
		TreeNode right = helper(a, mid+1, end);
		root.left = left;
		root.right = right;
		return root;
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
