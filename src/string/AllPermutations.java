package string;

public class AllPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abcde";
		String ans[] = getPermutation(str);
		for(String string : ans)
			System.out.println(string);
	}

	private static String[] getPermutation(String str) {
		if(str.length() == 1){
			String ans[] = new String[1];
			ans[0] = "" + str.charAt(0);
			return ans;
		}
		String temp[] = getPermutation(str.substring(1));
		String ans[] = new String[(temp[0].length() + 1) * temp.length];
		String tempStr;
		int pos = 0;
		for(int i = 0; i < temp.length; i++){
			for(int j = 0; j <= temp[i].length(); j++){
				tempStr = j + 1 > temp[i].length() ? "" : temp[i].substring(j);
				ans[pos] = temp[i].substring(0, j) + str.charAt(0) + tempStr;
				pos++;
			}
		}
		return ans;
	}

}
