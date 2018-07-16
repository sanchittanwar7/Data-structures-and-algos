package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class max_contiguous_one {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,1,0 ));
		int n = 2;
		System.out.println(maxone(a, n));
	}

	public static ArrayList<Integer> maxone(ArrayList<Integer> a, int n) {
		int start = 0, end = 0, buffer = n, pSum = 0, maxSum = Integer.MIN_VALUE, startAns = 0, endAns = 0, sumToSubtract, bufferToAdd;
		while(end < a.size()) {
			sumToSubtract = 0; bufferToAdd = 0;
			while(end < a.size() && buffer >= 0) {
				if(a.get(end) == 1)
					pSum += a.get(end);
				else
					buffer--;
				if(pSum >= maxSum && buffer >= 0) {
					System.out.println("start " + start + " startAns : " + startAns + " end : " + end + " pSum : " + pSum + " maxSum : " + maxSum);
					if(pSum != maxSum && start >= startAns) {
						maxSum = pSum;
						startAns = start;
						endAns = end;
					}
//					System.out.println(startAns + " " + endAns);
				}
				end++;
				//				System.out.println("buffer : " + buffer);
			}
			//			System.out.println("start : " + start + " end : " + end);
			while(start < a.size() && a.get(start) == 1) {
				sumToSubtract += 1;
				start++;
			}
			if(start < a.size() && a.get(start) == 0) {
				bufferToAdd += 1;
				start++;
			}
			pSum = pSum - sumToSubtract;
			buffer += bufferToAdd;

		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(;startAns <= endAns; startAns++) {
			ans.add(startAns);
		}
		return ans;
	}

}
