package Maths;

import java.util.ArrayList;
import java.util.Arrays;

public class hard_queries {
	
	public static final long M = 1000000007;
	
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<ArrayList<Integer>> b = new ArrayList<>();
		b.add(new ArrayList<>(Arrays.asList(2,1,1)));
		b.add(new ArrayList<>(Arrays.asList(2,1,2)));
		b.add(new ArrayList<>(Arrays.asList(1,3,1)));
		b.add(new ArrayList<>(Arrays.asList(2,1,3)));
		System.out.println(solve(a, b));
	}
	
	public static int solve(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> b) {
		long count = 0;
		for(ArrayList<Integer> arr : b) {
			if(arr.get(0) == 1) {
				a.set(arr.get(1)-1, arr.get(2));
			}
			else {
				count = (count + count(a, arr.get(1), arr.get(2)))%M;
			}
		}
		return (int) count;
    }

	private static long count(ArrayList<Integer> a, Integer start, Integer end) {
		long c = 0;
		int ele, low, high;
		for(int i = start-1; i <= end-1; i++) {
			ele = a.get(i);
			low = ele - (int)(Math.sqrt(ele)) * (int)(Math.sqrt(ele));
			high = (int)(Math.sqrt(ele) + 1) * (int)(Math.sqrt(ele) + 1) - ele;
			c += Math.min(low, high);
		}
		return c;
	}

}
