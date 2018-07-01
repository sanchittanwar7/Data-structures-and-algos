package Maths;

public class excel_col_number {

	public static void main(String[] args) {
		String str = "DFHA";
		System.out.println(titleToNumber(str));
	}

	private static int titleToNumber(String str) {
		int i, p = str.length() - 1, ans = 0;
		for(i = 0; i < str.length(); i++) {
			ans += Math.pow(26, p)*((int)str.charAt(i) - 64);
			p--;
		}
		return ans;
	}

}
