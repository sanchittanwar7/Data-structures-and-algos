package recursion;

public class returnSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abc";
		String ans[] = returnSubsequence(str);
		for(String s : ans)
			System.out.println(s);
	}

	private static String[] returnSubsequence(String str) {
		if(str.length() == 0){
			String ans[] = new String[1];
			ans[0] = "";
			return ans;
		}
		String temp[] = returnSubsequence(str.substring(1));
		String ans[] = new String[temp.length * 2];
		int pos = 0;
		for(int i = 0; i < temp.length; i++){
			ans[pos] = temp[i];
			pos++;
		}
		for(int i = 0; i < temp.length; i++){
			ans[pos] = str.charAt(0) + temp[i];
			pos++;
		}
		return ans;
	}

}
