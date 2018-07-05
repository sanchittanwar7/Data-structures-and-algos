package string;

import java.util.Arrays;

public class min_char_to_make_palindrome {

	public static void main(String[] args) {
		String str = "abcde";
		System.out.println(insertAnywhere(str));
	}
	
	public static boolean ispalindrome(String s){
	    int l = s.length(), j, i;
	    for(i = 0, j = l - 1; i <= j; i++, j--){
	        if(s.charAt(i) != s.charAt(j))
	            return false;
	    }
	    return true;
	}

	private static int insertAtBeginning(String s) {
		int count = 0;
	    while(s.length()>0){
	        if(ispalindrome(s))
	             break;
	        else{
	        	count++;
	        	s = s.substring(0, s.length() - 1);
	        }
	    }
	    return count;
	}

	private static int insertAnywhere(String str) {
		int n = str.length(), i, turn, j;
		int[][] arr = new int[n][n];
		for(turn = 1; turn < n; turn++) {
			for(i = 0, j = turn; j < n; i++, j++) {
				if(str.charAt(i) == str.charAt(j))
					arr[i][j] = arr[i+1][j-1];
				else {
					arr[i][j] = 1 + Math.min(arr[i][j-1], arr[i+1][j]);
				}
			}
		}
		return arr[0][n-1];
	}

}
