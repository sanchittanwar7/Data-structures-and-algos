package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class subsets {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,2));
		Collections.sort(arr);
		ArrayList<ArrayList<Integer>> ans = subsets(arr);
		for(ArrayList<Integer> subset : ans)
			System.out.println(subset);
	}

	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> arr) {
		if(arr.size() <= 1) {
			ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
			ans.add(new ArrayList<Integer>());
			if(arr.size() == 0)
				return ans;
			ans.add(new ArrayList<>(Arrays.asList(arr.get(0))));
			return ans;
		}
		ArrayList<Integer> next = new ArrayList<Integer>(arr.subList(1, arr.size()));
		ArrayList<ArrayList<Integer>> ans = subsets(next);
		if(ans.get(1).get(0) == arr.get(0))
			return ans;
		ArrayList<ArrayList<Integer>> newAns = new ArrayList<ArrayList<Integer>>();
		int i;
		ArrayList<Integer> modified;
		for(i = 0; i < ans.size(); i++) {
			modified = new ArrayList<>(ans.get(i));
			modified.add(0, arr.get(0));
			newAns.add(modified);
		}
		for(i = 0; i < ans.size(); i++)
			if(ans.get(i).size() > 0)
				newAns.add(ans.get(i));

		System.out.println("after modify copying " + newAns);
		newAns.add(0, new ArrayList<Integer>());
		return newAns;
	}

}
