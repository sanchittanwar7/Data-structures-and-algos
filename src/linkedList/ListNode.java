package linkedList;

import java.util.Scanner;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int val){
		this.val = val;
	}
	
	public static ListNode takeInput(){
		Scanner s = new Scanner(System.in);
		ListNode head = null;
		ListNode tail = null;
		System.out.println("Enter val...press -1 when finished : ");
		int val = s.nextInt();
		while(val != -1){
			ListNode newNode = new ListNode(val);
			if(head == null){
				head = newNode;
				tail = newNode;
			}
			else{
				tail.next = newNode;
				tail = newNode;
			}
			val = s.nextInt();
		}
		return head;
	}
	
	public static void print(ListNode head){
		while(head != null){
			System.out.print(head.val + "-->");
			head = head.next;
		}
		System.out.println("null");
	}

}
