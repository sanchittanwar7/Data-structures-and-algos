package dp;

import java.util.Arrays;
import java.util.Scanner;

//5 1 29 40 24 12 13 31 40 31 33 29 40 17 35 32 15 39 28 3 31 15 21 31 38 24
//4 1 8 21 7 19 17 10 20 2 8 23 22 14 25 4 13

public class maze {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[][] = new int[n][n], i, j;
		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++)
				arr[i][j] = s.nextInt();
		System.out.println(solution(arr, n));
	}

	private static int solution(int[][] arr, int n) {
		int ans[][] = new int[n][n];
		ans[0][0] = arr[0][0];
		int i, j;
		for(i = 1; i < n; i++) {
			if(ans[i-1][0] > arr[i][0])
				ans[i][0] = ans[i-1][0];
			else
				ans[i][0] = arr[i][0];
		}
		for(i = 1; i < n; i++) {
			if(ans[0][i-1] > arr[0][i])
				ans[0][i] = ans[0][i-1];
			else
				ans[0][i] = arr[0][i];
		}
		for(i = 1; i < n; i++) {
			for(j = 1; j < n; j++) {
				if(Math.min(ans[i-1][j], ans[i][j-1]) > arr[i][j])
					ans[i][j] = Math.min(ans[i-1][j], ans[i][j-1]);
				else
					ans[i][j] = arr[i][j];
			}
		}
		for(int[] a : arr)
			System.out.println(Arrays.toString(a));
		for(int[] a : ans)
			System.out.println(Arrays.toString(a));
		return ans[n-1][n-1];
		
	}

}
