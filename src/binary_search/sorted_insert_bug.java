package binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class sorted_insert_bug {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,3,5,6));
		int n1 = 5, n2 = 2, n3 = 7, n4 = 0, n5 = 4;
		System.out.println(searchInsert(arr, n1));
		System.out.println(searchInsert(arr, n2));
		System.out.println(searchInsert(arr, n3));
		System.out.println(searchInsert(arr, n4));
		System.out.println(searchInsert(arr, n5));
	}

	private static int searchInsert(ArrayList<Integer> arr, int n) {
		int start = 0, end = arr.size()-1, mid = (start + end)/2;
		while(start <= end) {
			if(arr.get(mid) == n)
				return mid;
			else if(arr.get(mid) < n)
				start = mid + 1;
			else
				end = mid - 1;
			mid = (start + end)/2;
		}
		return end + 1;
	}

}
