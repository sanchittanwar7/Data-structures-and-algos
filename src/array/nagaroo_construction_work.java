package array;

import java.util.Arrays;

public class nagaroo_construction_work {

	public static void main(String[] args) {
		int arr[] = {1,2,3};
		arr = construction(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] construction(int[] arr, int n) {
		int mat[][] = new int[n][n];
		int i, index = 0, k = 0, max;
		int ans[] = new int[n];
		for(k = 0; k < n; k++) {
			max = Integer.MIN_VALUE;
			for(i = 0; i < n; i++) {
				if(i+k >= n)
					continue;
				if(k == 0)
					mat[i][i] = arr[i];
				else
					mat[i][i + k] = Math.min(mat[i][i + k -1], arr[i+k]);
				if(max < mat[i][i+k])
					max = mat[i][i+k];
			}
			ans[index] = max;
			index++;
		}
		return ans;
	}

}
