package hashing;

import java.util.HashMap;

public class hashing {

	public static void main(String[] args) {
		String s1 = "ADOBECODEBANC";
		String s2 = "ABC";
		System.out.println(minWindow(s1, s2));
	}
	
	public static String minWindow(String s1, String s2) {
		HashMap<Character, Boolean> map = new HashMap<>();
		String ans = "";
		int include = 0, minLen = Integer.MAX_VALUE, answer = -1;
		for(int i = 0; i < s2.length(); i++)
			map.put(s2.charAt(i), true);
		String ansStr = "";
		for(int j = 0; j < s1.length(); j++) {
			ans += s1.charAt(j);
			if(map.containsKey(s1.charAt(j))) {
				include++;
				map.remove(s1.charAt(j));
			}
			if(include >= s2.length()) {
//				System.out.println("calculating...");

				while(ans.length() > 0 && !map.containsKey(ans.charAt(0))) {
					ans = ans.substring(1);
				}
				if(ans.length() < minLen) {
					minLen = ans.length();
					answer = include;
					ansStr = new String(ans);
				}
				map.put(ans.charAt(0), true);
				ans = ans.substring(1);
				include--;
			}
//			System.out.println(ans + " " + include);
		}
//		System.out.println(answer);
		return answer == s2.length() ? ansStr : "";
    }

}
