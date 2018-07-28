package two_pointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class largest_rectangle {

	public static void main(String[] args) {
		int a[] = {2,1,5,6,2,3};
		System.out.println(height(a));
	}

	private static int height(final int[] a) {
		List<Integer> arr = new ArrayList<>();
		for(int i = 0; i < a.length; i++)
			arr.add(i);
		Collections.sort(arr, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return a[o1] > a[o2] ? 1 : -1;
			}
		});
		System.out.println(arr);
		int maxArea = a[arr.get(0)] * (a.length);
		int i = 0, j = a.length-1;
		while(i <= j) {
			
		}
		return -1;
	}

}
