package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinaryTreeNode<T>{
	T data;
	ArrayList<BinaryTreeNode<T>> children;
	
	public BinaryTreeNode(T data){
		this.data = data;
		children = new ArrayList<BinaryTreeNode<T>>();
	}
}

//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1

public class BinaryTreeUse {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		print(root);
	}

	private static void print(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode = pendingNodes.remove();
			System.out.print(currentNode.data +  " : ");
			for(BinaryTreeNode<Integer> child : currentNode.children){
				System.out.print(child.data + ", ");
				pendingNodes.add(child);
			}
			System.out.println();
		}		
	}

	private static BinaryTreeNode<Integer> takeInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data : ");
		int data = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode = pendingNodes.remove();
			System.out.println("Enter left child of " + currentNode.data + " : ");
			data = s.nextInt();
			if(data != -1){
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(data);
				currentNode.children.add(child);
				pendingNodes.add(child);
			}
			System.out.println("Enter right child of " + currentNode.data + " : ");
			data = s.nextInt();
			if(data != -1){
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(data);
				currentNode.children.add(child);
				pendingNodes.add(child);
			}
		}
		return root;
	}

}
