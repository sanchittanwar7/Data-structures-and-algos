package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class largest_contiguous_sum_zero {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1 ,2 , -2, -3, 3));
		arr = largestZero(arr);
		System.out.println(arr);

	}

	private static ArrayList<Integer> largestZero(ArrayList<Integer> arr) {
		int start = -1, end = -1, i, maxLen = Integer.MIN_VALUE;
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayList<Integer> sum = new ArrayList<>();
		sum.add(arr.get(0));
		for(i = 1; i < arr.size(); i++) {
			sum.add(sum.get(i-1) + arr.get(i));
		}
//		System.out.println(sum);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(i = 0; i < sum.size(); i++) {
			if(sum.get(i) == 0)
				end = i;
			map.put(sum.get(i), i);
		}
		maxLen = end - start;
//		System.out.println(start + " " + end);
		for(i = 0; i < sum.size(); i++) {
			if(map.containsKey(sum.get(i))) {
				if(map.get(sum.get(i)) - i > maxLen) {
					start = i;
					end = map.get(sum.get(i));
					maxLen = end - start;
				}
			}
		}
//		System.out.println(start + " " + end);

		for(i = start+1; i <= end; i++)
			ans.add(arr.get(i));
		return ans;
	}

}
