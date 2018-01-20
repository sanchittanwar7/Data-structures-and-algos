package array;

import java.util.Arrays;

public class RainWaterTrapping {

	/**
	 * @param args
	 */
	
	//{1,5,2,3,1,7,2}
	
	public static void main(String[] args) {
		int arr[] = {1,5,2,3,1,7,2};
		System.out.println(water(arr));
	}

	private static int water(int[] arr) {
		int maxLeft[] = new int[arr.length];
		int maxRight[] = new int[arr.length];
		int max = -1, rainWater = 0;
		for(int i = 0; i < maxLeft.length; i++){
			maxLeft[i] = max;
			if(arr[i] > max)
				max = arr[i];
		}
		max = -1;
		for(int i = maxRight.length - 1; i >= 0; i--){
			maxRight[i] = max;
			if(arr[i] > max)
				max = arr[i];
		}
		for(int i = 0; i < arr.length; i++){
			rainWater += Math.max(Math.min(maxLeft[i], maxRight[i]) - arr[i], 0);
		}
		return rainWater;
	}

}
