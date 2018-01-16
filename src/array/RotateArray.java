package array;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int arr[] = CountFrequency.takeInput();
		System.out.println("Enter number of rotations : ");
		int n = s.nextInt();
		rotate(arr, n%arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void rotate(int[] arr, int n) {
		int start = 0, end = n-1;
		reverse(arr, start, end);
		start = n;
		end = arr.length - 1;
		reverse(arr, start, end);
		reverse(arr, 0, arr.length-1);
	}

	private static void reverse(int[] arr, int start, int end) {
		int temp;
		while(start < end){
			temp = arr[start];
			 arr[start] = arr[end];
			 arr[end] = temp;
			 start++; 
			 end--;
		}
	}

}
