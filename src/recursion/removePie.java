package recursion;

public class removePie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "xpipip";
		String ans = removePie(str);
		System.out.println(ans);
	}

	private static String removePie(String str) {
		if(str.length() == 1)
			return str;
		String ans = removePie(str.substring(1));
		if(str.charAt(0) == 'p' && ans.charAt(0) == 'i')
			return "3.14" + ans.substring(1);
		return str.charAt(0) + ans;
	}

}
