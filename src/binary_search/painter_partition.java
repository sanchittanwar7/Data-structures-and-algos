package binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class painter_partition {

	public static void main(String[] args) {
		int numberOfPainters = 2;
		int timePerUnit = 5;
		ArrayList<Integer> length = new ArrayList<Integer>(Arrays.asList(1,10));
		System.out.println(paint(numberOfPainters, timePerUnit, length));
	}

	private static int paint(int k, int timePerUnit, ArrayList<Integer> arr) {
		long lo = getMax(arr, arr.size());
		int hi = getSum(arr, arr.size());

		while (lo < hi) {
			int mid = (int) (lo + (hi-lo)/2);
			int requiredPainters = getRequiredPainters(arr, arr.size(), mid);
			if (requiredPainters <= k)
				hi = mid;
			else
				lo = mid+1;
		}
		System.out.println(lo);
		return (int) ((lo*timePerUnit)%10000003);
	}

	static int getMax(ArrayList<Integer> arr, int n) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr.get(i) > max) max = arr.get(i);
		}
		return max;
	}

	static int getSum(ArrayList<Integer> arr, int n) {
		int total = 0;
		for (int i = 0; i < n; i++)
			total += arr.get(i);
		return total;
	}

	static int getRequiredPainters(ArrayList<Integer> arr, int n, int maxLengthPerPainter) {
		int total = 0, numPainters = 1;
		for (int i = 0; i < n; i++) {
			total += arr.get(i);
			if (total > maxLengthPerPainter) {
				total = arr.get(i);
				numPainters++;
			}
		}
		return numPainters;
	}

}
