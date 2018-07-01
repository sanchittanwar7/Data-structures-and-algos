package Maths;

import java.util.Arrays;

public class sorted_permutation_rank {

	public static void main(String[] args) {
		String str = "zyxwvutsrqponmlkjihgfedcba";
		System.out.println(find(str));
	}

	private static int find(String str) {
		return (int) (findRank(str)%1000003);
	}

	private static long findRank(String str) {
		if(str.length() == 1)
			return 1;
		char[] smallest  = str.toCharArray();
		Arrays.sort(smallest);
		String sorted = new String(smallest);
		long ans = 0, prevAns;
		int i = 0;
		long fact = fact(str.length()-1);
		while(i < sorted.length() && sorted.charAt(i) < str.charAt(0)) {
			ans += fact;
			i++;
		}
		return (ans + findRank(str.substring(1))%1000003);
	}

	private static long fact(int i) {
		if(i <= 1)
			return 1;
		return i*fact(i-1);
	}

}
