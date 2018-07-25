package tree;

import java.util.LinkedList;
import java.util.Queue;

//1 2 5 3 4 6 7 -1 -1 -1 -1 -1 -1 -1 -1

public class next_pointer_btree {

	public static void main(String[] args) {
		TreeNode root = TreeNodeUse.takeInput();
		TreeNodeUse.print(root);
		connect(root);
		print(root);
	}

	public static void connect(TreeNode root) {
		Queue<TreeNode> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		pendingNodes.add(null);
		TreeNode current;
		while(pendingNodes.size() > 1) {
			current = pendingNodes.remove();
			if(current != null) {
				current.next = pendingNodes.peek();
				if(current.left != null) {
					pendingNodes.add(current.left);
				}
				if(current.right != null) {
					pendingNodes.add(current.right);
				}
			}
			else {
				pendingNodes.add(null);
			}
		}
	}

	public static void print(TreeNode root) {
		Queue<TreeNode> pendingNodes = new LinkedList<TreeNode>();
		pendingNodes.add(root);
		int rightNode;
		while(!pendingNodes.isEmpty()){
			TreeNode currentNode = pendingNodes.remove();
			rightNode = currentNode.next == null ? -1 : currentNode.next.val;
			System.out.print(currentNode.val + "->" + rightNode +  " : ");
			if(currentNode.left != null){
				System.out.print(currentNode.left.val);
				pendingNodes.add(currentNode.left);
			}
			if(currentNode.right != null){
				System.out.print(", " + currentNode.right.val);
				pendingNodes.add(currentNode.right);
			}
			System.out.println();
		}		
	}

}
