package string;

import java.util.HashMap;

public class roman_to_int {

	public static void main(String[] args) {
		String str1 = "MDCCLXXVI";
		String str2 = "MCMLIV";
		String str3 = "MCMXC";
		String str4 = "MMXIV";
		String str5 = "MMXVIII";

		System.out.println(romanToInt(str1));
		System.out.println(romanToInt(str2));
		System.out.println(romanToInt(str3));
		System.out.println(romanToInt(str4));
		System.out.println(romanToInt(str5));

	}

	private static int romanToInt(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 0);
		map.put('V', 1);
		map.put('X', 2);
		map.put('L', 3);
		map.put('C', 4);
		map.put('D', 5);
		map.put('M', 6);
		int[] arr = {1,5,10,50,100,500,1000};
		int ans = 0;
		for(int i = 0; i < str.length()-1; i++) {
			if(map.get(str.charAt(i)) >= map.get(str.charAt(i+1)))
				ans = ans + arr[map.get(str.charAt(i))];
			else
				ans = ans - arr[map.get(str.charAt(i))];
		}
		return ans + arr[map.get(str.charAt(str.length()-1))];

	}

}
