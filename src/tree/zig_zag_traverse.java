package tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//3 9 20 -1 -1 15 7 -1 -1 -1 -1

public class zig_zag_traverse {

	public static void main(String[] args) {
		TreeNode root = TreeNodeUse.takeInput();
		TreeNodeUse.print(root);
		ArrayList<ArrayList<Integer>> ans = zigzagLevelOrder(root);
		for(ArrayList<Integer> row : ans)
			System.out.println(row);
	}

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		boolean chance = false;
		Queue<TreeNode> s1 = new LinkedList<>();
		s1.add(root);
		s1.add(null);
		ArrayList<Integer> row;
		TreeNode node;
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		while(s1.size() > 1) {
			row = new ArrayList<>();
			while(s1.peek() != null) {
				node = s1.poll();
				row.add(node.val);
				if(node.left != null)
					s1.add(node.left);
				if(node.right != null)
					s1.add(node.right);
			}
			s1.poll();
			s1.add(null);
			if(chance) {
				Collections.reverse(row);
			}
			ans.add(row);
			chance = !chance; 
		}
		return ans;
	}

}
