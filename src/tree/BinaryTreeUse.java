package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinaryTreeNode<T>{
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	public BinaryTreeNode(T data){
		this.data = data;
	}
}

//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1

public class BinaryTreeUse {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		print(root);
	}

	public static void print(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode = pendingNodes.remove();
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

	public static BinaryTreeNode<Integer> takeInput() {
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
				currentNode.left = child;
				pendingNodes.add(child);
			}
			System.out.println("Enter right child of " + currentNode.data + " : ");
			data = s.nextInt();
			if(data != -1){
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(data);
				currentNode.right = child;
				pendingNodes.add(child);
			}
		}
		return root;
	}

}
