package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class combination_sum_II {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8));
		int n = 16;
		ArrayList<ArrayList<Integer>> ans = combinationSum(arr, n);
		for(ArrayList<Integer> row : ans)
			System.out.println(row);
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int n) {
        Collections.sort(arr);
        return helper(arr, n);
    }
    
    private static ArrayList<ArrayList<Integer>> helper(List<Integer> list, int n) {
        if(list.size() == 1 || n <= 0) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            if(list.get(0) == n)
                ans.add(new ArrayList<Integer>(Arrays.asList(n)));
            if(n == 0)
                ans.add(new ArrayList<Integer>());
            return ans;
        }
        ArrayList<ArrayList<Integer>> temp2 = helper(list.subList(1, list.size()), n - list.get(0));
        ArrayList<ArrayList<Integer>> temp3 = helper(list.subList(1, list.size()), n);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp;
        int i;
        for(i = 0; i < temp2.size(); i++) {
            temp = temp2.get(i);
            temp.add(0, list.get(0));
            ans.add(temp);
        }
        for(i = 0; i < temp3.size(); i++) {
            temp = temp3.get(i);
            if(!ans.contains(temp))
            ans.add(temp);
        }
        return ans;
    }

}
