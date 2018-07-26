package linkedList;

public class merge_sort {

	public static void main(String[] args) {
		ListNode head = ListNode.takeInput();
		head = mSort(head);
		ListNode.print(head);
	}

	private static ListNode mSort(ListNode head) {
		if(head.next == null)
			return head;
		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null) {
			if(fast.next.next == null) {
				fast = fast.next;
				break;
			}
			slow = slow.next;
			fast = fast.next.next == null ? fast.next : fast.next.next;
		}
		ListNode tHead = slow.next;
		slow.next = null;
		ListNode h1 = mSort(head);
		ListNode h2 = mSort(tHead);
		return merge(h1, h2);
	}
	
	private static ListNode merge(ListNode head1, ListNode head2) {
		ListNode head = null, tail = null;
		while(head1 != null && head2 != null){
			if(head1.val < head2.val){
				if(head == null){
					head = head1;
					tail = head1;
					head1 = head1.next;
				}
				else{
					tail.next = head1;
					tail = head1;
					head1 = head1.next;

				}
			}
			else{
				if(head == null){
					head = head2;
					tail = head2;
					head2 = head2.next;
				}
				else{
					tail.next = head2;
					tail = head2;

					head2 = head2.next;

				}
			}
		}
		if(head2 != null){
			if(tail == null){
				head = head2;
				tail = head2;
				head2 = head2.next;
			}
			tail.next = head2;
		}
		
		if(head1 != null){
			if(tail == null){
				head = head1;
				tail = head1;
				head1 = head1.next;
			}
			tail.next = head1;
		}
		return head;
	}

}
