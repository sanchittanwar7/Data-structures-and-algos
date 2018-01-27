package tree;

import java.util.ArrayList;
import java.util.HashMap;

public class DiagonalSum {

	/**
	 * @param args
	 */
	
	//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
	//5 2 9 1 3 8 10 -1 -1 -1 -1 -1 -1 -1 -1
	
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	
	public static void main(String[] args) {
		int sum;
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		divide(root, 1);
		System.out.println(map);
		for(Integer key : map.keySet()){
			sum = 0;
			for(Integer value : map.get(key))
				sum += value;
			System.out.println(key + " : " + sum);
		}
	}

	private static void divide(BinaryTreeNode<Integer> root, int diagonalNumber) {
		if(root == null)
			return;
		ArrayList<Integer> nodes = map.get(diagonalNumber);
		if(nodes == null)
			nodes = new ArrayList<Integer>();
		nodes.add(root.data);
		map.put(diagonalNumber, nodes);
		divide(root.left, diagonalNumber + 1);
		divide(root.right, diagonalNumber);
		
	}

}
