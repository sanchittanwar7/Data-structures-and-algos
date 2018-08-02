package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class KthPermutationSequence {

	static String s = "";
	
	public static void main(String[] args) {
		int n = 3, k = 4;
		String ans = getPermutation(n, k);
		System.out.println(ans);
	}
	
	public static String getPermutation(int n, int k) {
		ArrayList<Integer> arr = new ArrayList<>();
		int i = 1;
		for(; i <= n; i++)
			arr.add(i);
		while(k != 1) {
			nextPermutation(arr);
			k--;
		}
		return arr.stream().map(Object::toString).collect(Collectors.joining(""));
	}
	
	private static void nextPermutation(ArrayList<Integer> arr) {
		int n = arr.size(), nextSmallerIndex = -1, i, min, index2 = -1;
		for(i = n - 2; i >=0 ; i--) {
			if(arr.get(i) < arr.get(i+1)) {
				nextSmallerIndex = i;
				break;
			}
		}
		if(nextSmallerIndex == -1)
			Collections.sort(arr);
		else {
			min = Integer.MAX_VALUE;
			for(i = nextSmallerIndex+1; i < n; i++) {
				if(arr.get(i) < min && arr.get(i) > arr.get(nextSmallerIndex)) {
					min = arr.get(i);
					index2 = i;
				}
			}
			Collections.swap(arr, nextSmallerIndex, index2);
			Collections.sort(arr.subList(nextSmallerIndex + 1, n));
		}
	}
}
