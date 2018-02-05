package string;

public class ShortestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abab";
		String str1 = "abcd";
		String str2 = "ananab";
		String str3 = "java";
		System.out.println(minPalindrome(str3) + str3);
	}

	private static String minPalindrome(String str) {
		int end = str.length() - 1;
		while(end > 0){
			while(str.charAt(end) != str.charAt(0)){
				end--;
				if(end == 0)
					break;
			}
			if(isPalindrome(str.substring(0, end + 1)))
				break;
			end--;
		}
		return new StringBuilder(str.substring(end + 1)).reverse().toString();
	}

	private static boolean isPalindrome(String str) {
		if(str.length() <= 1)
			return true;
		if(str.charAt(0) != str.charAt(str.length() - 1))
			return false;
		return isPalindrome(str.substring(1, str.length() - 1));
	}

}
