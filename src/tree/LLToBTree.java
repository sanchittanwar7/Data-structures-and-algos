package tree;

import java.util.Scanner;

class LLnode{
	int data;
	LLnode prev;
	LLnode next;
	
	LLnode(int data, LLnode tail){
		this.data = data;
		prev = tail;
		next = null;
	}
}

public class LLToBTree {

	static LLnode head;
	static LLnode tail;
	
	public static void createLL(){
		Scanner s = new Scanner(System.in);
		int data;
		System.out.println("Enter data of LL...press -1 when done : ");
		data = s.nextInt();
		while(data != -1){
			LLnode n = new LLnode(data, tail);
			if(head == null){
				head = n;
				tail = n;
			}
			else{
				tail.next = n;
				tail = n;
			}
			data = s.nextInt();
		}
	}
	
	public static void printLL(){
		LLnode temp = head;
		while(temp != null){
			System.out.print(temp.data + "<->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		createLL();
		printLL();
		BinaryTreeNode<Integer> root = createBST(head, tail);
		BinaryTreeUse.print(root);
	}

	private static BinaryTreeNode<Integer> createBST(LLnode start, LLnode end) {
		if(start == null || end == null || start.data > end.data)
			return null;
		LLnode slow = start;
		LLnode fast = start;
		LLnode prev = null;
		while(fast != end){
			prev = slow;
			slow = slow.next;
			if(fast.next == end || fast.next == null)
				break;
			fast = fast.next.next;
			
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode(slow.data);
		root.left = createBST(start, prev);
		root.right = createBST(slow.next, end);
		return root;
	}

}
