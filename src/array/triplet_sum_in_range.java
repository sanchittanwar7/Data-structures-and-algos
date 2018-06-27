package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class triplet_sum_in_range {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>(Arrays.asList("2.673662", "2.419159", "0.573816", "2.454376", "0.403605", "2.503658", "0.806191"));
		System.out.println(solve(arr));
	}
	
	public static int solve(ArrayList<String> arr) {
		ArrayList<Double> arr1 = convert(arr);
		System.out.println(arr1);
		int l = arr1.size();
		Collections.sort(arr1);
		int start, end, i;
		for(i = 0 ; i < l; i++) {
			start = i + 1;
			end = l - 1;
			while(start < end) {
				if(arr1.get(start) + arr1.get(end) >= 1 - arr1.get(i) && arr1.get(start) + arr1.get(end) <= 2 - arr1.get(i))
					return 1;
				else if(arr1.get(start) + arr1.get(end) < 1 - arr1.get(i))
					start++;
				else
					end--;
			}
		}
		return -1;
		
    }

	private static ArrayList<Double> convert(ArrayList<String> arr) {
		ArrayList<Double> ans = new ArrayList<Double>();
		for(String str : arr) {
			ans.add(Double.parseDouble(str));
		}
		return ans;
	}
}
