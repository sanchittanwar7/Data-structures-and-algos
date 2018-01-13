package sorting;
import java.util.Arrays;

import sorting.BubbleSort;

public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = BubbleSort.takeInput();
		hSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void hSort(int[] arr, int length) {
		int start = 0, end = length - 1, temp;
		maxHeapify(arr, start, end);
		for(int i = end; i > 0;){
			temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			i--;
			maxHeapify(arr,0,i);
		}
	}

	private static void maxHeapify(int[] arr, int start, int end) {
		int temp, left, right, max, maxPos, parent;
		int mid = (start + end + 1)/2;
		for(parent = mid; parent >= 0; parent--){
			left = 2*parent+1;
			right = 2*parent+2;
			left = left > end ? -1 : left;
			right = right > end ? -1 : right;
			maxPos = parent;
			max = arr[maxPos];
			if(left != -1 && arr[left] > max){
				max = arr[left];
				maxPos = left;
			}
			if(right != -1 && arr[right] > max){
				max = arr[right];
				maxPos = right;
			}
			temp = arr[parent];
			arr[parent] = arr[maxPos];
			arr[maxPos] = temp;
		}
	}

}
