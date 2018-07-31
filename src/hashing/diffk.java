package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class diffk {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29));
		int n = 97;
		System.out.println(diff(arr, n));
	}

	private static int diff(ArrayList<Integer> arr, int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.size(); i++) {
			map.put(arr.get(i), i);
		}
		for(int i = 0; i < arr.size(); i++) {
			if(map.containsKey((arr.get(i) - n)) && map.get((arr.get(i) - n)) != i) {
				System.out.println(arr.get(i));
				System.out.println(map.containsKey(Math.abs(arr.get(i) - n)));
				return 1;
			}
		}
		return 0;
	}

}
