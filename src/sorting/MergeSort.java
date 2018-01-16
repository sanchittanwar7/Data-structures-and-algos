package sorting;

import java.util.Arrays;

import sorting.BubbleSort;

public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = BubbleSort.takeInput();
		System.out.println(Arrays.toString(mSort(arr, arr.length)));

	}

	private static int[] mSort(int[] arr, int length) {
		if(length == 1){
			return arr;
		}
		int mid = (length)/2;
		int first[] = Arrays.copyOfRange(arr, 0, mid);
		int second[] = Arrays.copyOfRange(arr, mid, length);
		first = mSort(first, first.length);
		second = mSort(second, second.length);
		return merge(first, second);
	}

	public static int[] merge(int[] first, int[] second) {
		int i = 0, j = 0, k = 0;
		int ans[] = new int[first.length + second.length];
		while(i < first.length && j < second.length){
			if(first[i] < second[j]){
				ans[k] = first[i];
				k++;
				i++;
			}
			else{
				ans[k] = second[j];
				j++;
				k++;
			}
		}
		while(i < first.length){
			ans[k] = first[i];
			i++;
			k++;
		}
		while(j < second.length){
			ans[k] = second[j];
			k++;
			j++;
		}
		return ans;
	}

}
