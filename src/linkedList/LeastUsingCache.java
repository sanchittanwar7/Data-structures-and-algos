package linkedList;

import java.util.HashMap;
import java.util.Scanner;

class LLnode{
	int data;
	LLnode next;
	LLnode previous;
	
	LLnode(int data){
		this.data = data;
	}
}

class DoubleLL{
	LLnode head;
	static int capacity;
	static int size = 0;
	HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

	public DoubleLL(int capacity) {
		DoubleLL.capacity = capacity;
		size = 0;
		head = null;
	}

	void printCacheState() {
		LLnode temp = head;
		while(temp != null){
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println();
	}

	void accessPage(int i) {
		if(map.containsKey(i)){
			deleteNode(i);
			insertAtBeginning(i);
		}
		else{
			map.put(i, true);
			DoubleLL.size++;
			if(size <= capacity){
				insertAtBeginning(i);
			}
			else{
				deleteLast();
				insertAtBeginning(i);
			}
		}
	}

	private void deleteLast() {
		LLnode secondLast = head;
		while(secondLast.next.next != null)
			secondLast = secondLast.next;
		secondLast.next = null;
	}

	private void insertAtBeginning(int i) {
		LLnode node = new LLnode(i);
		if(head == null){
			head = node;
		}
		else{
			head.previous = node;
			node.next = head;
			head = node;
		}
	}

	private void deleteNode(int i) {
		if(head.data == i){
			head = head.next;
			return;
		}
		LLnode prev = head;
		LLnode current = head.next;
		while(current.data != i){
			current = current.next;
			prev = prev.next;
		}
		prev.next = current.next;
	}
	
}

public class LeastUsingCache {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter capacity of cache : ");
		int capacity = s.nextInt();
		DoubleLL cache = new DoubleLL(capacity);
		cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(2);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
        cache.accessPage(7);
        cache.printCacheState();
        cache.accessPage(8);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
	}
}
