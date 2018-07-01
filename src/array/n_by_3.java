package array;

import java.util.ArrayList;
import java.util.Arrays;

public class n_by_3 {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3,1,1));
		System.out.println(repeatedNumber(arr));
	}

	private static int repeatedNumber(ArrayList<Integer> arr) {
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
		int count1 = 0, count2 = 0, i;
		for(i = 0; i < arr.size(); i++) {
			if(arr.get(i) == first)
				count1++;
			else if(arr.get(i) == second)
				count2++;
			else if(count1 == 0) {
				first = arr.get(i);
				count1++;
			}
			else if(count2 == 0) {
				second = arr.get(i);
				count2++;
			}
			else {
				count1--;
				count2--;
			}
		}
		count1 = count2 = 0;
		for(i = 0; i < arr.size(); i++) {
			if(arr.get(i) == first)
				count1++;
			else if(arr.get(i) == second)
				count2++;
		}
		if(count1 > arr.size()/3)
			return first;
		if(count2 > arr.size()/3)
			return second;
		return -1;
	}

}
