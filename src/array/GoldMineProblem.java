package array;

import java.util.Arrays;

public class GoldMineProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] mine = { { 1, 3, 1, 5 }, 
                { 2, 2, 4, 1 }, 
                { 5, 0, 2, 3 },
                { 0, 6, 1, 2 } };
		System.out.println(maxGold(mine));
	}

	private static int maxGold(int[][] mine) {
		int r = mine.length;
		int c = mine[0].length;
		int x, y, z;
		int ans[][] = new int[r][c];
		for(int i = 0; i < r; i++)
			ans[i][0] = mine[i][0];
		for(int j = 1; j < c; j++){
			for(int i = 0; i < r; i++){
				x = i > 0 ? ans[i-1][j-1] : -1;
				y = i == r-1 ? -1 : ans[i+1][j-1];
				z = ans[i][j-1];
				ans[i][j] = mine[i][j] + Math.max(x, Math.max(y, z));
			}
		}
		System.out.println(Arrays.deepToString(ans));
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < r; i++)
			if(ans[i][c-1] > max)
				max = ans[i][c-1];
		return max;
	}

}
