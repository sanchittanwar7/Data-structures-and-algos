package array;

import java.util.ArrayList;

public class find_permutation {

	public static void main(String[] args) {
		int n = 9;
		String str = "DDIDDIID";
		ArrayList<Integer> ans = findPerm(str, str.length()+1);
		System.out.println(ans);
	}

	private static ArrayList<Integer> findPerm(String str, int n) {
		int min = 1, max = n;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'D') {
				ans.add(max);
				max--;
			}
			else {
				ans.add(min);
				min++;
			}
		}
		ans.add(min);
		return ans;
	}

}
