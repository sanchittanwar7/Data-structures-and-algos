package dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "ABCDGH";
		String str2 = "AEDFHR";
		System.out.println(lcs(str1, str2));
	}

	public static String lcs(String str1, String str2) {
		int m = str1.length(), n = str2.length(), i, j = 0;
		String str = "";
		int arr[][] = new int[m + 1][n + 1];
		for(i = 0; i <=m; i++){
			for(j = 0; j <=n; j++){
				if(i == 0 || j == 0)
					arr[i][j] = 0;
				else{
					if(str1.charAt(i - 1) == str2.charAt(j - 1))
						arr[i][j] = 1 + arr[i - 1][j - 1];
					else
						arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		i = m;
		j = n;
		while(i > 0 && j > 0){
			if(str1.charAt(i-1) == str2.charAt(j-1)){
				str = str1.charAt(i-1) + str;
				i--;
				j--;
			}
			else{
				if(arr[i-1][j] > arr[i][j-1])
					i--;
				else
					j--;
			}
		}
		return str;
	}

}
