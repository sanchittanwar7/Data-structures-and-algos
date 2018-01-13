package linkedList;

public class IntersectionOfLLImproved {

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
		int len1 = length(head1);
		int len2 = length(head2);
		node temp1 = len1 > len2 ? head1 : head2;
		node temp2 = len1 < len2 ? head1 : head2;
		for(int i = 0; i < Math.abs(len1-len2); i++)
			temp1 = temp1.next;
		while(temp1 != null){
			if(temp1.data == temp2.data)
				return temp1;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return null;
	}

	private static int length(node head1) {
		int len = 0;
		while(head1 != null){
			len++;
			head1 = head1.next;
		}
		return len;
	}

}
