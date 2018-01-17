package array;

import java.util.Arrays;
import java.util.Scanner;

public class MinCostMatrix {

	/**
	 * @param args
	 */
	
	// 4 3 3 2 8 1 9 7 0 5 2 6 4 3
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter rows and columns: ");
		int r = s.nextInt();
		int c = s.nextInt();
		System.out.println("Enter matrix : ");
		int arr[][] = new int[r][c];
		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++)
				arr[i][j] = s.nextInt();
		}
		System.out.println(Arrays.deepToString(arr));
		System.out.println(minCost(arr, r, c));
	}

	private static int minCost(int[][] arr, int r, int c) {
		int cost[][] = new int[r][c], i;
		cost[0][0] = arr[0][0];
		for(i = 1; i < r; i++)
			cost[i][0] = arr[i][0] + cost[i-1][0];
		for(i = 1; i < c; i++)
			cost[0][i] = arr[0][i] + cost[0][i-1]; 
		for(i = 1; i < r; i++){
			for(int j = 1; j < c; j++){
				cost[i][j] = Math.min(cost[i-1][j-1], Math.min(cost[i-1][j], cost[i][j-1])) + arr[i][j];
			}
		}
		System.out.println(Arrays.deepToString(cost));
		return cost[r-1][c-1];
	}

}
