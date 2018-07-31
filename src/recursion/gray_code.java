package recursion;

import java.util.ArrayList;

public class gray_code {
	
	public static void main(String[] args) {
		int n = 2;
		System.out.println(grayCode(n));
	}
	
	public static ArrayList<Integer> grayCode(int n) {
		String[] s = helper(n);
		ArrayList<Integer> ans = new ArrayList<>();
		for(String str : s) {
			ans.add(Integer.parseInt(str, 2));
		}
		return ans;
    }

	private static String[] helper(int n) {
		if(n == 1) {
			String[] s = new String[2];
			s[0] = "0";
			s[1] = "1";
			return s;
		}
		String[] temp = helper(n-1);
		String[] ans = new String[temp.length*2];
		int i, index = 0;
		for(i = 0; i < temp.length; i++, index++) {
			ans[index] = "0" + temp[i];
			index++;
			ans[index] = "1" + temp[i];
		}
		return ans;
	}

}
