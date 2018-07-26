package linkedList;

import java.util.ArrayList;

public class partition_list {

	public static void main(String[] args) {
		ListNode head = ListNode.takeInput();
		int n = 3;
		head = partition(head, n);
		ListNode.print(head);
	}
	public static ListNode partition(ListNode head, int n) {
		ListNode temp = head;
		int i = 0, yahaDaal = 0, ele;
		ArrayList<Integer> arr = new ArrayList<>();
		while(temp != null) {
			arr.add(temp.val);
			temp = temp.next;
		}
		while(i < arr.size()) {
			ele = arr.get(i);
			if(ele < n) {
				arr.add(yahaDaal, ele);
				arr.remove(i+1);
				yahaDaal++;
			}
			i++;
		}
		temp = head;
		for(Integer element : arr) {
			temp.val = element;
			temp = temp.next;
		}
		return head;
    }

}
