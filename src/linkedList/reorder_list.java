package linkedList;

public class reorder_list {

	public static void main(String[] args) {
		ListNode head = ListNode.takeInput();
		head = re(head);
		ListNode.print(head);
	}

	public static ListNode reorderList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode temp = head;
		while(temp.next != null && temp.next.next != null)
			temp = temp.next;
		ListNode tail = temp.next, newHead = head.next;
		temp.next = null;
		head.next = tail;
		if(head != temp)
			tail.next = reorderList(newHead);
		return head;
	}
	
	public static ListNode reorder(ListNode head) {
		ListNode last = head, start = head, loop, temp;
		while(last.next != null)
			last = last.next;
		while(start != last) {
			loop = start;
			while(loop.next != last)
				loop = loop.next;
			if(start == loop)
				break;
			temp = start.next;
			start.next = last;
			last.next = temp;
			last = loop;
			last.next = null;
			start = temp;
		}
		return head;
	}
	
	public static ListNode re(ListNode node) {
		if(node == null)
			return node;
		ListNode slow = node, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node1 = node;
        ListNode node2 = slow.next;
        slow.next = null;
        node2 = reverselist(node2);
        node = new ListNode(0);
        ListNode curr = node;
        while (node1 != null || node2 != null) {
            if (node1 != null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }
            if (node2 != null) {
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }
        node = node.next;
        return node;
	}
	
	public static ListNode reverselist(ListNode node) {
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
