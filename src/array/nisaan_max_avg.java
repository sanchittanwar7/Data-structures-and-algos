package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class nisaan_max_avg {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		double arr[] = new double[n];
		for(int i = 0;i<n;i++)
			arr[i]= scan.nextDouble();
		Arrays.sort(arr);
		double sum = 0;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
			arr[i]= sum/(i+1);
		}
		System.out.println(Arrays.toString(arr));
		int q = scan.nextInt();
		for(int x=0;x<q;x++){
			double k = scan.nextDouble();
			int flag = binarySearchCount(arr, arr.length-1, k);
			System.out.println(flag);
		}
		scan.close();
	}

	static int binarySearchCount(double arr[], int n, double key){
		if (key > arr[arr.length-1]) {
			return arr.length;
		}
		if(key <= arr[0])
			return 0;
		int low =0;
		double gap = Integer.MAX_VALUE;
		int index = -1;
		int high = arr.length-1;
		while(low <= high){
			int mid = (low + high)/2;
			if(arr[mid] == key) {
				index = mid-1;
				break;
			}

			if(arr[mid] < key && gap > (key-arr[mid])){
				gap =  key-arr[mid];
				index = mid;
			}
			if(arr[mid] > key)
				high = mid-1;

			if(arr[mid] < key)
				low = mid+1;
		}
		return index + 1;
	}
}


