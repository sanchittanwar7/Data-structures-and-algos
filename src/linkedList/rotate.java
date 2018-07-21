package linkedList;

public class rotate {

	public static void main(String[] args) {
		ListNode head = ListNode.takeInput();
		int n = 4;
		head = rotateRight(head, n);
		ListNode.print(head);
	}
	
	public static ListNode rotateRight(ListNode head, int n) {
		if(head == null)
			return null;
		ListNode temp = head;
		int len = 1;
		while(temp.next != null) {
			temp = temp.next;
			len++;
		}
		System.out.println(len);
		n = n%len;
		if(n == 0)
			return head;
		temp.next = head;
		temp = head;
		for(int i = 0; i < len-n-1; i++) {
			temp = temp.next;
		}
		head = temp.next;
		temp.next = null;
		return head;
	}

}
