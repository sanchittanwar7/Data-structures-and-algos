package array;

import java.util.ArrayList;
import java.util.Arrays;

public class max_absolute_difference {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 3, -1));
		System.out.println(maxArr(arr));
		System.out.println(maxDistance(arr));
	}
	
	public static int maxArr(ArrayList<Integer> arr) {
		int ans = 0, i, j, diff;
		for(i = 0; i < arr.size(); i++) {
			for(j = i+1; j < arr.size(); j++) {
				diff = Math.abs(arr.get(i) - arr.get(j)) + Math.abs(i - j);
				if(diff > ans)
					ans = diff;
			}
		}
		return ans;
    }
	
	private static int maxDistance(ArrayList<Integer> array){
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
 
        for (int i = 0; i < array.size(); i++){
            max1 = Math.max(max1, array.get(i) + i);
            min1 = Math.min(min1, array.get(i) + i);
            max2 = Math.max(max2, array.get(i) - i);
            min2 = Math.min(min2, array.get(i) - i);
        }
        return Math.max(max1 - min1, max2 - min2);
    }

}
