package linkedList;

public class subtract {

	public static void main(String[] args) {
		ListNode head = ListNode.takeInput();
		head = subtract(head);
		ListNode.print(head);
	}
	
	public static ListNode subtract(ListNode head) {
		ListNode newHead = head;
		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null) {
			if(fast.next.next == null) {
				fast = fast.next;
				break;
			}
			slow = slow.next;
			fast = fast.next.next == null ? fast.next : fast.next.next;
		}
		newHead = null;
		slow = slow.next;
		while(slow != null) {
			ListNode newNode = new ListNode(slow.val);
			newNode.next = newHead;
			newHead = newNode;
			slow = slow.next;
		}
		slow = head;
		while(newHead != null) {
			slow.val = newHead.val - slow.val;
			newHead = newHead.next;
			slow = slow.next;
		}
		return head;
    }
}
