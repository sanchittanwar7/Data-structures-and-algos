package linkedList;

import linkedList.node;

public class ReverseIteratively {

	
	public static void main(String[] args) {
		node head = node.takeInput();
		head = reverse(head);
		node.print(head);
	}

	private static node reverse(node head) {
		node prev = head, temp;
		if(head.next == null)
			return head;
		node current = head.next;
		head.next = null;
		while(current.next != null){
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		current.next = prev;
		return current;
	}

}
