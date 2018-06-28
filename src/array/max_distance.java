package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class max_distance {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(3,5,4,2));
		System.out.println(maximumGap(arr));
	}

	private static int maximumGap(final List<Integer> arr) {
		List<Integer> temp = new ArrayList<Integer>();
		List<Integer> index = new ArrayList<Integer>();
		int ind = 0;
		for(Integer ele : arr) {
			temp.add(ele);
			index.add(ind);
			ind++;
		}
		Collections.sort(index, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return arr.get(a) < arr.get(b) ? -1 : 1;
			}
		});
		ArrayList<Integer> indexMax = new ArrayList<Integer>(Collections.nCopies(index.size(), 0));
		int maxIndex = Integer.MIN_VALUE;
		for(int i = index.size() - 1; i >= 0; i--) {
			maxIndex = Math.max(maxIndex, index.get(i));
			indexMax.set(i, maxIndex);
		}
		int ans = Integer.MIN_VALUE;
		for(int i = 0; i < index.size(); i++) {
			if(indexMax.get(i) - index.get(i) > ans)
				ans = indexMax.get(i) - index.get(i);
		}
		return ans;
	}

}
