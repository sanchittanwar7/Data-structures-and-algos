package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class merge_sorted_lists {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3));
		ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(-4,-3));
		merge(arr, arr1);
		System.out.println(arr);
	}
	
	public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int i = 0, j = 0, t = 0;
		int n1 = a.size(), n2 = b.size();
		while(i < a.size() && j < n2) {
			if(a.get(i) < b.get(j)) {
				i++;
			}
			else {
				a.add(i, b.get(j));
				j++;
				i++;
			}
		}
		while(j < n2) {
			a.add(b.get(j));
			j++;
		}
    }

}
