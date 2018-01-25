package tree;

class node{
	int data;
	node prev;
	node next;
	
	node(int data){
		this.data = data;
	}
}

//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
//5 2 9 1 3 8 10 -1 -1 -1 -1 -1 -1 -1 -1

public class bTreeToLL {
	static node head;
	static node tail;

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		createList(root);
		printList();
	}

	private static void printList() {
		while(head != null){		
			System.out.print(head.data + "<->");
			head = head.next;
		}
		System.out.println("null");
	}

	private static void createList(BinaryTreeNode<Integer> root) {
		if(root == null)
			return;
		createList(root.left);
		node n = new node(root.data);
		if(head == null){
			n.prev = null;
			n.next = null;
			tail = n;
			head = n;
		}
		else{
			tail.next = n;
			n.prev = tail;
			n.next = null;
			tail = n;
		}
		createList(root.right);
	}

}
