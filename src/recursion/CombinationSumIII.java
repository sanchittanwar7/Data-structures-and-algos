package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII {

	public static void main(String[] args) {
		int n = 9, k = 3;
		List<List<Integer>> ans = combinationSum3(k, n);
		for(List<Integer> list : ans)
			System.out.println(list);
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		return helper(k, n, 1);
	}

	private static List<List<Integer>> helper(int k, int n, int start) {
		if(k == 1 || n < start) {
			List<List<Integer>> ans = new ArrayList<>();
			if(n >= start && n < 10)
				ans.add(new ArrayList<>(Arrays.asList(n)));
			return ans;
		}
		List<List<Integer>> ans = new ArrayList<>(), temp;
		for(int i = start; i < 10; i++) {
			temp = helper(k-1, n-i, i+1);
			for(int j = 0; j < temp.size(); j++) {
				temp.get(j).add(0, i);
				ans.add(temp.get(j));
			}
		}
		return ans;
	}	

}
