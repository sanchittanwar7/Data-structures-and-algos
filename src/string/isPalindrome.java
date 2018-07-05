package string;

public class isPalindrome {

	public static void main(String[] args) {
		String str1 = "A man, a plan, a canal: Panama", str2 = "A man, a plan, a canal: Panama'";
		System.out.println(isPalindrome(str2));
	}

	private static int isPalindrome(String str) {
		int start = 0, end = str.length()-1;
//		System.out.println(start + " " + end);
		str = str.toLowerCase();

		while( (start < str.length()) && !((str.charAt(start) >= 97 && str.charAt(start) <= 122) || (str.charAt(start) >= 48 && str.charAt(start) <= 57)))
			start++;
		while( (end >= 0) && !((str.charAt(end) >= 97 && str.charAt(end) <= 122) || (str.charAt(end) >= 48 && str.charAt(end) <= 57)))
			end--;
//		System.out.println(start + " " + end);

		while(start <= end) {
			if(str.charAt(start) != str.charAt(end))
				return 0;
			start++;end--;
			while( (start < str.length()) && !((str.charAt(start) >= 97 && str.charAt(start) <= 122) || (str.charAt(start) >= 48 && str.charAt(start) <= 57)))
				start++;
			while( (end >= 0) && !((str.charAt(end) >= 97 && str.charAt(end) <= 122) || (str.charAt(end) >= 48 && str.charAt(end) <= 57)))
				end--;
		}
		return 1;
	}

}
