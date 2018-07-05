package string;

public class implement_strStr {

	public static void main(String[] args) {
		String haystack = "b", needle = "b";
		System.out.println(strStr(haystack, needle));
	}
	
	public static int strStr(final String haystack, final String needle) {
		if(needle.length() > haystack.length() || needle.length() == 0)
			return -1;
		String comparator = haystack.substring(0, needle.length());
		int index = needle.length();
		while(index <= haystack.length()) {
			if(needle.equals(comparator))
				return index - needle.length();
			if(index == haystack.length())
				break;
			comparator = comparator.substring(1) + haystack.charAt(index);
			index++;
		}
		return -1;
    }

}
