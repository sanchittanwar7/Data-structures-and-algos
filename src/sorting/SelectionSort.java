package sorting;

import java.util.Arrays;

import sorting.BubbleSort; 

public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = BubbleSort.takeInput();
		sSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void sSort(int[] arr, int n) {
		int i, j, min = Integer.MAX_VALUE, temp, minPos = 0;
		for(i = 0; i < n; i++){
			min = Integer.MAX_VALUE;
			for(j = i; j < n; j++){
				if(arr[j] < min){
					minPos = j;
					min = arr[j];
				}
			}
			temp = arr[i];
			arr[i] = arr[minPos];
			arr[minPos] = temp;
		}
	}

}
