package array;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int arr[] = CountFrequency.takeInput();
		System.out.println("Enter element to be searched : ");
		int ele = s.nextInt();
		System.out.println(bSearch(arr, ele));
	}		


	private static int bSearch(int[] arr, int ele) {
		int start, mid, end;
		start = 0;
		end = arr.length-1;
		mid = arr.length/2;
		while(start < end){
			if(arr[mid] == ele)
				return mid + 1;
			if(arr[mid] > ele)
				end = mid - 1;
			else
				start = mid + 1;
			mid = (start + end)/2;
		}
		return -1;
	}

}
