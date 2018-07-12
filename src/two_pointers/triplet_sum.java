package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class triplet_sum {

	public static void main(String[] args) {
		int target = -1;
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3));
//		System.out.println(threeSumClosest(arr, target));
		ArrayList<ArrayList<Integer>> ans = threeSumZero(arr);
		for(ArrayList<Integer> triplet : ans)
			System.out.println(triplet);
	}
	
	public static int threeSumClosest(ArrayList<Integer> arr, int target) {
		int ans = 0, diff, i, j, k, first, minDiff;
		Collections.sort(arr);
		minDiff = Integer.MAX_VALUE;
		for(i = 0; i < arr.size(); i++) {
			j = i+1;
			k = arr.size()-1;
			first = arr.get(i);
			while(j < k) {
				diff = target - first - arr.get(j) - arr.get(k);
				if(diff == 0)
					return target;
				if(Math.abs(diff) < minDiff) {
					ans = target - diff;
					minDiff = Math.abs(diff);
				}
				if(diff > 0)
					j++;
				else
					k--;
			}
		}
		return ans;
    }
	
	public static ArrayList<ArrayList<Integer>> threeSumZero(ArrayList<Integer> arr) {
		int sum, i, j, k, first;
		Collections.sort(arr);
		System.out.println(arr);
        TreeSet<String> set = new TreeSet<String>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for(i = 0; i < arr.size(); i++) {
			j = i+1;
			k = arr.size()-1;
			first = arr.get(i);
			while(j < k) {
				sum = first + arr.get(j) + arr.get(k);
				if(sum == 0) {
					String str = first + ":" + arr.get(j) + ":" + arr.get(k);
                    if (!set.contains(str)) {
                        ans.add(new ArrayList<>(Arrays.asList(first, arr.get(j), arr.get(k))));
                        set.add(str);
                    }
                    j++;
                    k--;
				}
				else if(sum < 0)
					j++;
				else
					k--;
			}
		}
		return ans;
    }

}
