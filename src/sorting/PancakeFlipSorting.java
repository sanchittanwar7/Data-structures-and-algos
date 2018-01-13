package sorting;
import java.util.Arrays;

import sorting.BubbleSort;

public class PancakeFlipSorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = BubbleSort.takeInput();
		pSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void pSort(int[] arr, int length) {
		int start, end, max, maxPos;
		for(end = length-1; end > 0; end--){
			max = Integer.MIN_VALUE;
			maxPos = 0;
			for(start = 0; start <= end; start++){
				if(arr[start] > max){
					max = arr[start];
					maxPos = start;
				}
			}
			flip(arr, maxPos);
			flip(arr, end);
		}
	}

	private static void flip(int[] arr, int pos) {
		int temp, i = 0;
		while(i < pos){
			temp = arr[i];
			arr[i] = arr[pos];
			arr[pos] = temp;
			i++;
			pos--;
		}
	}

}
