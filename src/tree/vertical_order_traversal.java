package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


//6 3 7 2 5 -1 9 -1 -1 -1 -1 -1 -1

//3709 4465 2668 -1 -1 -1 -1 

public class vertical_order_traversal {
	
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

	public static void main(String[] args) {
		TreeNode root = TreeNodeUse.takeInput();
		TreeNodeUse.print(root);
		ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
		for(ArrayList<Integer> row : ans)
			System.out.println(row);
	}
	
	public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
		setMap(root, 0);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> sortedKeys = new ArrayList<>(map.keySet());
		Collections.sort(sortedKeys);
		for(Integer key : sortedKeys) {
			ans.add(map.get(key));
		}
		return ans;
    }

	private static void setMap(TreeNode root, int key) {
		if(root == null)
			return;
		ArrayList<Integer> arr;
		if(map.containsKey(key)) {
			arr = map.get(key);
		}
		else {
			arr = new ArrayList<>();
		}
		arr.add(root.val);
		map.put(key, arr);
		setMap(root.left, key-1);
		setMap(root.right, key+1);
	}

}
