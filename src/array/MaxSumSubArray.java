package array;

public class MaxSumSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		System.out.println(maxSum(arr));
	}
	
	private static int maxSum(int[] arr) {
		int i = 0, sumTillNow = 0, maxSum = Integer.MIN_VALUE;
		while(i < arr.length){
			sumTillNow += arr[i];
			if(sumTillNow < 0)
				sumTillNow = 0;
			if(sumTillNow > maxSum)
				maxSum = sumTillNow;
			i++;
		}
		return maxSum;
	}
	

}
