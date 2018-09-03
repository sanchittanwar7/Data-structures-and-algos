package string;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "GEEKSFORGEEKS";
		String str1 = "ABCD";
		String str2 = "BB";
//		getString(str);
		System.out.println(lengthOfLongestSubstring(str));
	}

	private static void getString(String str) {
		int startAns = 0, endAns = 1, start = 0, end = 0, max = Integer.MIN_VALUE, pos, len;
		int arr[] = new int[26];
		while(end < str.length()){
			pos = (int)str.charAt(end) - 65;
			if(arr[pos] == 0){
				arr[pos]++;
				end++;
			}
			else{
				len = end - start; 
				if(len > max){
					max = len;
					startAns = start;
					endAns = end;
				}
				while(start < end){
					pos = str.charAt(start) - 65;
					arr[pos] = 0;
					start++;
				}
				end++;
			}
		}
		System.out.println(startAns + " " + endAns);
		System.out.println(str.substring(startAns, endAns - 1));
	}
	
	public static int lengthOfLongestSubstring(String A) {
		System.out.println(A);
		HashMap<Character, Boolean> map = new HashMap<>();
		int start = 0, maxLen = Integer.MIN_VALUE, len = 0;
		char str[] = A.toCharArray();
		for(Character c : str) {
			if(!map.containsKey(c)) {
				len++;
				map.put(c, true);
			}
			else {
				if(len > maxLen)
					maxLen = len;
				while(str[start] != c) {
					map.remove(str[start]);
					start++;
					len--;
				}
				start++;
			}
		}
		return Math.max(maxLen, len);
	}

}
