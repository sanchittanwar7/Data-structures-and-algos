package binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class allocate_books {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(12,34,67,90));
		int n = 2;
		System.out.println(books(arr, n));
	}

	private static int books(ArrayList<Integer> arr, int n) {
		long totalLength = 0;
		for(Integer board : arr) {
			totalLength += board;
		}
		long idealWork = totalLength/n;
		long lengthSoFar = arr.get(0);
		int current = 0, next = 1;
		long maxWork = Long.MIN_VALUE;
		while(next < arr.size()) {
			if(Math.abs(lengthSoFar + arr.get(next) - idealWork) < Math.abs(lengthSoFar - idealWork)) {
				current = next;
				next++;
				lengthSoFar += arr.get(current);
			}
			else {
				if(lengthSoFar > maxWork)
					maxWork = lengthSoFar;
				current++;next++;
				lengthSoFar = arr.get(current);
			}
		}
		if(lengthSoFar > maxWork)
			maxWork = lengthSoFar;
		return (int) maxWork;
	}

}
