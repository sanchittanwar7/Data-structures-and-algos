package linkedList;

public class remove_duplicates {

	public static void main(String[] args) {
		ListNode head = ListNode.takeInput();
		head = removeDuplicates(head);
		ListNode.print(head);
	}

	private static ListNode removeDuplicates(ListNode head) {
		ListNode current = head, fast = head;
		while(fast != null) {
			while(fast != null && fast.val == current.val)
				fast = fast.next;
			current.next = fast;
			current = fast;
		}
		return head;
	}

}
