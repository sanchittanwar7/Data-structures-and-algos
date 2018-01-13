package linkedList;

public class MergeSortedLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter first sorted list : ");
		node head1 = node.takeInput();
		System.out.println("Enter second sorted list : ");
		node head2 = node.takeInput();
		node head = merge(head1, head2);
		node.print(head);
	}

	private static node merge(node head1, node head2) {
		node head = null, tail = null;
		while(head1 != null && head2 != null){
			if(head1.data < head2.data){
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
