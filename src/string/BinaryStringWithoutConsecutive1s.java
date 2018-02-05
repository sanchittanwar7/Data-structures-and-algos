package string;

public class BinaryStringWithoutConsecutive1s {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(count(3));
	}

	private static int count(int n) {
		int withZeroAtEnd[] = new int[n+1];
		int withoutZeroAtEnd[] = new int[n+1];
		withoutZeroAtEnd[1] = 1;
		withZeroAtEnd[1] = 1;
		for(int i = 2; i <= n; i++){
			withZeroAtEnd[i] = withZeroAtEnd[i - 1] + withoutZeroAtEnd[i - 1];
			withoutZeroAtEnd[i] = withZeroAtEnd[i - 1];
		}
		return withoutZeroAtEnd[n] + withZeroAtEnd[n];
	}

}
