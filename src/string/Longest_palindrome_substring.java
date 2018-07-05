package string;

public class Longest_palindrome_substring {

	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
		System.out.println(longestPalindromeSubstring(str));
	}

	private static String longestPalindromeSubstring(String str) {
		int maxLength = 1;
        int start = 0;
        int len = str.length();
        int low, high;
        for (int i = 1; i < len; ++i) {
            low = i - 1;
            high = i;
            while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }
        return str.substring(start, start + maxLength);
	}

}
