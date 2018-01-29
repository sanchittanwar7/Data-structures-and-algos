package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SpecialNode{
	int data;
	SpecialNode left, right, parent;

	SpecialNode(int data, SpecialNode parent){
		this.data = data;
		this.parent = parent;
	}
}

//1 2 3 4 5 -1 6 -1 -1 -1 -1 -1 -1

public class InorderSuccessor {

	public static SpecialNode takeInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data : ");
		int data = s.nextInt();
		SpecialNode root = new SpecialNode(data, null);
		Queue<SpecialNode> pendingNodes = new LinkedList<SpecialNode>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			SpecialNode currentNode = pendingNodes.remove();
			System.out.println("Enter left child of " + currentNode.data + " : ");
			data = s.nextInt();
			if(data != -1){
				SpecialNode child = new SpecialNode(data, currentNode);
				currentNode.left = child;
				pendingNodes.add(child);
			}
			System.out.println("Enter right child of " + currentNode.data + " : ");
			data = s.nextInt();
			if(data != -1){
				SpecialNode child = new SpecialNode(data, currentNode);
				currentNode.right = child;
				pendingNodes.add(child);
			}
		}
		return root;
	}

	public static void print(SpecialNode root) {
		Queue<SpecialNode> pendingNodes = new LinkedList<SpecialNode>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			SpecialNode currentNode = pendingNodes.remove();
			System.out.print(currentNode.data +  " : ");
			if(currentNode.left != null){
				System.out.print(currentNode.left.data);
				pendingNodes.add(currentNode.left);
			}
			if(currentNode.right != null){
				System.out.print(", " + currentNode.right.data);
				pendingNodes.add(currentNode.right);
			}
			System.out.println();
		}		
	}

	public static void main(String[] args) {
		SpecialNode root = takeInput();
		print(root);
		SpecialNode node = findNode(root, 4);
		SpecialNode node1 = findNode(root, 5);
//		root = ;
//		System.out.println(root.data);
		System.out.println(inorderSuccessor(root, node1));
	}

	private static SpecialNode findNode(SpecialNode root, int node) {
		if(root == null)
			return null;
		if(root.data == node)
			return root;
		SpecialNode ans = findNode(root.left, node);
		if(ans != null)
			return ans;
		return findNode(root.right, node);
	}

	private static int inorderSuccessor(SpecialNode root,SpecialNode node) {
		if(root == null)
			return -1;
		SpecialNode parent;
		if(node.right != null)
			return leftmostInRightSubTree(node.right);
		else{
			while(true){
				parent = node.parent;
				if(parent == root || parent.left == node){
					break;
				}
				else{
					node = parent;
				}
			}
		}
		return parent.data;
	}

	private static int leftmostInRightSubTree(SpecialNode root) {
		if (root.left == null)
			return root.data;
		return leftmostInRightSubTree(root.left);
	}

}
