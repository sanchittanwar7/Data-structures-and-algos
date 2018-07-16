package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class diffk {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4));
		int n = 0;
		System.out.println(diffPossible(a, n));
	}
	
	public static int diffPossible(ArrayList<Integer> a, int n) {
		if(a.size() < 2)
			return 0;
		int start = 0, end = 1;
		while(end < a.size()) {
			if(start != end && a.get(end) - a.get(start) == n) {
				return 1;
			}
			if(a.get(end) - a.get(start) <= n)
				end++;
			else
				start++;
		}
		end--;	
		while(start < end && a.get(end) - a.get(start) > n)
			start++;
		if(start != end && a.get(end) - a.get(start) == n)
			return 1;
		return 0;
    }

}
