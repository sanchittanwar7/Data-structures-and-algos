package linkedList;

public class k_reverse {

	public static void main(String[] args) {
		ListNode head = ListNode.takeInput();
		int n = 1;
		head = reverseList(head, n);
		ListNode.print(head);
	}

	public static ListNode reverseList(ListNode head, int k) {
		ListNode start = head, prev = null, newStart, end = head, reverseHead, reverseEnd;
		int i;
		while(end != null) {
			i = 1;
			while(i < k) {
				end = end.next;
				i++;
			}
			newStart = end.next;
			end.next = null;
			reverseHead = reverse(start);
			reverseEnd = reverseHead;
			while(reverseEnd.next != null)
				reverseEnd = reverseEnd.next;
			if(prev == null) {
				head = reverseHead;
			}
			else {
				prev.next = reverseHead;
			}
			prev = reverseEnd;
			reverseEnd.next = newStart;
			start = newStart;
			end = newStart;
		}
		return head;
	}

	public static ListNode reverse(ListNode node) {
		ListNode prev = null, curr = node, next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		node = prev;
		return node;
	}

}
