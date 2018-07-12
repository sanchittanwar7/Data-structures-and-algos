package linkedList;

public class remove_nth_node {

	public static void main(String[] args) {
		ListNode head = ListNode.takeInput();
		int n = 8;
		head = removeNthNode(head, n);
		ListNode.print(head);
	}

	private static ListNode removeNthNode(ListNode head, int n) {
		ListNode temp = head;
		int len = 0;
		while(temp != null) {
			temp = temp.next;
			len++;
		}
		if(len <= n)
			return head.next;
		temp = head;
		while(len > n+1) {
			temp = temp.next;
			len--;
		}
		temp.next = temp.next == null ? null : temp.next.next;
		return head;
	}

}
