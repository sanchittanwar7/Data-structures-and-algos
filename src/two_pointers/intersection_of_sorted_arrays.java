package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intersection_of_sorted_arrays {

	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1, 12, 14, 17, 18, 18, 27, 31, 31, 32, 33, 38, 39, 45, 46, 46, 47, 49, 50, 54, 54, 55, 56, 58, 61, 65, 65, 67, 68, 70, 72, 75, 76, 79, 80, 81, 84, 88, 88, 88, 89, 90, 94, 96, 96, 98, 100 ));
		ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList( 2, 3, 4, 5, 5, 6, 7, 7, 9, 10, 17, 22, 24, 27, 27, 30, 31, 33, 33, 36, 37, 40, 41, 43, 45, 45, 47, 47, 48, 51, 54, 54, 54, 61, 65, 65, 67, 67, 68, 68, 74, 76, 80, 81, 86, 87, 90, 92, 95, 97, 97, 98, 98, 98, 101));
		ArrayList<Integer> ans = intersect(a1, a2);
		System.out.println(ans);
	}
	
	public static ArrayList<Integer> intersect(final List<Integer> a1, final List<Integer> a2) {
		ArrayList<Integer> ans = new ArrayList<>();
		int i = 0, j = 0, n1 = a1.size(), n2 = a2.size();
//		System.out.println(n1 + " " + n2);
		while(i < n1 && j < n2) {
			if(a1.get(i).equals(a2.get(j))) {
				ans.add(a1.get(i));
				i++;
				j++;
			}
//			System.out.println(i + " " + j);
//			if(i >= n1 || j >= n2)
//				break;
			while(j < n2 && i < n1 && a1.get(i) < a2.get(j))
				i++;
			while(i < n1 && j < n2 && a2.get(j) < a1.get(i))
				j++;
		}
		return ans;
    }

}
