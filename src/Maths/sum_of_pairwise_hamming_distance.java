package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sum_of_pairwise_hamming_distance {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(23 ,76 ,12 ,65 ,87 ));
		System.out.println(hammingDistance(arr));
	}
	
	public static int hammingDistance(final List<Integer> arr) {
		long i, j, ans = 0;
		for(i = 0; i < arr.size(); i++) {
			for(j = i+1; j < arr.size(); j++) {
				ans += countOne(arr.get((int) i)^arr.get((int) j));
			}
		}
		return (int) ((2*ans)%1000000007);
    }

	private static long countOne(int n) {
		long oneCount = 0;
		while(n > 0) {
			if(n%2 == 1)
				oneCount++;
			n /= 2;
		}
		return oneCount;
	}

}
