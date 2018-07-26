package linkedList;

public class add_two_nos {

	public static void main(String[] args) {
		ListNode head1 = ListNode.takeInput();
		ListNode head2 = ListNode.takeInput();
		ListNode head = addTwoNumbers(head1, head2);
		ListNode.print(head);
	}

	public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		ListNode head = null, tail = null, node;
		int carry = 0, a, b;
		while(head1 != null || head2 != null) {
			a = head1 == null ? 0 : head1.val;
			b = head2 == null ? 0 : head2.val;
			node = new ListNode((a + b + carry) % 10);
			carry = (a + b + carry) / 10;
			if(tail == null) {
				head = node;
				tail = node;
			}
			else {
				tail.next = node;
				tail = node;
			}
			if(head1 != null)
				head1 = head1.next;
			if(head2 != null)
				head2 = head2.next;
		}
		if(carry != 0) {
			node = new ListNode(carry);
			tail.next = node;
		}
		return head;
	}

}
