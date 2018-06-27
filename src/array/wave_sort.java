package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class wave_sort {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(6, 1, 5, 2, 8, 0, 7));
		arr = wave(arr);
		System.out.println(arr);
	}

	private static ArrayList<Integer> wave(ArrayList<Integer> arr) {
		Collections.sort(arr);
		for(int i = 0; i+1 < arr.size(); i+=2) {
			Collections.swap(arr, i, i+1);
		}
		return arr;
	}

}
