package linkedList;

public class swap_nodes_in_pairs {

	public static void main(String[] args) {
		ListNode head = ListNode.takeInput();
		head = swapPairs(head);
		ListNode.print(head);
	}
	
	public static ListNode swapPairs(ListNode head) {
		ListNode temp = head, prev, next, first, second;
		int len = 0;
		while(temp != null) {
			len++;
			temp = temp.next;
		}
		if(len < 2)
			return head;
		first = head;
		second = first.next;
		next = second.next;
		second.next = first;
		first.next = next;
		head = second;
		
		prev = first;
		first = next;
		second = first == null ? null : first.next;
		next = second == null ? null : second.next;
		while(second != null) {
			prev.next = second;
			second.next = first;
			first.next = next;
			prev = first;
			first = next;
			second = first == null ? null : first.next;
			next = second == null ? null : second.next;
		}
		return head;
    }

}
