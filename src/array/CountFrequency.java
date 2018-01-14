package array;

import java.util.Arrays;
import java.util.Scanner;

//Time complexity : O(nlogn)
//Space complexity : O(1)

public class CountFrequency {

	public static int[] takeInput(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter size of the array : ");
		int n = s.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter elements of the array : ");
		for(int i = 0; i < n; i++)
			arr[i] = s.nextInt();
		return arr;
	}
	
	public static void main(String[] args) {
		int arr[] = takeInput();
		Arrays.sort(arr);
		int current = 1, pos = 0, count;
		while(current <= arr.length){
			for( ;current < arr[pos] ; current++)
				System.out.println(current + " 0" );
			count = 0;
			while(pos < arr.length && current == arr[pos]){
				count++;
				pos++;
			}
			System.out.println(current + " " + count);
			current++;
		}
	}

}
