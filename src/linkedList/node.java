package linkedList;

import java.util.Scanner;

public class node {
	public int data;
	public node next;
	
	public node(int data){
		this.data = data;
	}
	
	public static node takeInput(){
		Scanner s = new Scanner(System.in);
		node head = null;
		node tail = null;
		System.out.println("Enter data...press -1 when finished : ");
		int data = s.nextInt();
		while(data != -1){
			node newNode = new node(data);
			if(head == null){
				head = newNode;
				tail = newNode;
			}
			else{
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
	
	public static void print(node head){
		while(head != null){
			System.out.print(head.data + "-->");
			head = head.next;
		}
		System.out.println("null");
	}
}
