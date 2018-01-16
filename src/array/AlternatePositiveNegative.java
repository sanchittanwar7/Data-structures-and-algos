package array;

import java.util.Arrays;

public class AlternatePositiveNegative {

	/**
	 * @param args
	 */
	
	//-1 3 2 4 5 -6 7 -9
	
	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		rearrange(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void rearrange(int[] arr) {
		int pos;
		for(int i = 0; i < arr.length; i++){
			if(i%2 == 0 && arr[i] < 0){
				pos = i;
				while(pos < arr.length && arr[pos] < 0)
					pos++;
				if(pos >= arr.length)
					return;
				rightShift(arr, i, pos);
			}
			if(i%2 == 1 && arr[i] > 0){
				pos = i;
				while(pos < arr.length && arr[pos] > 0)
					pos++;
				if(pos >= arr.length)
					return;
				rightShift(arr, i, pos);
			}
		}
	}

	private static void rightShift(int[] arr, int i, int pos) {
		int num = arr[pos];
		for(int j = pos; j > i; j--){
			arr[j] = arr[j-1];
		}
		arr[i] = num;
	}

}
