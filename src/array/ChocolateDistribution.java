package array;

import java.util.Arrays;

public class ChocolateDistribution {

	/**
	 * @param args
	 */
	
	//{3, 4, 1, 9, 56, 7, 9, 12} 
	
	//{7, 3, 2, 4, 9, 12, 56}
	
	//{12, 4, 7, 9, 2, 23, 25, 41,30, 40, 28, 42, 30, 44, 48, 43, 50} 
	
	public static void main(String[] args) {
		int arr[] =  {12, 4, 7, 9, 2, 23, 25, 41,30, 40, 28, 42, 30, 44, 48, 43, 50}  ;
		System.out.println(Arrays.toString(minDifference(arr, 7)));
	}

	private static int[] minDifference(int[] arr, int num) {
		Arrays.sort(arr);
		int i = 0, start, end, ans1 = 0, ans2 = 0, minDiff;
		start = i;
		minDiff = Integer.MAX_VALUE;
		while(i < arr.length && i < start + num)
			i++;
		end = i-1;
		if(arr[end] - arr[start] < minDiff){
			minDiff = arr[end] - arr[start];
			ans1 = start;
			ans2 = end;
		}
		while(i < arr.length){
			start++;
			if(arr[i] - arr[start] < minDiff){
				minDiff = arr[i] - arr[start];
				ans1 = start;
				ans2 = i;
			}
			i++;
		}
		System.out.println(ans1+" "+ ans2);
		return Arrays.copyOfRange(arr, ans1, ans2+1);
	}

}
