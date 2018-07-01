package array;

import java.util.ArrayList;
import java.util.Arrays;

public class rearrange_array {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(4 ,7 ,2 ,5 ,0 ,3 ,1 ,6 ));
		arrange(arr);
		System.out.println(arr);
	}

	private static void arrange(ArrayList<Integer> arr) {
		Integer[] a1 = new Integer[arr.size()];
        a1 = arr.toArray(a1);
        int n = a1.length, i;
        for(i = 0; i < a1.length; i++) {
        	a1[i] = get(a1, i) + get(a1, get(a1, i)) * n; 
        }
        for(i = 0; i < a1.length; i++) {
        	arr.set(i, a1[i]/n);
        }
	}

	private static Integer get(Integer[] a1, int i) {
		return a1[i] % a1.length;
	}

	

}
