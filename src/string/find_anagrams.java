package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class find_anagrams {

	public static void main(String[] args) {
		String s = "abab", p = "ab";
		List<Integer> ans = findAnagrams(s, p);
		System.out.println(ans);
	}

	public static List<Integer> findAnagrams(String s, String p) {
		int s1[] = new int[26], p1[] = new int[26];
		List<Integer> ans = new ArrayList<>();
		for(int i = 0; i < p.length(); i++) {
			s1[s.charAt(i) - 'a']++;
			p1[p.charAt(i) - 'a']++;
		}
		if(Arrays.equals(s1, p1))
			ans.add(0);
		int begin = 0, end = p.length()-1;
		while(end+1 < s.length()) {
			s1[s.charAt(begin++) - 'a']--;
			s1[s.charAt(++end) - 'a']++;
			if(Arrays.equals(s1, p1))
				ans.add(begin);
		}
		return ans;
	}

}
