package array;

import java.util.Scanner;

public class AllCodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String code = s.next();
		String ans[] = decrypt(code);
		for(String str : ans)
			System.out.println(str);
	}

	private static String[] decrypt(String code) {
		if(code == null){
			String ans[] = new String[0];
			return ans;
		}
		if(code.length() <= 0){
			String ans[] = new String[1];
			ans[0] = "";
			return ans;
		}
		int i;
		String start = code.length() >= 2 ? code.substring(2) : null;
		String ans1[] = decrypt(code.substring(1));
		String ans2[] = decrypt(start);
		String code1 = getEquivalent(code.substring(0, 1));
		String code2 = code.length() >= 2 ? getEquivalent(code.substring(0, 2)) : "";
		for(i = 0; i < ans1.length; i++){
			ans1[i] = code1 + ans1[i];
		}
		for(i = 0; i < ans2.length; i++){
			ans2[i] = code2 + ans2[i];
		}
		String ans[] = new String[ans1.length + ans2.length];
		int pos = 0;
		for(i = 0; i < ans1.length; i++){
			ans[pos] = ans1[i];
			pos++;
		}
		for(i = 0; i < ans2.length; i++){
			ans[pos] = ans2[i];
			pos++;
		}
		return ans;
	}

	private static String getEquivalent(String substring) {
		int num = toInt(substring);
		if(num > 26)
			return "";
		return "" + (char)(num + 96);
	}

	private static int toInt(String substring) {
		int num = 0;
		char arr[] = substring.toCharArray();
		for(char c : arr){
			num = num*10 + (c - 48);
		}
		return num;
	}	
	

}
