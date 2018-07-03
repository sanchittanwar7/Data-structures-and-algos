package binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class matrix_search {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		arr.add(new ArrayList<Integer>(Arrays.asList(1,3,5, 7)));
		arr.add(new ArrayList<Integer>(Arrays.asList(10, 11, 16, 20)));
		arr.add(new ArrayList<Integer>(Arrays.asList(23, 30, 34, 50)));
		int n = 17;
		System.out.println(searchMatrix(arr, n));
	}

	private static int searchMatrix(ArrayList<ArrayList<Integer>> arr, int n) {
		ArrayList<Integer> search = new ArrayList<Integer>();
		for(ArrayList<Integer> row : arr) {
			if(n >= row.get(0) && n <= row.get(row.size() - 1)) {
				search = row;
				break;
			}
		}
		if(search.size() == 0)
			return 0;
		int start = 0, end = search.size()-1;
		int mid = ( start + end )/2;
		while(start <= end) {
			if(search.get(mid) == n)
				return 1;
			if(search.get(mid) < n)
				start = mid + 1;
			else
				end = mid - 1;
			mid = (start + end)/2;
		}
		return 0;
	}

}
