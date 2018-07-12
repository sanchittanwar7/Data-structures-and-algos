package linkedList;

public class remove_duplicates_2 {

	public static void main(String[] args) {
		ListNode head = ListNode.takeInput();
		head = removeDuplicates(head);
		ListNode.print(head);
	}
	
	private static ListNode removeDuplicates(ListNode head) {
		ListNode current = head, fast = head, prev = null;
		while(fast != null) {
			while(fast != null && fast.val == current.val)
				fast = fast.next;
			if(prev == null && current.next != fast) {
				head = fast;
				current = fast;
			}
			else if(current.next == fast) {
				prev = current;
				current = fast;
			}
			else {
				prev.next = fast;
				current = fast;
			}
		}
		return head;
	}

}
