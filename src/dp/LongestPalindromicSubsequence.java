package dp;

public class LongestPalindromicSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		String str_r = reverse(str);
		System.out.println(LongestCommonSubsequence.lcs(str, str_r));
	}

	public static String reverse(String str) {
		if(str.length() == 1)
			return str;
		return reverse(str.substring(1)) + str.charAt(0);
	}

}
