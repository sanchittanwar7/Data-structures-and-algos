package array;

import java.util.Scanner;

public class ElementInSortedRotatedArray2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String ch = "y";
		do{
			int arr[] = CountFrequency.takeInput();
			Scanner s = new Scanner(System.in);
			System.out.println("Enter number to find : ");
			int num = s.nextInt();
			System.out.println(find(arr, num, 0, arr.length-1));
			System.out.println("Give another shot?");
			ch = s.next();
		}while(ch.equals("y"));
	}

	private static int find(int[] arr, int num, int start, int end) {
		int mid	= (start + end)/2;
		if(arr[mid] == num)
			return mid;
		else if(arr[mid+1] <= num && arr[mid+1] < arr[end])
			return ElementInSortedRotatedArray.bSearch(arr, mid+1, end, num);
		else if(arr[mid+1] >= num && arr[mid+1] > arr[start])
			return ElementInSortedRotatedArray.bSearch(arr, start, mid-1, num);
		else if(arr[mid] > arr[end])
			return find(arr, num, mid, end);
		else
			return find(arr, num, start, mid);
	}

}
