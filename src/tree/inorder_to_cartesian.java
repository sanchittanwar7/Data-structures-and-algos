package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class inorder_to_cartesian {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3));
		TreeNode root = buildTree(a);
		System.out.println(postorderTraversal(root));
		System.out.println(preorderTraversal(root));
	}

	public static TreeNode buildTree(ArrayList<Integer> a) {
		return helper(a, 0, a.size()-1);
    }
	
	private static TreeNode helper(ArrayList<Integer> a, int start, int end) {
		if(start > end)
			return null;
		if(start == end)
			return new TreeNode(a.get(start));
		int max = Integer.MIN_VALUE, maxIndex = 0;
		for(int i = start; i <= end; i++) {
			if(a.get(i) > max) {
				max = a.get(i);
				maxIndex = i;
			}
		}
		TreeNode node = new TreeNode(max);
		node.left = helper(a, start, maxIndex-1);
		node.right = helper(a, maxIndex+1, end);
		return node;
	}

	public static ArrayList<Integer> preorderTraversal(TreeNode head) {
		if(head == null)
			return new ArrayList<>();
		ArrayList<Integer> left, right, ans = new ArrayList<>();
		ans.add(head.val);
		left = preorderTraversal(head.left);
		right = preorderTraversal(head.right);
		for(Integer node : left)
			ans.add(node);
		for(Integer node : right)
			ans.add(node);
		return ans;
    }
	
	public static ArrayList<Integer> postorderTraversal(TreeNode head) {
		if(head == null)
			return new ArrayList<>();
		ArrayList<Integer> left, right, ans = new ArrayList<>();
		left = postorderTraversal(head.left);
		right = postorderTraversal(head.right);
		for(Integer node : left)
			ans.add(node);
		for(Integer node : right)
			ans.add(node);
		ans.add(head.val);
		return ans;
    }
	
}
