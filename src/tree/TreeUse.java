package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class treeNode<T>{
	T data;
	ArrayList<treeNode<T>> children;
	
	public treeNode(T data){
		this.data = data;
		children = new ArrayList<treeNode<T>>();
	}
}

// 1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1

public class TreeUse {
	
	public static void main(String[] args) {
		treeNode<Integer> root = takeInput();
		print(root);
	}

	public static void print(treeNode<Integer> root) {
		Queue<treeNode<Integer>> pendingNodes = new LinkedList<treeNode<Integer>>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			treeNode<Integer> currentNode = pendingNodes.remove();
			System.out.print(currentNode.data +  " : ");
			for(treeNode<Integer> child : currentNode.children){
				System.out.print(child.data + ", ");
				pendingNodes.add(child);
			}
			System.out.println();
		}
	}

	public static treeNode<Integer> takeInput() {
		int data, n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data : ");
		data = s.nextInt();
		Queue<treeNode<Integer>> pendingNodes = new LinkedList<treeNode<Integer>>();
		treeNode<Integer> root = new treeNode<Integer>(data);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			treeNode<Integer> currentNode = pendingNodes.remove();
			System.out.println("Enter number of children of " + currentNode.data + " : ");
			n = s.nextInt();
			for(int i = 0; i < n; i++){
				System.out.println("Enter data of " + (i+1) + "th child : ");
				data = s.nextInt();
				if(data == -1)
					break;
				treeNode<Integer> childNode = new treeNode<Integer>(data);
				currentNode.children.add(childNode);
				pendingNodes.add(childNode);
			}
		}
		return root;
	}

}
