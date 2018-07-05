package string;

import java.util.ArrayList;
import java.util.Collections;

public class longest_common_prefix {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("abcdefgh");
//		arr.add("aefghijk");
		arr.add("abcefgh");
		System.out.println(longestCommonPrefix(arr));
	}
	
	public static String longestCommonPrefix(ArrayList<String> arr) {
		int minLength = Integer.MAX_VALUE, minIndex = -1, i, j;
		boolean thatsIt = false;
		char c;
		for(i = 0; i < arr.size(); i++) {
			if(arr.get(i).length() < minLength) {
				minLength = arr.get(i).length();
				minIndex = i;
			}
		}
		for(j = 0; j < arr.get(minIndex).length(); j++) {
			c = arr.get(minIndex).charAt(j);
			for(i = 0; i < arr.size(); i++) {
				if(arr.get(i).charAt(j) != c) {
					thatsIt = true;
					break;
				}
			}
			if(thatsIt)
				break;
		}
		return arr.get(minIndex).substring(0, j);
    }

}
