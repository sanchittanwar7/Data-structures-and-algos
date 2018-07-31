package array;

import java.util.ArrayList;
import java.util.Arrays;

public class triangle {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		arr.add(new ArrayList<>(Arrays.asList(2)));
//		arr.add(new ArrayList<>(Arrays.asList(3, 4)));
//		arr.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
//		arr.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
		System.out.println(minimumTotal(arr));
	}

	public static int minimumTotal(ArrayList<ArrayList<Integer>> arr) {
		ArrayList<Integer> prev = new ArrayList<>(), current = new ArrayList<>();
		prev.add(arr.get(0).get(0));
		int ans = arr.get(0).get(0);
		int top, topLeft, min;
		for(int i = 1; i < arr.size(); i++) {
			ans = Integer.MAX_VALUE;
			current = new ArrayList<>();
			for(int j = 0; j < arr.get(i).size(); j++) {
				top = j == prev.size() ? Integer.MAX_VALUE : prev.get(j);
				topLeft = j == 0 ? Integer.MAX_VALUE : prev.get(j-1);
				min = Math.min(top,  topLeft) + arr.get(i).get(j);
				current.add(min);
				if(min < ans)
					ans = min;
			}
			prev = current;
		}
		return ans;
	}

}
