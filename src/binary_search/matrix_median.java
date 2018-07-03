package binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class matrix_median {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		arr.add(new ArrayList<Integer>(Arrays.asList(1,3,5)));
		arr.add(new ArrayList<Integer>(Arrays.asList(2,6,9)));
		arr.add(new ArrayList<Integer>(Arrays.asList(3,6,9)));
		System.out.println(findMedian(arr));
	}

	private static int findMedian(ArrayList<ArrayList<Integer>> arr) {
		ArrayList<Integer> all = new ArrayList<Integer>();
		for(ArrayList<Integer> row : arr) {
			for(Integer ele : row)
				all.add(ele);
		}
		Collections.sort(all);
		return all.get(all.size()/2);
	}

}
