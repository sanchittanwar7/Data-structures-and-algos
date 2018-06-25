package array;

import java.util.ArrayList;
import java.util.Arrays;

public class max_non_negative_subarray {
	//1 2 3 -1 6 -1 2
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(5);
		A.add(-7);
		A.add(2);
		A.add(3);
		ArrayList<Integer> B = new ArrayList<Integer>();
		B.add(1);
		B.add(2);
		B.add(3);
		B.add(-1);
		B.add(6);
		B.add(-1);
		B.add(-2);
		ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368));
		System.out.println(maxset(C));
		A = maxset(A);
		B = maxset(B);
		System.out.println(A);
		System.out.println(B);
	}
	
	public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
		int start = 0, maxStart = 0, maxEnd = A.size()-1, end = -1;
		long sum = 0, maxSum = Integer.MIN_VALUE;
		for(int i = 0; i < A.size(); i++) {
			if(A.get(i) >= 0) {
				sum += A.get(i);
				end = i;
			}
			else {
				end = i-1;
				if(sum > maxSum) {
					maxSum = sum;
					maxStart = start;
					maxEnd = end;
				}
				sum = 0;
				start = i+1;
			}
		}
		if(sum > maxSum) {
			maxSum = sum;
			maxStart = start;
			maxEnd = end;
		}
		return new ArrayList<Integer>(A.subList(maxStart, maxEnd+1));
    }

}
