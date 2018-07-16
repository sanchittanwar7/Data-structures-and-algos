package tree;

import java.util.ArrayList;

//1 -1 2 3 -1 -1 -1

public class inorder {

	public static void main(String[] args) {
		TreeNode head = TreeNodeUse.takeInput();
		TreeNodeUse.print(head);
		ArrayList<Integer> ans = inorderTraversal(head);
		System.out.println("IN : " + ans);
		ans = preorderTraversal(head);
		System.out.println("PRE : " + ans);
		ans = postorderTraversal(head);
		System.out.println("POST : " + ans);
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
