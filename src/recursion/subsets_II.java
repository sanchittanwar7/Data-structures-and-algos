package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class subsets_II {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,2));
		ArrayList<ArrayList<Integer>> ans = subsets(arr);
		for(ArrayList<Integer> subset : ans)
			System.out.println(subset);
	}

	private static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> arr) {
		Collections.sort(arr);
		return helper(arr);
	}

	private static ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> arr) {
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
		ArrayList<ArrayList<Integer>> newAns = new ArrayList<ArrayList<Integer>>();
		int i;
		ArrayList<Integer> modified;
		for(i = 0; i < ans.size(); i++) {
			modified = new ArrayList<>(ans.get(i));
			modified.add(0, arr.get(0));
			newAns.add(modified);
		}
		for(i = 0; i < ans.size(); i++)
			if(ans.get(i).size() > 0 && !newAns.contains(ans.get(i)))
				newAns.add(ans.get(i));

		newAns.add(0, new ArrayList<Integer>());
		return newAns;
	}

}
