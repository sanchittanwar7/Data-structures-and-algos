package dp;

import java.util.Arrays;

public class MinimumNumberOfCoins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int denomitations[] = {2, 3, 5};
		System.out.println(minCoins(denomitations, 10));
	}

	private static int minCoins(int[] denomitations, int n) {
		int ans[] = new int[n+1], i, index, val;
		for(i = 0; i <= n; i++)
			ans[i] = Integer.MAX_VALUE;
		for(int coins : denomitations)
			ans[coins] = 1;
		for(i = 0; i <= n; i++){
			if(ans[i] != 1){
				int min = Integer.MAX_VALUE - 1;
				for(int j : denomitations){
					index = i - j;
					val = index < 0 ? Integer.MAX_VALUE : ans[index];
					if(val < min)
						min = val;
				}
				ans[i] = 1 + min;
			}
		}
		System.out.println(Arrays.toString(ans));
		return ans[n];
	}

}
