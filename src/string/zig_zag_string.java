package string;

import java.util.Arrays;

public class zig_zag_string {

	public static void main(String[] args) {
		String str = "ABCD";
		int n = 2;
		System.out.println(convert(str, n));
	}

	private static String convert(String str, int n) {
		String[] s = new String[n];
		Arrays.fill(s, "");
		int i, change = 1, current = 0;
		for(i = 0; i < str.length(); i++) {
			s[current] += str.charAt(i);
			current += change;
			if(current <= 0) {
				current = 0;
				change = 1;
			}
			else if(current >= n-1) {
				current = n-1;
				change = -1;
			}
		}
		String ans = "";
		for(String string : s)
			ans += string;
		return ans;
	}

}
