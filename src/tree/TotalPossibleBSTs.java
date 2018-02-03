package tree;

public class TotalPossibleBSTs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(totalBST(5));
	}

	private static int totalBST(int num) {
		return fact(2*num)/(fact(num + 1)*fact(num));
	}

	private static int fact(int i) {
		if(i <= 1)
			return 1;
		return i*fact(i-1);
	}

}
