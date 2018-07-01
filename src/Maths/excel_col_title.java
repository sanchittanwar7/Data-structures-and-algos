package Maths;

public class excel_col_title {

	public static void main(String[] args) {
		int n = 943566;
		System.out.println(numberToTitle(n));
	}

	private static String numberToTitle(int n) {
		int remainder;
		String str = "";
		while(n > 0) {
			remainder = n%26;
			System.out.println("remiander : " + remainder);
			if(remainder == 0)
				remainder = 26;
			str = (char)(remainder + 64) + str;
			n -= remainder;
			n /= 26;
		}
		return str;
	}

}
