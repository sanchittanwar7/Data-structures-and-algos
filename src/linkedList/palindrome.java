package linkedList;

public class palindrome {

	public static void main(String[] args) {
		ListNode head = ListNode.takeInput();
		System.out.println(lPalin(head));
	}
	
	public static int lPalin(ListNode head) {
		ListNode slow = head, fast = head;
		int len = 0;
		while(slow != null) {
			slow = slow.next;
			len++;
		}
		if(len == 1)
			return 1;
		slow = head;
		while(fast != null && fast.next != null) {
			if(fast.next.next == null) {
				fast = fast.next;
				break;
			}
			slow = slow.next;
			fast = fast.next.next == null ? fast.next : fast.next.next;
		}
		slow.next = reverse(slow.next);
		slow = slow.next;
		while(slow != null) {
			if(slow.val != head.val)
				return 0;
			head = head.next;
			slow = slow.next;
		}
		return 1;
    }

	private static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
	}

}
