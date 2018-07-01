package Maths;

import java.util.ArrayList;

public class prime_sum {

	public static void main(String[] args) {
		int n = 12;
		ArrayList<Integer> ans = primesum(n);
		System.out.println(ans);
	}

	private static ArrayList<Integer> primesum(int n) {
		int i;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(i = 2; i <= n/2; i++) {
			if(isPrime(i) && isPrime(n-i)) {
				ans.add(i);
				ans.add(n-i);
				break;
			}
		}
		return ans;
	}

	private static boolean isPrime(int n) {
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0)
				return false;
		}
		return true;
	}

}
