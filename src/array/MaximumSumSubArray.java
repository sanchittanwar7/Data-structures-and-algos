package array;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumSubArray {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(0, 1, 1));
		System.out.println(maxSubArray(arr));
	}

	private static int maxSubArray(ArrayList<Integer> arr) {
		int i = 0, maxSum = Integer.MIN_VALUE, sumTillNow = 0;
		while(i < arr.size()){
			sumTillNow += arr.get(i);
			if(sumTillNow < 0)
				sumTillNow = 0;
			if(sumTillNow > maxSum)
				maxSum = sumTillNow;
			i++;
		}
		return maxSum;
	}

}
