package linkedList;

public class insertion_sort {

	public static void main(String[] args) {
		ListNode head = ListNode.takeInput();
		head = iSort(head);
		ListNode.print(head);
	}

	public static ListNode iSort(ListNode head) {
		ListNode temp = head.next, loop, tempKaNext, pos;
		while(temp != null) {
			loop = head;
			pos = null;
			tempKaNext = temp.next;
			loop = head;
			while(loop.next != temp) {
				if(loop.val < temp.val)
					pos = loop;
				loop = loop.next;
			}
			if(temp.val >= loop.val) {
				temp = temp.next;
				continue;
			}
			if(temp.val < head.val) {
				loop.next = temp.next;
				temp.next = head;
				head = temp;
			}
			else {
				loop.next = temp.next;
				temp.next = pos.next;
				pos.next = temp;
			}
			temp = tempKaNext;
		}
		return head;
	}

}
