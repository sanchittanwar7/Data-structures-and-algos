package array;

import java.util.ArrayList;

public class kth_pascal_row {

	public static void main(String[] args) {
		int n = 21;
		ArrayList<Integer> ans = getRow(n);
		System.out.println(ans);
	}
	
	public static ArrayList<Integer> getRow(int n) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int i, combination;
		for(i = 0; i <= n; i++) {
			combination = getCombination(n,i);
			ans.add(combination);
		}
		return ans;
	}

	private static int getCombination(int n, int i) {
		int min = Math.min(i, n-i);
		int max = Math.max(i, n-i);
		long numerator = 1, j, denominator = 1;
		for(j = n; j > max; j--)
			numerator *= j;
		for(j = 1; j <= min; j++)
			denominator *= j;
		long ans = numerator/denominator;
		return (int)ans;
	}

}
