package array;

import java.util.ArrayList;
import java.util.Arrays;

public class min_steps_in_infinite_grid {

	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(0, 1, 1));
		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
		System.out.println(coverPoints(a1,a2));
	}

	private static int coverPoints(ArrayList<Integer> a1, ArrayList<Integer> a2) {
		int currentPoint = 0, nextPoint = 1;
		int currentCol = a2.get(0), currentRow = a1.get(0), destRow, destCol;
		int colDiff, rowDiff;
		int steps = 0;
		while(nextPoint < a1.size()) {
			currentCol = a2.get(currentPoint); currentRow = a1.get(currentPoint);
			destCol = a2.get(nextPoint); destRow = a1.get(nextPoint);
//			System.out.println("From : " + currentRow + ", " + currentCol);
//			System.out.println("To : " + destRow + ", " + destCol);
			colDiff = Math.abs(destCol - currentCol);
			rowDiff = Math.abs(destRow - currentRow);
			steps += Math.min(rowDiff, colDiff);
			if(colDiff < rowDiff) {
				if(destRow > currentRow)
					currentRow += colDiff;
				else
					currentRow -= colDiff;
				steps += Math.abs(currentRow - destRow);
			}
			else {
				if(destCol > currentCol)
					currentCol += rowDiff;
				else
					currentCol -= rowDiff;
				steps += Math.abs(currentCol - destCol);
			}
			currentPoint++;
			nextPoint++;
//			System.out.println(steps);
		}
		return steps;
	}

}
