package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class next_permutation {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList( 5 ,6 ,2 ,3 ,4 ,5 ,6, 2 ));
		nextPermutation(arr);
		System.out.println(arr);
		
	}

	private static void nextPermutation(ArrayList<Integer> arr) {
		int n = arr.size(), lastEle = arr.get(n - 1), nextSmallerIndex = -1, i, min, index2 = -1;
//		Collections.sort(arr.subList(0, 3));
//		System.out.println(arr);
		for(i = n - 2; i >=0 ; i--) {
			if(arr.get(i) < arr.get(i+1)) {
				nextSmallerIndex = i;
				break;
			}
		}
		if(nextSmallerIndex == -1)
			Collections.sort(arr);
		else {
//			System.out.println(nextSmallerIndex);
			min = Integer.MAX_VALUE;
			for(i = nextSmallerIndex+1; i < n; i++) {
				if(arr.get(i) < min && arr.get(i) > arr.get(nextSmallerIndex)) {
					min = arr.get(i);
					index2 = i;
				}
			}
//			System.out.println(index2);
			Collections.swap(arr, nextSmallerIndex, index2);
//			System.out.println(arr);
			Collections.sort(arr.subList(nextSmallerIndex + 1, n));
		}
	}

}
