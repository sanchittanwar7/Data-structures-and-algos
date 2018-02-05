package string;

public class LongestSubstringWithoutRepeatingCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "GEEKSFORGEEKS";
		String str1 = "ABDEFGABEF";
		String str2 = "BBBBB";
		getString(str2);
	}

	private static void getString(String str) {
		int startAns = 0, endAns = 1, start = 0, end = 1, max = Integer.MIN_VALUE, pos, len;
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
		System.out.println(str.substring(startAns, endAns - 1));
	}

}
