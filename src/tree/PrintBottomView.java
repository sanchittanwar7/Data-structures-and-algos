package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class PrintBottomView {

	/**
	 * @param args
	 */
	
	//1 2 3 4 5 6 7 -1 8 9 -1 -1 10 -1 11 -1 -1 -1 -1 -1 -1 -1 -1
	
	static HashMap<Integer, ArrayList<BinaryTreeNode<Integer>>> map = new HashMap<Integer, ArrayList<BinaryTreeNode<Integer>>>();
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		getBottom(root, 0);
		Set<Integer> s = map.keySet();
		ArrayList<BinaryTreeNode<Integer>> list;
		for(Integer key : s){
			list = map.get(key);
			System.out.print(list.get(list.size()-1).data + " ");
		}
	}

	private static void getBottom(BinaryTreeNode<Integer> root, int value) {
		if(root == null)
			return;
		ArrayList<BinaryTreeNode<Integer>> temp = map.get(value);
		if(temp == null)
			temp = new ArrayList<BinaryTreeNode<Integer>>();
		temp.add(root);
		map.put(value, temp);
		getBottom(root.left, value-1);
		getBottom(root.right, value+1);
	}

}
