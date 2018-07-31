package hashing;

import java.util.HashMap;

public class colorful_number {

	public static void main(String[] args) {
		int n = 100;
		System.out.println(colorful(n));
	}
	
	public static int colorful(int n) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		char[] num = Integer.toString(n).toCharArray();
		int windowSize = 1, start, end, prod;
		int numLen = num.length;
		while(windowSize <= numLen) {
			start = 0;
			end = 0;
			prod = 1;
			while(end - start <= windowSize - 1) {
				prod *= (num[end] - 48);
				end++;
			}
			System.out.println(prod);
			if(map.containsKey(prod))
				return 0;
			map.put(prod, true);
			while(end < num.length) {
				prod = prod*(num[end]-48)/(Math.max(num[start]-48, 1));
				start++;
				end++;
				System.out.println(prod);
				if(map.containsKey(prod))
					return 0;
				map.put(prod, true);
			}
			windowSize++;
		}
		return 1;
    }

}
