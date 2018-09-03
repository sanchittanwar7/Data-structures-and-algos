package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class simple_queries {
	
	public static final long M = 1000000007;

	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1,2,4));
		ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		ArrayList<Integer> ans = solve(a1, a2);
		System.out.println(ans);
	}
	
	 
    static long multiplyFactors(int n){
        long prod = 1;
        for (int i = 1; i * i <= n; i++){
            if (n % i == 0){
                if (n / i == i)
                    prod = (prod * i) % M;
                else {
                    prod = (prod * i) % M;
                    prod = (prod * n / i) % M;
                }
            }
        }
        return prod;
    }

	public static ArrayList<Integer> solve(ArrayList<Integer> a, ArrayList<Integer> b) {
		int n = a.size();
		ArrayList<Integer> temp = new ArrayList<>();
		int i;
		int prev = -1, curr;
		for(i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				if(i != j)
					curr = Math.max(prev, a.get(j));
				else
					curr = a.get(i);
				temp.add((int) multiplyFactors(curr));
				prev = curr;
			}
		}
		temp.sort(Collections.reverseOrder());
		ArrayList<Integer> ans = new ArrayList<>();
		for(Integer ele : b) {
			ans.add(temp.get(ele-1));
		}
		return ans;
	}

}
