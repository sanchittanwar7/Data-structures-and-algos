package linkedList;

public class series_sum {

	public static void main(String[] args) {
		ListNode head = ListNode.takeInput();
		getSum(head);
		ListNode.print(head);
	}

	private static void getSum(ListNode head) {
		ListNode temp = head, prev = null;
		int sum = 0;
		boolean isFirst = true;
		while(temp != null) {
			sum = 0;
			while(temp != null && temp.val != 0) {
				sum += temp.val;
				temp = temp.next;
			}
			if(isFirst) {
				head.val = sum;
				prev = head;
				head.next = temp;
				temp = temp == null ? null : temp.next;
				isFirst = !isFirst;
			}
			else {
				ListNode newNode = new ListNode(sum);
				prev.next = newNode;
				prev = newNode;
				temp = temp == null ? null : temp.next;
			}

		}
	}

}
