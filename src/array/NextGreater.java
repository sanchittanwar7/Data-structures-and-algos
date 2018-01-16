package array;

import java.util.Arrays;

public class NextGreater {

	/**
	 * @param args
	 */
	
	//6 9 3 8 6 5 2
	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		nextGreater(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void nextGreater(int[] arr) {
		int i = arr.length - 1;
		while(i > 0 && arr[i] < arr[i-1])
			i--;
		if(i == 0)
			return;
		i--;
		int j = i, max = Integer.MAX_VALUE, maxPos = 0;
		while(j < arr.length){
			if(arr[j] > arr[i] && arr[j] < max){
				max = arr[j];
				maxPos = j;
			}
			j++;
		}
		swap(arr, i, maxPos);
		Arrays.sort(arr, i+1, arr.length);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
