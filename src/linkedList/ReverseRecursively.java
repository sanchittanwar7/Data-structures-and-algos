package linkedList;
import linkedList.node;

class pair{
	node head;
	node tail;
	
	pair(node head, node tail){
		this.head = head;
		this.tail = tail;
	}
}

public class ReverseRecursively {

	public static void main(String[] args) {
		node head = node.takeInput();
		node.print(head);
		pair p = reverse(head);
		node.print(p.head);
	}

	private static pair reverse(node head) {
		if(head.next == null){
			pair p = new pair(head, head);
			return p;
		}
		pair ans = reverse(head.next);
		ans.tail.next = head;
		head.next = null;
		return new pair(ans.head, head);
	}

}
