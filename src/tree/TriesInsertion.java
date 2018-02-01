package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class triesNode{
	int value;
	boolean isLeaf;
	char charValue;
	ArrayList<triesNode> children;

	triesNode(int value, char charValue, boolean isLeaf){
		this.value = value;
		this.charValue = charValue;
		this.isLeaf = isLeaf;
		children = new ArrayList<triesNode>();
		for(int i = 0; i < 27; i++)
			children.add(i, null);
	}
}


public class TriesInsertion {

	final static int INVALID_NUM = Integer.MIN_VALUE;
	static triesNode root = new triesNode(INVALID_NUM, '^', false);

	public static void main(String[] args) {
		insert(root, "abc", 1);
		insert(root, "abb", 5);
		insert(root, "sanchit", 7);
		print();
		System.out.println(search(root, "abc"));
		System.out.println(search(root, "sanchit"));
	}

	private static int search(triesNode current, String string) {
		if(string.length() == 1){
			int pos = (int)string.charAt(0) - 96;
			if(current.children.get(pos) != null && current.children.get(pos).isLeaf == true)
				return current.children.get(pos).value;
			return INVALID_NUM;
		}
		int pos = (int)string.charAt(0) - 96;
		if(current.children.get(pos) == null)
			return INVALID_NUM;
		return search(current.children.get(pos), string.substring(1));
	}

	private static void insert(triesNode current, String str, int i) {
		if(str.length() == 1){
			int pos = (int)str.charAt(0) - 96;
			if(current.children.get(pos) != null){
				System.out.println("Redundant pair");
				return;
			}
			triesNode newNode = new triesNode(i, str.charAt(0), true);
			current.children.set(pos, newNode);
			return;
		}
		int pos = (int)str.charAt(0) - 96;
		if(current.children.get(pos) == null){
			triesNode newNode = new triesNode(INVALID_NUM, str.charAt(0), false);
			current.children.set(pos, newNode);
		}
		current = current.children.get(pos);
		insert(current, str.substring(1), i);
	}

	public static void print() {
		Queue<triesNode> pendingNodes = new LinkedList<triesNode>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			triesNode currentNode = pendingNodes.remove();
			System.out.print("(" + currentNode.charValue + ", " + currentNode.value + ")" +  " : ");
			for(triesNode child : currentNode.children){
				if(child != null){
					System.out.print("(" + child.charValue + ", " + child.value + ")" + ", ");
					pendingNodes.add(child);
				}
			}
			System.out.println();
		}
	}

}
