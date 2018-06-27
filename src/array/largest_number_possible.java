package array;

import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class largest_number_possible {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412));
		System.out.println(largestNumber(arr));
	}

	public static String largestNumber(final List<Integer> A) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int ele;
		for(Integer ele1 : A)
			arr.add(ele1);
		arr = printLargest(arr);
		String ans = "";
		for(int i = 0; i < arr.size(); i++) {
			ele = arr.get(i);
			ans = ans + Integer.toString(ele);
		}
		if(ans.charAt(0) == '0')
			return "0";
		return (ans);
	}

	public static ArrayList<Integer> printLargest(ArrayList<Integer> arr){
		Collections.sort(arr, new Comparator<Integer>(){
			public int compare(Integer X, Integer Y) {
				Integer XY=(int) (Math.pow(10, (int)(Math.log10(Y)+1))*X + Y);
				Integer YX=(int) (Math.pow(10, (int)(Math.log10(X)+1))*Y + X);
				return XY.compareTo(YX) > 0 ? -1:1;
			}
		});
		return arr;
	}

}
