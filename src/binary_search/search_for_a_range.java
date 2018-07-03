package binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class search_for_a_range {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1));
		int n = 1;
		arr = searchRange(arr ,n);
		System.out.println(arr);
	}

	private static ArrayList<Integer> searchRange(ArrayList<Integer> arr, int n) {
		int start = 0, end = arr.size() - 1, mid = (start + end)/2;
		if(n < arr.get(start) || n > arr.get(end))
			return new ArrayList<Integer>(Arrays.asList(-1,-1));
		boolean found = false;
		while(start <= end) {
			if(arr.get(mid) == n) {
				found = true;
				break;
			}
			else if(arr.get(mid) > n)
				end = mid-1;
			else
				start = mid + 1;
			mid = (start + end)/2;
		}
		if(!found) {
			return new ArrayList<Integer>(Arrays.asList(-1,-1));
		}
		int i = mid;
		System.out.println(mid);
		while(i >= 0 && arr.get(i) == arr.get(mid))
			i--;
		start = i;
		i = mid;
		while(i < arr.size() && arr.get(i) == arr.get(mid))
			i++;
		end = i;
		return new ArrayList<Integer>(Arrays.asList(start+1, end-1));
	}

}
