package tree;

import java.util.ArrayList;
import java.util.Arrays;

//5 4 8 11 -1 13 4 7 2 -1 -1 5 1 -1 -1 -1 -1 -1 -1 -1 -1

public class path_with_sum {

	public static void main(String[] args) {
		TreeNode root = TreeNodeUse.takeInput();
		TreeNodeUse.print(root);
		int sum = 22;
		ArrayList<ArrayList<Integer>> ans = pathSum(root, sum);
		for(ArrayList<Integer> list : ans)
			System.out.println(list);
	}

	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		if(root == null)
			return new ArrayList<>();
		if(root.left == null && root.right == null) {
			if(root.val == sum) {
				ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
				ans.add(new ArrayList<>(Arrays.asList(root.val)));
				return ans;
			}
			return new ArrayList<>();
		}
		ArrayList<ArrayList<Integer>> left = pathSum(root.left, sum - root.val);
		ArrayList<ArrayList<Integer>> right = pathSum(root.right, sum - root.val);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if(left.size() != 0) {
			for(ArrayList<Integer> list : left) {
				list.add(0, root.val);
				ans.add(list);
			}
		}
		if(right.size() != 0) {
			for(ArrayList<Integer> list : right) {
				list.add(0, root.val);
				ans.add(list);
			}
		}
		return ans;
	}

}
