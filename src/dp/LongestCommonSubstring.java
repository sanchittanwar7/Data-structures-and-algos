package dp;

public class LongestCommonSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "abab";
		String str2 = "baba";
		System.out.println(lcs(str1, str2));
	}

	public static String lcs(String str1, String str2) {
		int m = str1.length(), n = str2.length(), i, j, ans = -1, max = 0;
		int arr[][] = new int[m+1][n+1];
		for(i = 0; i <= m; i++){
			for(j = 0; j <= n; j++){
				if(i == 0 || j == 0)
					arr[i][j] = 0;
				else{
					if(str1.charAt(i-1) == str2.charAt(j-1)){
						arr[i][j] = 1 + arr[i-1][j-1];
						if(arr[i][j] >= max){
							max = arr[i][j];
							ans = j-1;
						}
					}
					else
						arr[i][j] = 0;
				}
			}
		}
		return str1.substring(ans - max + 1, ans + 1);
	}

}
