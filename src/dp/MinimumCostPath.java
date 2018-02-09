package dp;

import java.util.ArrayList;

public class MinimumCostPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        int[][] arr = { { 3, 2, 8 }, { 1, 9, 7 }, { 0, 5, 2 }, {6, 4, 3} };
        ArrayList<Integer> ans = minCost(arr);
        for(int i : ans)
        	System.out.print(i + "<-");
	}

	private static ArrayList<Integer> minCost(int[][] arr) {
		int r = arr.length, c = arr[0].length, i, j, current, top, left, diagonal, yeh;
		int cost[][] = new int[r][c];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		cost[0][0] = arr[0][0];
		for(i = 1; i < r; i++)
			cost[i][0] = arr[i][0] + cost[i-1][0];
		for(i = 1; i < c; i++)
			cost[0][i] = arr[0][i] + cost[i-1][0];
		for(i = 1; i < r; i++){
			for(j = 1; j < c; j++)
				cost[i][j] = arr[i][j] + Math.min(cost[i-1][j-1], Math.min(cost[i-1][j], cost[i][j-1]));
		}
		System.out.println(cost[r-1][c-1]);
		i = r-1;
		j = c-1;
		current = cost[i][j];
//		ans.add(arr[i][j]);
		while(i != 0 || j != 0){
			top = i-1 >= 0 ? cost[i-1][j] : Integer.MAX_VALUE;
			left = j-1 >= 0 ? cost[i][j-1] : Integer.MAX_VALUE;
			diagonal = i-1 >=0 && j-1 >= 0 ? cost[i-1][j-1] : Integer.MAX_VALUE;
			if(diagonal < top && diagonal < left){
				yeh = diagonal;
				i--;
				j--;
			}
			else if(top < left && top < diagonal){
				yeh = top;
				i--;
			}
			else{
				j--;
				yeh = left;
			}
			ans.add(current - yeh);
			current = yeh;
		}
		ans.add(arr[0][0]);
		return ans;
	}

}
