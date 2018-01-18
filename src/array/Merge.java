package array;

import java.util.Arrays;

public class Merge {

	final static int INVALID_NUM = 0;
	public static void main(String[] args) {
		int arr1[] = {-3, 5, INVALID_NUM, 7, INVALID_NUM, 10, INVALID_NUM, 11, INVALID_NUM};
		int arr2[] = {-1, 2, 6, 12};
		merge(arr1, arr2);
		System.out.println("Merged array is : " + Arrays.toString(arr1));
	}
	private static void merge(int[] arr1, int[] arr2) {
		int start , end;
		int i = arr1.length - 1;
		while(arr1[i] != INVALID_NUM)
			i--;
		start = i;
		end = i;
		while(start > 0){
			while(arr1[start] == INVALID_NUM)
				start--;
			swap(arr1, start, end);
			end--;
		}
//		System.out.println(end);
//		return null;
		int firstIndex = end + 1;
		int secondIndex = 0;
		int finalIndex = 0;
		while(firstIndex < arr1.length && secondIndex < arr2.length){
			if(arr1[firstIndex] < arr2[secondIndex]){
				arr1[finalIndex] = arr1[firstIndex];
				firstIndex++;
				finalIndex++;
			}
			else{
				arr1[finalIndex] = arr2[secondIndex];
				secondIndex++;
				finalIndex++;
			}
		}
		while(firstIndex < arr1.length){
			arr1[finalIndex] = arr1[firstIndex];
			firstIndex++;
			finalIndex++;
		}
		while(secondIndex < arr2.length){
			arr1[finalIndex] = arr2[secondIndex];
			secondIndex++;
			finalIndex++;
		}
	}
	private static void swap(int[] arr, int start, int end) {
		int temp;
		temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}

}
