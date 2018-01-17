package array;

public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	
	//12 18 7 34 30 28 90 88
	
	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		System.out.println("Length of longest increasing subsequence is : " + lis(arr));
	}

	private static int lis(int[] arr) {
		int i, j, max, count, maxCount = Integer.MIN_VALUE;
		for(i = 0; i < arr.length; i++){
			max = Integer.MIN_VALUE;
			count = 0; 
			for(j = i; j < arr.length; j++){
				if(arr[j] > max){
					max = arr[j];
					count++;
				}
			}
			if(count > maxCount)
				maxCount = count;
		}
		return maxCount;
	}

}
