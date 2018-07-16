package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class permutations {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<ArrayList<Integer>> ans = permute(arr);
		for(ArrayList<Integer> row : ans)
			System.out.println(row);
	}
	
	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> arr) {
		if(arr.size() <= 1) {
			ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
			if(arr.size() == 0)
				return ans;
			ans.add(new ArrayList<>(Arrays.asList(arr.get(0))));
			System.out.println("returning " + ans);
			return ans;
		}
		ArrayList<ArrayList<Integer>> ans = permute(new ArrayList<Integer>(arr.subList(1, arr.size())));
		ArrayList<Integer> modified;
		ArrayList<ArrayList<Integer>> finalAns = new ArrayList<>();
		for(ArrayList<Integer> a : ans) {
			System.out.println("modifying " + a);
			for(int i = 0; i < a.size(); i++) {
				modified = new ArrayList<>(a);
				modified.add(i, arr.get(0));
				finalAns.add(modified);
			}
			a.add(arr.get(0));
			finalAns.add(a);
		}
		return finalAns;
    }
}


