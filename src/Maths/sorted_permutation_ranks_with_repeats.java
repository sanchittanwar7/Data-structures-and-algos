package Maths;

import java.math.BigInteger;
import java.util.Arrays;

public class sorted_permutation_ranks_with_repeats {

	public static void main(String[] args) {
		String str = "baa";
		System.out.println(str.length());
		System.out.println(findRank(str));
	}

	private static int findRank(String str) {
		if(str.length() == 1)
			return 1;
		str = str.toLowerCase();
		char[] smallest  = str.toCharArray();
		Arrays.sort(smallest);
		String sorted = new String(smallest);
		int i;
//		System.out.println(sorted);
		int[] freq = new int[26];
		for(i = 0; i < str.length(); i++) {
			freq[str.charAt(i)-97]++;
		}
		System.out.println(Arrays.toString(freq));
//		System.out.println(str + " " + sorted);
		double div = calc(str.length()-1, freq);
//		long fact = fact(str.length()-1);
//		long repeat = 1;
//		for(int j = 0; j < freq.length; j++)
//			repeat *= fact(freq[j]);
//		System.out.println(fact + " " + repeat);
		double ans = 0;
		i = 0;
		while(i < sorted.length() && sorted.charAt(i) < str.charAt(0)) {
			ans += div;
			ans %= 1000003;
			i++;
		}
		System.out.println(i);
		System.out.println(ans);
		return ((int)ans + findRank(str.substring(1)))%1000003;
	}

	private static double calc(int i, int[] freq) {
		BigInteger iFact = fact(i);
		BigInteger freqFact = new BigInteger("1");
		for(int j = 0; j < freq.length; j++) {
			freqFact.multiply(fact(freq[j]));
		}
		iFact = iFact.divide(freqFact);
		return iFact.doubleValue();
	}

	private static BigInteger fact(int i) {
		BigInteger fact = new BigInteger("1");
		for(; i > 0; i--) {
			fact = fact.multiply(new BigInteger(Integer.toString(i)));
//			fact %= 1000003;
		}
		return fact;
	}

}
