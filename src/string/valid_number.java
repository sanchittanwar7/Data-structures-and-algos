package string;

import java.util.ArrayList;
import java.util.Arrays;

public class valid_number {

	public static void main(String[] args) {
		String str1 = "0";
		String str2 = "  +";
		String str3 = "abc";
		String str4 = "1 a";
		String str5 = "2e1+0";
		String str6 = "0.1e10";
		String str7 = "-01.1e-10";
		String str8 = "     ";
		
//		System.out.println(isNumber(str1));
		System.out.println(isNumber(str2));
//		System.out.println(isNumber(str3));
//		System.out.println(isNumber(str4));
//		System.out.println(isNumber(str5));
//		System.out.println(isNumber(str6));
//		System.out.println(isNumber(str7));
//		System.out.println(isNumber(str8));
	}

	private static int isNumber(String str) {
		String[] arr = str.split("e");
		int signIndex, dotIndex, i = 0, k;
		String s;
		for(int j = 0; j < arr.length; j++) {
			s = arr[j];
			i = 0;
			while(i < s.length() && s.charAt(i) == ' ')
				i++;
			if(s.length() == i)
				return 0;
			s = s.substring(i);
			k = s.length()-1;
			while(k >= 0 && s.charAt(k) == ' ')
				k--;
			s = s.substring(0, k+1);
			dotIndex = -1; signIndex = -1;
			i = 0;
			while(i < s.length()) {
				if(!(s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
					if(s.charAt(i) == '.' && j == 0) {
						if(dotIndex != -1 || i == s.length()-1)
							return 0;
						dotIndex = i;
					}
					else if(s.charAt(i) == '+' || s.charAt(i) == '-') {
						if(signIndex != -1 || i != 0 || i == s.length()-1)
							return 0;
						signIndex = i;
					}
					else {
						return 0;
					}
				}
				i++;
			}
		}
		return 1;
	}

}
