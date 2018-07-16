package recursion;

import java.util.ArrayList;

public class palindrome_partitions {

	static ArrayList<ArrayList<String>> finalAns;

	public static void main(String[] args) {
		String s = "cccaacbcaabb";
		ArrayList<ArrayList<String>> ans = partition(s);
		for(ArrayList<String> str : ans)
			System.out.println(str);

	}

	public static ArrayList<ArrayList<String>> partition(String a) {
		finalAns = new ArrayList<>();
		ArrayList<String> ans = new ArrayList<>();
		helper(a, ans);
		return finalAns;
	}

	private static void helper(String s, ArrayList<String> ans) {
		if(s.length() == 0) {
			finalAns.add(ans);
			return;
		}
		ArrayList<String> temp = new ArrayList<>(ans);
		temp.add(""+s.charAt(0));
		helper(s.substring(1), temp);
		ArrayList<String> index = getFirstPalindrome(s);
		for(String str : index){
			temp = new ArrayList<>(ans);
			temp.add(str);
			helper(s.substring(str.length()), temp);
		}
	}

	private static ArrayList<String> getFirstPalindrome(String s) {
		if(s.length() == 1)
			return new ArrayList<>();
		String reverse;
		ArrayList<String> ans = new ArrayList<>();
		for(int i = 2; i <= s.length(); i++) {
			reverse = new StringBuffer(s.substring(0, i)).reverse().toString();
			if (s.substring(0, i).equals(reverse))
				ans.add(s.substring(0, i));
		}
		return ans;
	}
}
