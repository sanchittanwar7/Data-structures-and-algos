package linkedList;

import java.util.HashMap;

public class IntersectionOfLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter first linked lsit : ");
		node head1 = node.takeInput();
		System.out.println("Enter second linked list : ");
		node head2 = node.takeInput();
		node ans = findIntersection(head1, head2);
		if(ans != null)
			System.out.println(ans.data);
		else
			System.out.println("no intersection");
	}

	private static node findIntersection(node head1, node head2) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		while(head1 != null){
			map.put(head1.data, true);
			head1 = head1.next;
		}
		while(head2 != null){
			if(map.containsKey(head2.data))
				return head2;
			head2 = head2.next;
		}
		return null;
	}

}
