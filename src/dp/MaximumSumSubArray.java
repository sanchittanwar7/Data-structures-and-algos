package dp;

import java.util.Arrays;

public class MaximumSumSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {2, -9, 5, 1, -4, 6, 0, -7, 8};
		System.out.println(Arrays.toString(maxSum(arr)));
	}

	private static int[] maxSum(int[] arr) {
		int n = arr.length, i, j, max = Integer.MIN_VALUE, start = 0, end = 0;
		int ans[][] = new int[n][n];
		for(i = 0; i < n; i++)
			ans[i][i] = arr[i];
		for(i = 0; i < n; i++){
			for(j = i+1; j < n; j++){
				ans[i][j] = ans[i][j-1] + arr[j];
				if(ans[i][j] > max){
					max = ans[i][j];
					start = i;
					end = j;
				}
			}
		}
		System.out.println(max);
		return Arrays.copyOfRange(arr, start, end + 1);
	}

}
