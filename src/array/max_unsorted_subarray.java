package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class max_unsorted_subarray {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,3,5,6));
		ArrayList<Integer> ans = subUnsort(arr);
		System.out.println(ans);
	}

	private static ArrayList<Integer> subUnsort(ArrayList<Integer> arr) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int i;
		for(i = 0; i < arr.size(); i++) {
			temp.add(arr.get(i));
		}
		Collections.sort(temp);
		int start = -1, end = -1;
		for(i = 0; i < arr.size(); i++) {
			if(temp.get(i) != arr.get(i)) {
				start = i;
				break;
			}
		}
		for(i = arr.size()-1; i >= 0; i--) {
			if(temp.get(i) != arr.get(i)) {
				end = i;
				break;
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(start);
		if(end != -1)
			ans.add(end);
		return ans;
	}

}
