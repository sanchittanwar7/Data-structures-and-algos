package dp;

public class LongestPalindromicSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
		String str_r = LongestPalindromicSubsequence.reverse(str);
		System.out.println(LongestCommonSubstring.lcs(str, str_r));
	}

}
