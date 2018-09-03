package string;

import java.math.BigInteger;
import java.util.Scanner;

public class nissan_bit_flipping {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(), len = Integer.MIN_VALUE, i;
		String str[] = new String[n];
		for(i = 0; i < n; i++) {
			str[i] = s.next();
			if(str[i].length() > len)
				len = str[i].length();
		}
		for(i = 0; i < str.length; i++) {
			str[i] = rightPadZeros(str[i], len);
		}
		String ans = calc(str, len);
		long one_count = 0;
		for(i = 0; i < ans.length(); i++)
			if(ans.charAt(i) == '1')
				one_count++;
		if(one_count % 2 == 0)
			System.out.println("B");
		else
			System.out.println("A");
		System.out.println(one_count);
	}

	private static String calc(String[] str, int len) {
		BigInteger a = new BigInteger("0");
		for(String s : str) {
			a = a.or(new BigInteger(s, 2));
		}
		long x = a.longValue();
		return a.toString(2);
	}

	public static String rightPadZeros(String str, int num) {
		return String.format("%1$-" + num + "s", str).replace(' ', '0');
	}

}
