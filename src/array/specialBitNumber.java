package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class specialBitNumber {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int n = Integer.parseInt(num.split(" ")[0]);
		int q = Integer.parseInt(num.split(" ")[1]);
		int arr[] = new int[n], i;
		String a[] = br.readLine().split(" ");
		for(i = 0; i < n; i++)
			arr[i] = Integer.parseInt(a[i]);
		modifyArray(arr, n);
		int mat[][] = createMatrix(arr, n);
		for(i = 0; i < q; i++) {
			a = br.readLine().split(" ");
			System.out.println(mat[Integer.parseInt(a[0]) - 1][Integer.parseInt(a[1]) - 1]);
		}
	}

	private static int[][] createMatrix(int[] arr, int n) {
		int i;
		int mat[][] = new int[n][n];
		for(i = 0; i < n; i++)
			mat[i][i] = arr[i];
		for(i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++)
				mat[i][j] = mat[i][j-1] + arr[j];
		}
//		for(int[] row : mat)
//			System.out.println(Arrays.toString(row));
		return mat;
	}

	private static void modifyArray(int[] arr, int n) {
		int i, num;
		boolean isSecond;
		for(i = 0; i < n; i++) {
			num = arr[i];
			arr[i] = 0;
			isSecond = false;
			while(num != 0) {
				if(num % 2 == 1) {
					if(isSecond) {
						arr[i] = 1;
						break;
					}
					else {
						isSecond = true;
					}
				}
				else
					isSecond = false;
				num /= 2;
			}
		}
//		System.out.println(Arrays.toString(arr));
	}

}
