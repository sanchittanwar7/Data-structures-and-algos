package array;

import java.util.ArrayList;
import java.util.Collections;

public class spiral_order_matrix {

	public static void main(String[] args) {
		int n = 5;
		ArrayList<ArrayList<Integer>> ans = generateMatrix(n);
		System.out.println(ans);
		for(ArrayList<Integer> row : ans) {
			System.out.println(row);
		}
	}

	private static ArrayList<ArrayList<Integer>> generateMatrix(int n) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		int i, num = 1, temp;
		for(i = 0; i < n; i++)
			ans.add(new ArrayList<Integer>(Collections.nCopies(n, 0)));
		int rightCol = n, bottomRow = n-1, leftCol = n-1, upRow = n-2;
		int rightColStart = 0, bottomRowStart = n-1, upRowStart = 0;
		int rowNumberUpper = 0, rowNumberLower = n-1, colNumber = 1;
		int round = 0;
		while(num <= n*n) {
			for(i = rightColStart; i < rightCol; i++) {
				ans.get(rowNumberUpper).set(i, num);
				num++;
			}
			temp = colNumber;
			for(i = 0; i < bottomRow; i++) {
				ans.get(temp).set(bottomRowStart, num);
				num++;
				temp++;
			}
			temp--;
			for(i = 0; i < leftCol; i++) {
				ans.get(rowNumberLower).set(leftCol - i -1 + round, num);
				num++;
			}
			for(i = 0; i < upRow; i++) {
				temp--;
				ans.get(temp).set(upRowStart, num);
				num++;
			}
			rightColStart++;rightCol--;rowNumberUpper++;
			bottomRow-=2;colNumber++;bottomRowStart--;
			leftCol-=2;rowNumberLower--;
			upRow-=2;upRowStart++;
			round++;
		}
		return ans;
	}

}
