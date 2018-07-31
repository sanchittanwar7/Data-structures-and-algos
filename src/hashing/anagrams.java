package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class anagrams {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<>(Arrays.asList("cat", "dog", "god", "tca"));
		ArrayList<ArrayList<Integer>> ans = anagrams(arr);
		for(ArrayList<Integer> row : ans)
			System.out.println(row);
	}
	
	public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		char[] ch;
		String str;
		for(int i = 0; i < A.size(); i++) {
			ch = A.get(i).toCharArray();
			Arrays.sort(ch);
			str = String.valueOf(ch);
			if(map.containsKey(str)) {
				arr = map.get(str);
				arr.add(i+1);
				map.put(str, arr);
			}
			else {
				map.put(str, new ArrayList<Integer>(Arrays.asList(i+1)));
			}
		}
		for(String s : map.keySet()) {
			ans.add(map.get(s));
		}
		return ans;
    }

}
