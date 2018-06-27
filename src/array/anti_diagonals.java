package array;

import java.util.ArrayList;
import java.util.Arrays;

public class anti_diagonals {

	public static void main(String[] args) {
		int i;
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		for(i = 0; i < 5; i++)
			input.add(i, new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)));
		input = diagonal(input);
		System.out.println(input);
	}
	
	public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> arr) {
		int startRow = 0, startCol = 0, l = arr.size(), i, row, col, turn = 0;
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for(i = 0; i < 2*l-1; i++)
			ans.add(i, new ArrayList<Integer>());
		while(startRow < l) {
			row = startRow; col = startCol;
			while(col >= 0 && row < l) {
				ans.get(turn).add(arr.get(row).get(col));
				col--;
				row++;
			}
			turn++;
			if(turn < l) {
				startRow = 0;
				startCol++;
			}
			else {
				startRow++;
				startCol = l-1;
			}
		}
		return ans;
    }

}
