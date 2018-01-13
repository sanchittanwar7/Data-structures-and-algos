package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

	public static int[] takeInput(){
		int n,i;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter size of the array : ");
		n = s.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array : ");
		for(i = 0; i < n; i++)
			arr[i] = s.nextInt();
		return arr;
	}
	public static void main(String[] args) {
		int arr[] = takeInput();
		bsort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void bsort(int[] arr, int n) {
		int i,j,temp;
		for(i = 0; i < n; i++){
			for(j = 0; j < n-i-1; j++){
				if(arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

}
