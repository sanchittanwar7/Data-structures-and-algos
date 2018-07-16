package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class combinations {

	public static void main(String[] args) {
		int n = 4, k = 0;
		ArrayList<ArrayList<Integer>> ans = combine(n, k);
		for(ArrayList<Integer> row : ans)
			System.out.println(row);
	}
	
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		if(k <= 1) {
			ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
			if(k == 0) {
				ans.add(new ArrayList<Integer>());
				return ans;
			}
			for(int i = 1; i <= n; i++)
				ans.add(new ArrayList<>(Arrays.asList(i)));
			return ans;
		}
		ArrayList<ArrayList<Integer>> ans = combine(n, k-1);
		ArrayList<ArrayList<Integer>> finalAns = new ArrayList<>();
		ArrayList<Integer> modified;
		for(int i = 1; i <= n; i++) {
			for(ArrayList<Integer> combination : ans) {
				if(i < combination.get(0)) {
					modified = new ArrayList<>(combination);
					modified.add(0, i);
					finalAns.add(modified);
				}
			}
		}
		return finalAns;
    }

}
