package string;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String atr = "abc";
		test(atr.substring(4, atr.length()));
	}

	private static void test(String substring) {
		System.out.println(substring.length());
		System.out.println("DOne");		
	}

}
