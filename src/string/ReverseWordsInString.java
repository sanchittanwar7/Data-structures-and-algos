package string;

public class ReverseWordsInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "this is a string";
		System.out.println(reverse(str));
	}

	private static String reverse(String str) {
		int start = 0, end;
		while(start < str.length()){
			end = start;
			while(end < str.length() && str.charAt(end) != ' ')
				end++;
			str = str.substring(0, start) + reverseHelper(str.substring(start, end)) + str.substring(end);
			start = end + 1;
		}
		return reverseHelper(str);
	}

	private static String reverseHelper(String substring) {
		if(substring.length() == 1)
			return substring;
		int last = substring.length() - 1;
		return substring.charAt(last) + reverseHelper(substring.substring(0, last));
	}

}
