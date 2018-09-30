package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class substring_concatenation {

	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		ArrayList<String> l = new ArrayList<>(Arrays.asList("aaa", "aaa", "aaa", "aaa", "aaa"));
		ArrayList<Integer> ans = findSubstring(s, l);
		System.out.println(ans);
	}

	public static ArrayList<Integer> findSubstring(String s, final List<String> l) {
		ArrayList<Integer> ans = new ArrayList<>();
		int n = l.size();
		if(n == 0)
			return ans;
		int x = l.get(0).length(), prev;
		if(s.length() < n*x)
			return ans;
		HashMap<String, Integer> map = new HashMap<>();
		String word;
		for(String str : l) {
			if(map.containsKey(str)) {
				prev = map.get(str);
				map.put(str, prev+1);
			}
			else {
				map.put(str, 1);
			}
		}
		int start = 0, end = n*x-1, i, t_start;
		HashMap<String, Integer> temp_map;
		boolean missing;
		while(end < s.length()) {
			t_start = start;
			missing = false;
			temp_map = (HashMap<String, Integer>) map.clone();
			for(i = 0; i < n; i++) {
				word = s.substring(t_start, t_start+x);
				t_start += x;
				if(!temp_map.containsKey(word))
					missing = true;
				else {
					prev = temp_map.get(word);
					if(prev == 1)
						temp_map.remove(word);
					else
						temp_map.put(word, prev-1);
				}
			}
			if(!missing) {
				ans.add(start);
			}
			start++;
			end++;
		}
		return ans;
	}

}
