package array;

import java.util.Arrays;

public class MinSubArraySumToK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] =  {2,3,1,2,4,3};
		int k = 7;
		System.out.println(Arrays.toString(minSubArray(arr, k)));
	}

	private static int[] minSubArray(int[] arr, int k) {
		int start, end, currSum, min = Integer.MIN_VALUE, startAns = 0, endAns = 0;
		for(start = 0; start < arr.length; start++){
			currSum = 0;
			end = start;
			while(currSum < k && end < arr.length && start - end + 1 > min){
				currSum += arr[end];
				end++;
			}
			if(currSum == k){
				startAns = start;
				endAns = end;
			}
		}
		return Arrays.copyOfRange(arr, startAns, endAns);
	}

}
