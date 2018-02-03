package tree;

import java.util.ArrayList;

public class RootToLeafPaths {

	/**
	 * @param args
	 */

	//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		BinaryTreeUse.print(root);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		printPaths(root, ans);
	}

	private static void printPaths(BinaryTreeNode<Integer> root, ArrayList<Integer> ans) {
		if(root.left == null && root.right == null){
			ans.add(root.data);
			System.out.println(ans);
			ans.remove(root.data);
			return;
		}
		if(root.left != null){
			ans.add(root.data);
			printPaths(root.left, ans);
			ans.remove(root.data);
		}
		if(root.right != null){
			ans.add(root.data);
			printPaths(root.right, ans);
			ans.remove(root.data);
		}
	}
}
