package array;

import java.util.Scanner;

public class MaxAvgSubArray {

	/**
	 * @param args
	 */
	
	//11 -8 16 -7 24 -2 3
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int arr[] = CountFrequency.takeInput();
		System.out.println("Enter size of the window : ");
		int n = s.nextInt();
		System.out.println(maxAvg(arr, n));
	}

	private static int maxAvg(int[] arr, int n) {
		int i = 0, avg = 0, maxAvg , pos;
		pos = 0;
		while(pos < n){
			avg += arr[i];
			pos++;
			i++;
		}
		pos = 0;
		maxAvg = avg;
		while(i < arr.length){
			avg = avg + arr[i] - arr[pos];
			pos++;
			i++;
			if(avg > maxAvg)
				maxAvg = avg;
		}
		return maxAvg/n;
	}

}
