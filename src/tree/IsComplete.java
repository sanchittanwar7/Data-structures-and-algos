package tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsComplete {

	/**
	 * @param args
	 */
	//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
	//5 2 9 1 3 8 10 -1 -1 11 -1 -1 -1 -1 -1 -1 -1
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		System.out.println(isComplete(root));
	}

	private static boolean isComplete(BinaryTreeNode<Integer> root) {
		boolean hasFound = false;
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode = pendingNodes.remove();
			if(currentNode.left == null && currentNode.right != null)
				return false;
			if(currentNode.right == null && !hasFound)
				hasFound = true;
			else if(hasFound && (currentNode.left != null || currentNode.right != null))
				return false;
			if(currentNode.left != null)
				pendingNodes.add(currentNode.left);
			if(currentNode.right != null)
				pendingNodes.add(currentNode.right);
		}
		return true;
	}

}
