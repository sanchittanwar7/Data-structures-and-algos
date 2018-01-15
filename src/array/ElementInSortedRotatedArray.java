package array;

import java.util.Scanner;

public class ElementInSortedRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int arr[] = CountFrequency.takeInput();
		System.out.println("\nEnter number to find : ");
		int num = s.nextInt();
		find(arr, num);
	}

	private static void find(int[] arr, int num) {
		int start, end;
		int pivot = PivotInSortedArray.pivot(arr);
		if(num < arr[arr.length-1]){
			start = pivot;
			end = arr.length-1;
		}
		else{
			start = 0;
			end = pivot-1;
		}
		System.out.println(bSearch(arr, start, end, num));		
	}

	public static int bSearch(int[] arr, int start, int end, int num) {
		int mid = (start + end)/2;
		while(start <= end){
			if(arr[mid] == num)
				return mid;
			else if(arr[mid] < num)
				start = mid + 1;
			else
				end = mid - 1;
			mid = (start + end) / 2;
		}
		return -1;
	}

}
