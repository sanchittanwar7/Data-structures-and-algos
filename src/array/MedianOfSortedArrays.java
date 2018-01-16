package array;
import java.util.Arrays;

import sorting.MergeSort;

public class MedianOfSortedArrays {

	/**
	 * @param args
	 */
	
	//1, 3, 5, 11, 17  b = 9, 10, 11, 13, 14
	
	public static void main(String[] args) {
		int arr1[] = CountFrequency.takeInput();
		int arr2[] = CountFrequency.takeInput();
		int arr3[] = MergeSort.merge(arr1, arr2);
//		System.out.println(Arrays.toString(arr3));
		System.out.println(getMedian(arr3));
	}

	private static double getMedian(int[] arr3) {
//		System.out.println(arr3[arr3.length/2] + " " + arr3[(arr3.length/2) - 1]);
		return arr3.length % 2 == 1 ? arr3[arr3.length / 2] : (arr3[arr3.length/2] + arr3[(arr3.length/2) - 1])/2.0;
	}

}
