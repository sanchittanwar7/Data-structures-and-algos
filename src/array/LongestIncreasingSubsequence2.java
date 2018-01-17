package array;

import java.util.Arrays;

public class LongestIncreasingSubsequence2 {

	/**
	 * @param args
	 */
	
	//3 1 5 2 6 4 9
	
	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		System.out.println("Length of the largest increasing subsequence is : " + Arrays.toString(lis(arr)));
	}

	private static int[] lis(int[] arr) {
		int ans[] = new int[arr.length], pos = 0, correctPos, len = 1;
		ans[0] = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(ans[pos] < arr[i]){
				pos++;
				ans[pos] = arr[i];
				len++;
			}
			else{
				correctPos = correctPos(ans, arr[i], len);
				ans[correctPos] = arr[i];
			}
		}
		return ans;
	}

	private static int correctPos(int[] ans, int num, int len) {
		int start = 0, end = len-1, mid;
		while(start < end){
			mid = (start + end)/2;
			if(ans[mid] < num)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return start;
	}

}
